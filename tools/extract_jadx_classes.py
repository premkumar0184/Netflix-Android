#!/usr/bin/env python3
"""
extract_jadx_classes.py - Targeted JADX Bytecode Decompilation & Class Analyzer
Decompiles key Hawkins Design System and UI architecture classes from APK DEX files,
extracts real enum values, theme parameters, dimension constants, and component structures.
"""

import os
import sys
import json
import re
import zipfile
import subprocess
from pathlib import Path

TARGET_PACKAGES = [
    "com.netflix.hawkins.consumer.tokens",
    "com.netflix.hawkins.consumer.component.button",
    "com.netflix.hawkins.consumer.component.avatar",
    "com.netflix.hawkins.consumer.component.chip",
    "com.netflix.hawkins.consumer.component.tag",
    "com.netflix.hawkins.consumer.component.divider",
    "com.netflix.hawkins.consumer.component.dialog",
    "com.netflix.hawkins.consumer.component.sheet",
    "com.netflix.hawkins.consumer.component.input",
    "com.netflix.hawkins.consumer.icons",
    "com.netflix.mediaclient.ui.billboard.api",
    "com.netflix.mediaclient.ui.home.apistarcourt",
]

PRIORITY_CLASSES = [
    "com.netflix.hawkins.consumer.tokens.HawkinsTheme",
    "com.netflix.hawkins.consumer.tokens.Appearance",
    "com.netflix.hawkins.consumer.component.button.HawkinsButtonType",
    "com.netflix.hawkins.consumer.component.button.HawkinsButtonSize",
    "com.netflix.hawkins.consumer.component.avatar.HawkinsAvatarShape",
    "com.netflix.hawkins.consumer.component.avatar.HawkinsAvatarSize",
    "com.netflix.hawkins.consumer.component.chip.HawkinsChipType",
    "com.netflix.hawkins.consumer.component.chip.HawkinsChipSize",
    "com.netflix.hawkins.consumer.component.tag.HawkinsTagType",
    "com.netflix.hawkins.consumer.component.tag.HawkinsTagSize",
    "com.netflix.hawkins.consumer.component.tag.HawkinsTagAudioVideoType",
    "com.netflix.hawkins.consumer.component.divider.HawkinsDividerEmphasis",
    "com.netflix.hawkins.consumer.icons.IconSize"
]

def scan_dex_for_classes(apk_path: Path):
    discovered = set()
    with zipfile.ZipFile(apk_path, "r") as z:
        for name in z.namelist():
            if name.startswith("classes") and name.endswith(".dex"):
                data = z.read(name)
                matches = re.findall(rb"L(com/netflix/[a-zA-Z0-9_/$]+);", data)
                for m in matches:
                    cls_name = m.decode("utf-8", errors="ignore").replace("/", ".")
                    base_cls = cls_name.split("$")[0]
                    for pkg in TARGET_PACKAGES:
                        if base_cls.startswith(pkg):
                            discovered.add(base_cls)
    return sorted(list(discovered))

def decompile_class(apk_path: Path, class_name: Path, out_dir: Path):
    rel_path = class_name.replace(".", "/") + ".java"
    target_file = out_dir / "sources" / rel_path
    if target_file.exists():
        return target_file

    tmp_fallback = Path("/tmp/jadx_out/sources") / rel_path
    if tmp_fallback.exists():
        target_file.parent.mkdir(parents=True, exist_ok=True)
        import shutil
        shutil.copy(tmp_fallback, target_file)
        return target_file

    print(f"[*] Decompiling with JADX: {class_name}...")
    cmd = ["jadx", "--single-class", class_name, "-d", str(out_dir), str(apk_path)]
    try:
        proc = subprocess.run(cmd, capture_output=True, text=True, timeout=90)
        if target_file.exists():
            return target_file
    except subprocess.TimeoutExpired:
        print(f"[!] JADX timed out for {class_name}")
    return None

