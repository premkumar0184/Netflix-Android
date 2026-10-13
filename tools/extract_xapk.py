#!/usr/bin/env python3
"""
extract_xapk.py - XAPK Unpacker and Package Manifest Analyzer
Inspects XAPK bundle and extracts package metadata, SDK levels, split APKs, and permissions.
"""

import os
import sys
import json
import zipfile
from pathlib import Path

def analyze_xapk(base_dir: Path, output_dir: Path):
    print("=" * 60)
    print("Stage 1: Analyzing XAPK Bundle & Manifest")
    print("=" * 60)
    
    extracted_dir = base_dir / "Netflix_9.87.1+build+9+74620_APKPure"
    xapk_file = base_dir / "Netflix_9.87.1+build+9+74620_APKPure.xapk"
    
    output_dir.mkdir(parents=True, exist_ok=True)
    
    manifest_data = {}
    if (extracted_dir / "manifest.json").exists():
        with open(extracted_dir / "manifest.json", "r", encoding="utf-8") as f:
            manifest_data = json.load(f)
    elif xapk_file.exists():
        with zipfile.ZipFile(xapk_file, "r") as z:
            if "manifest.json" in z.namelist():
                manifest_data = json.loads(z.read("manifest.json").decode("utf-8"))
    else:
        raise FileNotFoundError("Could not find XAPK or extracted manifest.json")
    
    # Inventory split APKs
    split_inventory = []
    total_size = 0
    if extracted_dir.exists():
        for f in extracted_dir.glob("*.apk"):
            sz = f.stat().st_size
            total_size += sz
            split_inventory.append({
                "filename": f.name,
                "size_bytes": sz,
                "size_mb": round(sz / (1024 * 1024), 2),
                "type": "base" if f.name.startswith("com.") else f.name.split(".")[1]
            })
    
    # Categorize permissions
    raw_perms = manifest_data.get("permissions", [])
    categorized_perms = {
        "network": [p for p in raw_perms if "NETWORK" in p or "INTERNET" in p or "WIFI" in p],
        "media_and_audio": [p for p in raw_perms if "AUDIO" in p or "MEDIA" in p or "CAMERA" in p],
        "system_and_services": [p for p in raw_perms if "SERVICE" in p or "BOOT" in p or "WAKE" in p or "JOB" in p],
        "notifications": [p for p in raw_perms if "NOTIFICATION" in p],
        "bluetooth": [p for p in raw_perms if "BLUETOOTH" in p],
        "storage": [p for p in raw_perms if "STORAGE" in p],
        "custom_netflix": [p for p in raw_perms if "com.netflix" in p]
    }
    
    summary = {
        "package_name": manifest_data.get("package_name", "com.netflix.mediaclient"),
        "app_name": manifest_data.get("name", "Netflix"),
        "version_name": manifest_data.get("version_name", "9.87.1"),
        "version_code": manifest_data.get("version_code", "74620"),
        "min_sdk": manifest_data.get("min_sdk_version", "28"),
        "target_sdk": manifest_data.get("target_sdk_version", "37"),
        "splits_count": len(split_inventory),
        "split_inventory": sorted(split_inventory, key=lambda x: x["size_bytes"], reverse=True),
        "permissions_count": len(raw_perms),
        "categorized_permissions": categorized_perms
    }
    
    out_file = output_dir / "manifest_summary.json"
    with open(out_file, "w", encoding="utf-8") as f:
        json.dump(summary, f, indent=2)
        
    print(f"[+] Package: {summary['package_name']} ({summary['version_name']})")
    print(f"[+] Target SDK: {summary['target_sdk']} | Min SDK: {summary['min_sdk']}")
    print(f"[+] Found {len(split_inventory)} split APKs ({round(total_size / (1024*1024), 2)} MB total)")
    print(f"[+] Output written to: {out_file}")
    return summary

if __name__ == "__main__":
    base = Path(__file__).resolve().parent.parent
    out = base / "extraction_output"
    analyze_xapk(base, out)
