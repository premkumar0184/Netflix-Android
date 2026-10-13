#!/usr/bin/env python3
"""
extract_lottie_and_assets.py - Lottie Animation and Vector Asset Extractor
Extracts all interactive Lottie micro-animations, Compose multiplatform vector drawables,
and graphics assets into an organized UI asset catalog.
"""

import os
import sys
import json
import zipfile
import shutil
from pathlib import Path

def extract_lottie_files(base_apk: Path, dest_dir: Path):
    dest_dir.mkdir(parents=True, exist_ok=True)
    lottie_catalog = []
    
    # UI trigger mapping
    ui_triggers = {
        "glowing-netflix-n-logo.json": {
            "trigger": "App Launch / Splash Screen",
            "description": "Signature Netflix N glow animation on cold start"
        },
        "play-pause.json": {
            "trigger": "Player Play/Pause Toggle",
            "description": "Smooth vector morph between play triangle and pause bars"
        },
        "play-loading-replay.json": {
            "trigger": "Player State Transitions",
            "description": "Morphs between Play, Buffer Spinner, and Replay icon"
        },
        "my-list-plus-to-check.json": {
            "trigger": "Watchlist Button Click",
            "description": "Plus symbol rotates and morphs into checkmark when added to My List"
        },
        "remind-me-bell-to-check.json": {
            "trigger": "Remind Me Button Click (Coming Soon)",
            "description": "Ringing bell morphs into checkmark for notifications"
        },
        "rating_thumb_up.json": {
            "trigger": "Thumbs Up Click (I Like This)",
            "description": "Animated thumb with bounce and sparkle highlight"
        },
        "rating_thumb_down.json": {
            "trigger": "Thumbs Down Click (Not For Me)",
            "description": "Animated thumb pointing down"
        },
        "rating_double_thumb_star_1.json": {
            "trigger": "Double Thumbs Up Click (Love This!)",
            "description": "Two animated thumbs with starburst explosion"
        },
        "now_playing.json": {
            "trigger": "Audio/Video Playing in MiniPlayer / Row",
            "description": "Equalizer frequency bars bouncing"
        },
        "live_now.json": {
            "trigger": "Live Stream Indicator",
            "description": "Pulsing red radar ring indicating live broadcast"
        },
        "downloads_nux.json": {
            "trigger": "Downloads Tab First-Time User Experience",
            "description": "Animated smartphone with downloading arrow"
        },
        "profile_education.json": {
            "trigger": "Profile Switcher / Onboarding",
            "description": "Profile avatar selection guide animation"
        },
        "switch_lottie_animation_dark.json": {
            "trigger": "Toggle Switch (Dark Theme)",
            "description": "Animated pill switch toggle"
        },
        "switch_lottie_animation_light.json": {
            "trigger": "Toggle Switch (Light Theme)",
            "description": "Animated pill switch toggle"
        }
    }
    
    with zipfile.ZipFile(base_apk, "r") as z:
        for name in z.namelist():
            if name.startswith("assets/lottiefiles/") and name.endswith(".json"):
                filename = os.path.basename(name)
                data = z.read(name)
                
                target_path = dest_dir / filename
                with open(target_path, "wb") as f:
                    f.write(data)
                    
                meta = ui_triggers.get(filename, {
                    "trigger": "Custom Interaction",
                    "description": "Interactive micro-animation"
                })
                
                # Parse animation specs
                try:
                    lottie_json = json.loads(data.decode("utf-8"))
                    fps = lottie_json.get("fr", 60)
                    in_point = lottie_json.get("ip", 0)
                    out_point = lottie_json.get("op", 60)
                    duration_sec = round((out_point - in_point) / fps, 2) if fps > 0 else 1.0
                    width = lottie_json.get("w", 0)
                    height = lottie_json.get("h", 0)
                    layers_count = len(lottie_json.get("layers", []))
                except Exception:
                    fps, duration_sec, width, height, layers_count = 60, 1.0, 0, 0, 0
                
                lottie_catalog.append({
                    "filename": filename,
                    "target_file": f"ui_assets/lottiefiles/{filename}",
                    "trigger": meta["trigger"],
                    "description": meta["description"],
                    "fps": fps,
                    "duration_sec": duration_sec,
                    "width": width,
                    "height": height,
                    "layers_count": layers_count,
                    "size_bytes": len(data)
                })
                
    return lottie_catalog

def extract_compose_vectors(base_apk: Path, dest_dir: Path):
    dest_dir.mkdir(parents=True, exist_ok=True)
    count = 0
    with zipfile.ZipFile(base_apk, "r") as z:
        for name in z.namelist():
            if "assets/composeResources/" in name and name.endswith(".xml"):
                filename = os.path.basename(name)
                data = z.read(name)
                with open(dest_dir / filename, "wb") as f:
                    f.write(data)
                count += 1
    return count

def extract_all_assets(base_dir: Path, output_dir: Path):
    print("=" * 60)
    print("Stage 5: Extracting Lottie Micro-Animations & Compose Vectors")
    print("=" * 60)
    
    base_apk = base_dir / "Netflix_9.87.1+build+9+74620_APKPure" / "com.netflix.mediaclient.apk"
    assets_dir = output_dir / "ui_assets"
    lottie_dir = assets_dir / "lottiefiles"
    vector_dir = assets_dir / "hawkins_vectors"
    
    print("[*] Extracting Lottie animations...")
    catalog = extract_lottie_files(base_apk, lottie_dir)
    print(f"[+] Extracted and indexed {len(catalog)} Lottie animations")
    
    cat_file = output_dir / "lottie_catalog.json"
    with open(cat_file, "w", encoding="utf-8") as f:
        json.dump(catalog, f, indent=2)
        
    print("[*] Extracting Hawkins Compose vector drawables...")
    vector_count = extract_compose_vectors(base_apk, vector_dir)
    print(f"[+] Extracted {vector_count} Hawkins vector assets")
    
    # Also copy icon.png if present
    icon_src = base_dir / "Netflix_9.87.1+build+9+74620_APKPure" / "icon.png"
    if icon_src.exists():
        shutil.copy(icon_src, assets_dir / "app_icon.png")
        print(f"[+] Saved app_icon.png to {assets_dir}")
        
    print("[+] Stage 5 Complete!")
    return catalog

if __name__ == "__main__":
    base = Path(__file__).resolve().parent.parent
    out = base / "extraction_output"
    extract_all_assets(base, out)