def parse_enums_from_java(java_path: Path):
    if not java_path.exists():
        return None
    content = java_path.read_text(encoding="utf-8", errors="ignore")
    # Check Metadata d2 array for enum cases
    meta_match = re.search(r'@Metadata\(.*?d2\s*=\s*\{([^}]+)\}', content, re.DOTALL)
    if meta_match:
        items = [i.strip(' "\t\n\r') for i in meta_match.group(1).split(",")]
        # Filter likely enum members (capitalized identifiers that aren't class name)
        class_name = java_path.stem
        candidates = [x for x in items if x and x[0].isupper() and x != class_name and not x.startswith("Lcom") and not x.startswith("()")]
        if candidates:
            return candidates

    # Fallback: scan class body enum declarations
    body_match = re.findall(r'^\s*([A-Z][a-zA-Z0-9_]+)(?:\([^)]*\))?[;,]', content, re.MULTILINE)
    if body_match:
        return [b for b in body_match if b not in ["String", "Object", "Metadata", "Override"]]
    return None

def parse_hawkins_theme_structures(java_path: Path):
    if not java_path or not java_path.exists():
        return {}
    content = java_path.read_text(encoding="utf-8", errors="ignore")
    structures = {}

    # Find toString() patterns that reveal component parameters
    # e.g., Tag(colors=..., dimensions=..., typographies=...)
    matches = re.finditer(r'new StringBuilder\("([A-Za-z]+)\(([^"]+)"\)', content)
    for m in matches:
        comp_name = m.group(1)
        param_sample = m.group(2)
        if comp_name not in structures:
            structures[comp_name] = []
        structures[comp_name].append(param_sample)

    # Find detailed field parameters from AbstractC34853zG.d("Colors(border=", strG, ...)
    color_param_matches = re.findall(r'Colors\(([^)]+)\)', content)
    dim_param_matches = re.findall(r'Dimensions\(([^)]+)\)', content)
    typo_param_matches = re.findall(r'Typographies\(([^)]+)\)', content)

    return {
        "component_contracts": list(structures.keys()),
        "color_parameter_samples": list(set(color_param_matches))[:10],
        "dimension_parameter_samples": list(set(dim_param_matches))[:10],
        "typography_parameter_samples": list(set(typo_param_matches))[:10]
    }

def analyze_classes(apk_path: Path, output_dir: Path) -> dict:
    print("=" * 60)
    print("Stage: JADX Targeted Class Decompilation & Bytecode Analysis")
    print("=" * 60)

    jadx_dir = output_dir / "jadx_decompiled"
    jadx_dir.mkdir(parents=True, exist_ok=True)

    print("[*] Scanning APK DEX files for targeted classes...")
    discovered = scan_dex_for_classes(apk_path)
    print(f"[+] Discovered {len(discovered)} relevant classes in target packages")

    decompiled_files = {}
    enums_extracted = {}

    # Decompile priority classes
    for cls in PRIORITY_CLASSES:
        res_file = decompile_class(apk_path, cls, jadx_dir)
        if res_file:
            decompiled_files[cls] = str(res_file)
            enums = parse_enums_from_java(res_file)
            if enums:
                enums_extracted[cls] = enums

    # Parse HawkinsTheme if decompiled
    hawkins_theme_file = jadx_dir / "sources" / "com" / "netflix" / "hawkins" / "consumer" / "tokens" / "HawkinsTheme.java"
    theme_structures = parse_hawkins_theme_structures(hawkins_theme_file)

    analysis_result = {
        "classes_discovered_count": len(discovered),
        "target_packages": TARGET_PACKAGES,
        "classes_decompiled_count": len(decompiled_files),
        "decompiled_classes": list(decompiled_files.keys()),
        "enums_extracted": enums_extracted,
        "theme_token_structures": theme_structures
    }

    out_file = output_dir / "jadx_class_analysis.json"
    with open(out_file, "w", encoding="utf-8") as f:
        json.dump(analysis_result, f, indent=2)

    print(f"[+] Decompiled {len(decompiled_files)} priority classes")
    print(f"[+] Extracted enum models for: {list(enums_extracted.keys())}")
    print(f"[+] Saved JADX analysis to: {out_file}")
    return analysis_result

if __name__ == "__main__":
    base = Path(__file__).resolve().parent.parent
    apk = base / "Netflix_9.87.1+build+9+74620_APKPure" / "com.netflix.mediaclient.apk"
    out = base / "extraction_output"
    analyze_classes(apk, out)
