#!/usr/bin/env python3
"""
extract_manifest_activities.py - Manifest & Component Hierarchy Extractor
Parses decoded AndroidManifest.xml (from APKTool) to extract all Activities,
Services, Receivers, Intent Filters, and UI routing hierarchies.
"""

import os
import sys
import json
import xml.etree.ElementTree as ET
from pathlib import Path

ANDROID_NS = "{http://schemas.android.com/apk/res/android}"

def parse_intent_filters(elem):
    filters = []
    for filter_elem in elem.findall("intent-filter"):
        actions = [a.get(f"{ANDROID_NS}name") for a in filter_elem.findall("action") if a.get(f"{ANDROID_NS}name")]
        categories = [c.get(f"{ANDROID_NS}name") for c in filter_elem.findall("category") if c.get(f"{ANDROID_NS}name")]
        data_schemes = []
        for d in filter_elem.findall("data"):
            scheme = d.get(f"{ANDROID_NS}scheme")
            host = d.get(f"{ANDROID_NS}host")
            path = d.get(f"{ANDROID_NS}path") or d.get(f"{ANDROID_NS}pathPattern") or d.get(f"{ANDROID_NS}pathPrefix")
            data_schemes.append({
                "scheme": scheme,
                "host": host,
                "path": path
            })
        filters.append({
            "actions": actions,
            "categories": categories,
            "data": data_schemes
        })
    return filters

def extract_activities(base_dir: Path, output_dir: Path) -> dict:
    print("=" * 60)
    print("Stage: Extracting Android Manifest Activities & Architecture")
    print("=" * 60)

    manifest_file = output_dir / "apktool_decoded" / "AndroidManifest.xml"
    if not manifest_file.exists():
        manifest_file = base_dir / "extraction_output" / "apktool_decoded" / "AndroidManifest.xml"

    if not manifest_file.exists():
        raise FileNotFoundError(f"Decoded AndroidManifest.xml not found at {manifest_file}")

    print(f"[*] Parsing manifest: {manifest_file}")
    tree = ET.parse(manifest_file)
    root = tree.getroot()

    app_elem = root.find("application")
    if app_elem is None:
        raise ValueError("Application tag not found in AndroidManifest.xml")

    activities = []
    ui_activities = []
    entrypoint_activities = []
    services = []
    receivers = []

    # Parse Activities
    for act in app_elem.findall("activity") + app_elem.findall("activity-alias"):
        name = act.get(f"{ANDROID_NS}name", "")
        exported = act.get(f"{ANDROID_NS}exported", "false")
        theme = act.get(f"{ANDROID_NS}theme", "")
        screen_orientation = act.get(f"{ANDROID_NS}screenOrientation", "")
        launch_mode = act.get(f"{ANDROID_NS}launchMode", "")
        window_soft_input = act.get(f"{ANDROID_NS}windowSoftInputMode", "")

        intent_filters = parse_intent_filters(act)
        is_launcher = any(
            "android.intent.action.MAIN" in f["actions"] and "android.intent.category.LAUNCHER" in f["categories"]
            for f in intent_filters
        )

        entry = {
            "name": name,
            "exported": exported,
            "theme": theme,
            "screen_orientation": screen_orientation,
            "launch_mode": launch_mode,
            "window_soft_input_mode": window_soft_input,
            "is_launcher": is_launcher,
            "intent_filters": intent_filters
        }
        activities.append(entry)

        if is_launcher or any("android.intent.action.VIEW" in f["actions"] for f in intent_filters):
            entrypoint_activities.append(entry)

        if any(term in name.lower() for term in ["ui", "browse", "home", "search", "detail", "player", "login", "profile", "offline", "game"]):
            ui_activities.append(entry)

    # Parse Services
    for srv in app_elem.findall("service"):
        name = srv.get(f"{ANDROID_NS}name", "")
        exported = srv.get(f"{ANDROID_NS}exported", "false")
        services.append({
            "name": name,
            "exported": exported,
            "intent_filters": parse_intent_filters(srv)
        })

    # Parse Receivers
    for rec in app_elem.findall("receiver"):
        name = rec.get(f"{ANDROID_NS}name", "")
        exported = rec.get(f"{ANDROID_NS}exported", "false")
        receivers.append({
            "name": name,
            "exported": exported
        })

    result = {
        "package": root.get("package", "com.netflix.mediaclient"),
        "total_activities": len(activities),
        "ui_activities_count": len(ui_activities),
        "entrypoint_activities_count": len(entrypoint_activities),
        "services_count": len(services),
        "receivers_count": len(receivers),
        "entrypoints": entrypoint_activities,
        "ui_activities": ui_activities,
        "all_activities": activities,
        "services": services,
        "receivers": receivers
    }

    out_file = output_dir / "manifest_activities.json"
    with open(out_file, "w", encoding="utf-8") as f:
        json.dump(result, f, indent=2)

    print(f"[+] Total Activities found: {len(activities)}")
    print(f"[+] UI-focused Activities: {len(ui_activities)}")
    print(f"[+] Entrypoint / Deep link Activities: {len(entrypoint_activities)}")
    print(f"[+] Services: {len(services)}, Receivers: {len(receivers)}")
    print(f"[+] Saved manifest activity catalog to: {out_file}")
    return result

if __name__ == "__main__":
    base = Path(__file__).resolve().parent.parent
    out = base / "extraction_output"
    extract_activities(base, out)
