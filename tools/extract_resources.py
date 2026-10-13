#!/usr/bin/env python3
"""
extract_resources.py - Resource and String Extractor
Extracts XML layouts, color palettes, localized strings, dimensions, and public ID mappings.
"""

import os
import sys
import json
import subprocess
import xml.etree.ElementTree as ET
from pathlib import Path

def run_apktool(apk_path: Path, output_dir: Path):
    if (output_dir / "res").exists() and (output_dir / "AndroidManifest.xml").exists():
        print(f"[*] APKTool resources already decoded at {output_dir}")
        return True
    
    print(f"[*] Decoding resources with APKTool: {apk_path.name}...")
    cmd = ["apktool", "d", "-f", "-s", str(apk_path), "-o", str(output_dir)]
    res = subprocess.run(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True)
    if res.returncode != 0:
        print(f"[!] Warning: APKTool returned non-zero code {res.returncode}, but proceeding if res exists.")
    return (output_dir / "res").exists()

def parse_public_xml(res_dir: Path):
    public_file = res_dir / "values" / "public.xml"
    id_map = {}
    if not public_file.exists():
        return id_map
    
    try:
        tree = ET.parse(public_file)
        root = tree.getroot()
        for elem in root.findall("public"):
            rtype = elem.attrib.get("type")
            name = elem.attrib.get("name")
            hex_id = elem.attrib.get("id")
            if hex_id:
                id_map[hex_id.lower()] = {
                    "type": rtype,
                    "name": name
                }
    except Exception as e:
        print(f"[!] Error parsing public.xml: {e}")
    return id_map

def parse_strings(res_dir: Path):
    strings_map = {}
    strings_file = res_dir / "values" / "strings.xml"
    if not strings_file.exists():
        return strings_map
    
    try:
        tree = ET.parse(strings_file)
        root = tree.getroot()
        for elem in root.findall("string"):
            name = elem.attrib.get("name")
            text = elem.text or ""
            # Handle child tags if any
            if len(elem) > 0:
                text = "".join(elem.itertext())
            strings_map[name] = text.strip()
    except Exception as e:
        print(f"[!] Error parsing strings.xml: {e}")
    return strings_map

def parse_colors(res_dir: Path):
    colors_map = {}
    colors_file = res_dir / "values" / "colors.xml"
    if not colors_file.exists():
        return colors_map
    
    try:
        tree = ET.parse(colors_file)
        root = tree.getroot()
        for elem in root.findall("color"):
            name = elem.attrib.get("name")
            val = (elem.text or "").strip()
            colors_map[name] = val
    except Exception as e:
        print(f"[!] Error parsing colors.xml: {e}")
    return colors_map

def parse_dimens(res_dir: Path):
    dimens_map = {}
    dimens_file = res_dir / "values" / "dimens.xml"
    if not dimens_file.exists():
        return dimens_map
    
    try:
        tree = ET.parse(dimens_file)
        root = tree.getroot()
        for elem in root.findall("dimen"):
            name = elem.attrib.get("name")
            val = (elem.text or "").strip()
            dimens_map[name] = val
    except Exception as e:
        print(f"[!] Error parsing dimens.xml: {e}")
    return dimens_map

def extract_all_resources(base_dir: Path, output_dir: Path):
    print("=" * 60)
    print("Stage 2: Decoding Resources, Strings, and Color Tokens")
    print("=" * 60)
    
    apk_path = base_dir / "Netflix_9.87.1+build+9+74620_APKPure" / "com.netflix.mediaclient.apk"
    apktool_cache = output_dir / "apktool_decoded"
    
    success = run_apktool(apk_path, apktool_cache)
    if not success:
        raise RuntimeError("Failed to decode resources with APKTool")
        
    res_dir = apktool_cache / "res"
    
    # 1. Public ID Map
    print("[*] Parsing public resource ID mapping...")
    id_map = parse_public_xml(res_dir)
    print(f"[+] Loaded {len(id_map)} public resource entries")
    with open(output_dir / "public_id_map.json", "w", encoding="utf-8") as f:
        json.dump(id_map, f, indent=2)
        
    # 2. Strings
    print("[*] Parsing localized strings...")
    strings_map = parse_strings(res_dir)
    print(f"[+] Extracted {len(strings_map)} strings")
    with open(output_dir / "en_strings.json", "w", encoding="utf-8") as f:
        json.dump(strings_map, f, indent=2)
        
    # 3. Colors
    print("[*] Parsing colors table...")
    colors_map = parse_colors(res_dir)
    print(f"[+] Extracted {len(colors_map)} color definitions")
    
    # Identify key Netflix brand palette
    brand_palette = {}
    for name, hex_val in colors_map.items():
        if hex_val.lower() in ["#e50914", "#b9090b", "#590101", "#000000", "#121212", "#221f1f", "#f5f5f1"]:
            brand_palette[name] = hex_val
    
    colors_summary = {
        "raw_colors_count": len(colors_map),
        "brand_palette": brand_palette,
        "all_colors": colors_map
    }
    with open(output_dir / "colors.json", "w", encoding="utf-8") as f:
        json.dump(colors_summary, f, indent=2)
        
    # 4. Dimensions
    dimens_map = parse_dimens(res_dir)
    print(f"[+] Extracted {len(dimens_map)} dimension definitions")
    with open(output_dir / "dimens.json", "w", encoding="utf-8") as f:
        json.dump(dimens_map, f, indent=2)
        
    print("[+] Stage 2 Complete!")

if __name__ == "__main__":
    base = Path(__file__).resolve().parent.parent
    out = base / "extraction_output"
    extract_all_resources(base, out)
