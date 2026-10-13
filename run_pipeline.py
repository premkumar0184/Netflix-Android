#!/usr/bin/env python3
"""
run_pipeline.py - Master Orchestrator for XAPK Reverse-Engineering & UI Recreation
Executes the full extraction and generation pipeline end-to-end.
"""

import os
import sys
import time
import json
from pathlib import Path

# Add tools to path
base_dir = Path(__file__).resolve().parent
sys.path.insert(0, str(base_dir / "tools"))

import extract_xapk
import extract_resources
import extract_manifest_activities
import extract_aapt2_resources
import extract_jadx_classes
import extract_hawkins_tokens
import extract_screens_and_navigation
import extract_lottie_and_assets
import generate_compose_skeleton
import test_pipeline

def main():
    print("=" * 70)
    print("     NETFLIX XAPK UI EXTRACTION & JETPACK COMPOSE PIPELINE")
    print("=" * 70)
    
    start_time = time.time()
    out_dir = base_dir / "extraction_output"
    out_dir.mkdir(parents=True, exist_ok=True)
    apk_path = base_dir / "Netflix_9.87.1+build+9+74620_APKPure" / "com.netflix.mediaclient.apk"
    
    # Check prerequisites
    if not apk_path.exists():
        print(f"[!] Target APK not found at: {apk_path}")
        sys.exit(1)
        
    print(f"[*] Workspace Root: {base_dir}")
    print(f"[*] Target APK: {apk_path.name}")
    print(f"[*] Output Directory: {out_dir}")
    print()
    
    # Stage 1: XAPK & Manifest
    extract_xapk.analyze_xapk(base_dir, out_dir)
    print()
    
    # Stage 2: Resources & Strings (APKTool)
    extract_resources.extract_all_resources(base_dir, out_dir)
    print()

    # Stage 3: Decoded Manifest Activities & Component Structure
    extract_manifest_activities.extract_activities(base_dir, out_dir)
    print()

    # Stage 4: AAPT2 Full Resources & Custom Netflix Attributes
    extract_aapt2_resources.extract_aapt2_resources(apk_path, out_dir)
    print()

    # Stage 5: JADX Targeted Class Decompilation & Enum Analysis
    extract_jadx_classes.analyze_classes(apk_path, out_dir)
    print()
    
    # Stage 6: Hawkins Design Tokens (Bytecode + Decompiled Theme)
    extract_hawkins_tokens.build_hawkins_tokens(apk_path, out_dir)
    print()
    
    # Stage 7: Screens, Billboard API & Navigation Architecture
    extract_screens_and_navigation.build_navigation_model(apk_path, out_dir)
    print()
    
    # Stage 8: Lottie Micro-Animations & Vector Assets
    extract_lottie_and_assets.extract_all_assets(base_dir, out_dir)
    print()
    
    # Stage 9: Jetpack Compose App Generation
    generate_compose_skeleton.generate_compose_app(base_dir, out_dir)
    print()

    # Stage 10: Automated Verification Tests
    test_pipeline.run_tests()
    print()
    
    elapsed = round(time.time() - start_time, 2)
    print("=" * 70)
    print(f"[✓] PIPELINE COMPLETED SUCCESSFULLY in {elapsed}s")
    print("=" * 70)
    
    # Print summary of generated artifacts
    print("\nSummary of Generated Artifacts:")
    catalogs = [
        ("Manifest Summary", out_dir / "manifest_summary.json"),
        ("Public ID Map", out_dir / "public_id_map.json"),
        ("English Strings", out_dir / "en_strings.json"),
        ("Colors Catalog", out_dir / "colors.json"),
        ("Manifest Activities", out_dir / "manifest_activities.json"),
        ("AAPT2 Resources & Styles", out_dir / "aapt2_resources.json"),
        ("JADX Class Analysis", out_dir / "jadx_class_analysis.json"),
        ("Hawkins Design Tokens", out_dir / "hawkins_design_tokens.json"),
        ("Screens & Navigation", out_dir / "screens_and_navigation.json"),
        ("Lottie Catalog", out_dir / "lottie_catalog.json"),
    ]
    for label, p in catalogs:
        if p.exists():
            sz = p.stat().st_size
            print(f"  • {label:26}: {p.name} ({round(sz/1024, 1)} KB)")
        else:
            print(f"  ✗ {label:26}: MISSING")
            
    app_files = list((base_dir / "generated_app").rglob("*.kt"))
    print(f"\nRecreated Jetpack Compose App:")
    print(f"  • Total Kotlin files generated : {len(app_files)}")
    for kf in app_files:
        print(f"    - {kf.relative_to(base_dir / 'generated_app')}")
        
    lottie_files = list((base_dir / "extraction_output" / "ui_assets" / "lottiefiles").glob("*.json"))
    print(f"\nExtracted Lottie Micro-Animations: {len(lottie_files)} files in ui_assets/lottiefiles/")

if __name__ == "__main__":
    main()
