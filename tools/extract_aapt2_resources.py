#!/usr/bin/env python3
"""
extract_aapt2_resources.py - Deep Resource & Style Attributes Extractor
Extracts resource tables, style attribute specifications, and Netflix custom
attributes (such as nb_* button attributes, aro* ribbons, and typography metrics)
from the base APK and decoded resources.
"""

import os
import sys
import json
import re
import subprocess
import xml.etree.ElementTree as ET
from pathlib import Path

def extract_aapt2_resources(apk_path: Path, output_dir: Path) -> dict:
    print("=" * 60)
    print("Stage: Extracting AAPT2 Resources, Custom Attrs & Styles")
    print("=" * 60)

    if not apk_path.exists():
        raise FileNotFoundError(f"Target APK not found at {apk_path}")

    # 1. Run aapt2 dump resources
    print("[*] Running aapt2 dump resources...")
    cmd = ["aapt2", "dump", "resources", str(apk_path)]
    proc = subprocess.run(cmd, capture_output=True, text=True, errors="ignore")

    resource_counts = {}
    current_type = None
    colors_dump = {}
    dimens_dump = {}

    for line in proc.stdout.splitlines():
        line_strip = line.strip()
        type_match = re.match(r"type\s+([a-zA-Z0-9_]+)\s+id=[0-9a-fA-F]+\s+entryCount=(\d+)", line_strip)
        if type_match:
            current_type = type_match.group(1)
            resource_counts[current_type] = int(type_match.group(2))
            continue

        if current_type == "color":
            res_match = re.match(r"resource\s+(0x[0-9a-fA-F]+)\s+color/(\S+)", line_strip)
            if res_match:
                colors_dump[res_match.group(1).lower()] = res_match.group(2)
        elif current_type == "dimen":
            res_match = re.match(r"resource\s+(0x[0-9a-fA-F]+)\s+dimen/(\S+)", line_strip)
            if res_match:
                dimens_dump[res_match.group(1).lower()] = res_match.group(2)

    print(f"[+] AAPT2 dump completed. Found types: {list(resource_counts.keys())}")

    # 2. Parse Netflix custom view attributes (nb_*, aro_*, etc.) from decoded styles
    styles_xml_path = output_dir / "apktool_decoded" / "res" / "values" / "styles.xml"
    if not styles_xml_path.exists():
        base_dir = output_dir.parent
        styles_xml_path = base_dir / "extraction_output" / "apktool_decoded" / "res" / "values" / "styles.xml"

    netflix_button_styles = []
    netflix_custom_attributes = set()

    if styles_xml_path.exists():
        print(f"[*] Parsing custom attributes from styles: {styles_xml_path.name}...")
        try:
            tree = ET.parse(styles_xml_path)
            root = tree.getroot()
            for style in root.findall("style"):
                style_name = style.get("name", "")
                parent = style.get("parent", "")
                items = {}
                for item in style.findall("item"):
                    item_name = item.get("name", "")
                    item_val = (item.text or "").strip()
                    if item_name.startswith("nb_") or item_name.startswith("aro"):
                        netflix_custom_attributes.add(item_name)
                    items[item_name] = item_val

                # If this style defines Netflix Button or Ribbon attributes
                if any(k.startswith("nb_") for k in items.keys()):
                    netflix_button_styles.append({
                        "style_name": style_name,
                        "parent": parent,
                        "button_attributes": {k: v for k, v in items.items() if k.startswith("nb_")}
                    })
        except Exception as e:
            print(f"[!] Error parsing styles.xml: {e}")

    # 3. Extract unique button specifications from the styles
    unique_corner_radii = set()
    unique_icon_sizes = set()
    unique_ripples = set()

    for nbs in netflix_button_styles:
        attrs = nbs["button_attributes"]
        if "nb_cornerRadius" in attrs:
            unique_corner_radii.add(attrs["nb_cornerRadius"])
        if "nb_iconSize" in attrs:
            unique_icon_sizes.add(attrs["nb_iconSize"])
        if "nb_rippleColor" in attrs:
            unique_ripples.add(attrs["nb_rippleColor"])

    summary = {
        "aapt2_resource_counts": resource_counts,
        "custom_attributes_found": sorted(list(netflix_custom_attributes)),
        "netflix_button_style_definitions_count": len(netflix_button_styles),
        "button_metric_tokens": {
            "discovered_corner_radii": sorted(list(unique_corner_radii)),
            "discovered_icon_sizes": sorted(list(unique_icon_sizes)),
            "discovered_ripple_colors": sorted(list(unique_ripples))
        },
        "sample_button_styles": netflix_button_styles[:15]
    }

    out_file = output_dir / "aapt2_resources.json"
    with open(out_file, "w", encoding="utf-8") as f:
        json.dump(summary, f, indent=2)

    print(f"[+] Custom Netflix attributes identified: {len(netflix_custom_attributes)}")
    print(f"[+] Netflix button styles parsed: {len(netflix_button_styles)}")
    print(f"[+] Discovered Button Corner Radii: {sorted(list(unique_corner_radii))}")
    print(f"[+] Discovered Button Icon Sizes: {sorted(list(unique_icon_sizes))}")
    print(f"[+] Saved AAPT2 resources catalog to: {out_file}")
    return summary

if __name__ == "__main__":
    base = Path(__file__).resolve().parent.parent
    apk = base / "Netflix_9.87.1+build+9+74620_APKPure" / "com.netflix.mediaclient.apk"
    out = base / "extraction_output"
    extract_aapt2_resources(apk, out)
