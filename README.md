# Netflix Android — Jetpack Compose UI Recreation & Reverse-Engineering Showcase

[![Android](https://img.shields.io/badge/Platform-Android%209.0%2B%20(API%2028--35)-3DDC84?logo=android&logoColor=white)](https://developer.android.com)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-7F52FF?logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-BOM%202024.10.01-4285F4?logo=jetpackcompose&logoColor=white)](https://developer.android.com/jetpack/compose)
[![Material 3](https://img.shields.io/badge/Material%203-1.3.1-7986CB)](https://m3.material.io)
[![Hawkins Design System](https://img.shields.io/badge/Design%20System-Hawkins%20Tokens-E50914)](https://netflixtechblog.com)
[![Coil](https://img.shields.io/badge/Image%20Loader-Coil%202.7.0-blue)](https://coil-kt.github.io/coil/)
[![Lottie](https://img.shields.io/badge/Micro--Animations-Lottie%206.6.0-00D1B2)](https://airbnb.io/lottie/)
[![Clean-Room](https://img.shields.io/badge/Methodology-100%25%20Clean--Room-brightgreen)](#legal-disclaimer--clean-room-notice)

A production-grade, clean-room reverse-engineering and recreation of the Netflix Android application built with **100% Jetpack Compose**, **Kotlin 2.0**, and Netflix's proprietary **Hawkins Design System**.

This repository contains:
1. **The Reconstructed Android App (`generated_app/`)**: A modern, standalone Jetpack Compose application featuring cinematic hero layouts, strict poster aspect ratios, authentic rank typography, fluid micro-interactions, resilient state handling, and dynamic Base Dark / Eclipse AMOLED theming.
2. **The Reverse-Engineering Toolchain (`tools/`)**: An automated 10-stage Python extraction and synthesis pipeline that extracts design tokens, component contracts, navigation structures, and vector assets directly from the Android package.
3. **Structured Design Token Catalogs (`extraction_output/`)**: Extracted and verified JSON specifications for colors, typography scales, component variants, and Lottie motion assets.

---

## Screen Architecture & User Flow

```
                               ┌─────────────────────────────────┐
                               │       ProfilePickerScreen       │
                               │  (Multi-Profile & Theme Switch) │
                               └────────────────┬────────────────┘
                                                │
                                                ▼
┌──────────────────────────────────────────────────────────────────────────────────────────────────┐
│                                   AppNavigation Scaffold Shell                                   │
│  ┌────────────────────┬──────────────────────┬────────────────────────┬───────────────────────┐  │
│  │   HomeScreen       │     GamesScreen      │    NewAndHotScreen     │    MyNetflixScreen    │  │
│  │  (Lolomo Feed)     │    (Game Catalog)    │  (Coming Soon / Top10) │ (Downloads & Settings)│  │
│  └─────────┬──────────┴──────────────────────┴────────────────────────┴───────────────────────┘  │
│            │ (Select Title / Search / Play)                                                      │
└────────────┼─────────────────────────────────────────────────────────────────────────────────────┘
             │
             ├──► DetailsScreen (Synopsis, Episodes, Audio/Video Badges, Similar Titles)
             ├──► SearchScreen (Instant Search, Shimmer Skeleton, Empty & Error States)
             └──► PlayerScreen (Fullscreen Video Playback Interface, Scrubbing Scrims)
```

---

## Key Features & Engineering Highlights

### 🎨 Hawkins Design System (Decompiled & Verified)
- **Dual-Theme Engine**:
  - `Base`: Default Cinematic Dark theme (`#141414` background, `#1F1F1F` surface).
  - `Eclipse`: AMOLED Pure Black theme (`#000000` background, `#121212` surface) with zero pixel emission on OLED displays.
  - Runtime theme toggle located directly in the *My Netflix* profile screen.
- **Component Contracts**:
  - `HawkinsButton`: 6 verified variants (`Primary`, `Secondary`, `Tertiary`, `Supplemental`, `Brand`, `Destructive`) across 3 sizes (`Small` 32dp, `Standard` 40dp, `Large` 48dp).
  - `HawkinsTag`: 4 tag styles (`Fill`, `Standard`, `Supplemental`, `Offers`) with 13 AV badge classifications (`DolbyVision`, `DolbyAtmos`, `SpatialAudio`, `4K`, `HDR10+`, `SDH`).
  - `HawkinsChip`: `Border` and `Borderless` filter chips for genre/category filtering.
  - `HawkinsAvatar`: Profile avatars with `Circle` and `Square` shapes across 5 sizes.
  - `HawkinsDivider`: High- and Low-emphasis divider lines.

### 🎬 Cinematic Visual Experience & Media Rails
- **BillboardHero**:
  - 530dp immersive full-bleed key art.
  - Subtle top status-bar scrim, side edge vignette, and multi-stop bottom gradient fade.
  - Dynamic CTA button hierarchy (`Play`, `My List` with toggle state, `Info`).
- **Strict Poster Geometry**:
  - **2:3 Portrait Aspect Ratio**: Enforced across all movie and series recommendation rows (`LolomoRow`).
  - **16:9 Landscape Aspect Ratio**: Enforced on *Continue Watching* cards with Netflix Red progress indicators.
- **Top 10 Rank Styling**:
  - Authentic oversized rank numerals (110sp) with 3D drop-shadow styling positioned alongside 2:3 posters.

### 📱 Elevated App Shell & Micro-Interactions
- **Bottom Navigation Bar**:
  - Active Tab Indicator: Smooth width expansion (0dp to 26dp) in Netflix Red (`#E50914`).
  - Active Tab Glow: Subtle radial luminescence (`NetflixRedGlow`) behind active icons.
  - Seamless screen transitions via `AnimatedContent`.
- **Micro-Animations (Lottie Compose)**:
  - 15 integrated vector animations, including the Glowing "N" cold-start splash, play-pause morph, watchlist plus-to-check morph, rating thumbs, and equalizer.

### 🛡️ Resilient UI State Handling & Image Pipeline
- **Coil 2.7.0 Asynchronous Image Loading**:
  - Configured with `SubcomposeAsyncImage`.
  - Graceful shimmer skeleton placeholders during network fetch.
  - Algorithmic procedural canvas artwork fallbacks: if an image URL is unavailable or offline, an artistic themed gradient card renders seamlessly with zero broken icons or layout shifts.
- **Dedicated Loading, Empty & Error States**:
  - Shimmer skeletons for home feeds and search results.
  - Empty states with contextual CTAs for search queries and downloads.
  - Error states with interactive retry buttons.

### ♿ Accessibility & Android Modern Standards
- **Touch Targets**: Minimum 48dp on all interactive elements (`Role.Tab`, buttons, cards).
- **Semantics**: Screen reader descriptions on all icons, avatars, and media cards.
- **Edge-to-Edge**: Full `enableEdgeToEdge()` integration with window insets and navigation bar padding.

---

## Repository Layout

```text
Netflix/
├── README.md                                  # Project documentation (this file)
├── AGENTS.md                                  # Multi-agent architecture & reverse-engineering guide
├── .gitignore                                 # Clean git staging rules
├── run_pipeline.py                            # Master 10-stage extraction orchestrator
│
├── generated_app/                             # Reconstructed Android Jetpack Compose App
│   ├── build.gradle.kts                       # Root Gradle build script
│   ├── settings.gradle.kts                    # Project settings & dependency resolution
│   ├── gradle/libs.versions.toml              # Central Version Catalog (Compose, Coil, Lottie)
│   ├── gradlew / gradlew.bat                  # Gradle Wrapper scripts
│   └── app/
│       ├── build.gradle.kts                   # Module build config (API 35, Java 21, Compose)
│       └── src/main/
│           ├── AndroidManifest.xml
│           ├── assets/lottie/                 # 15 bundled Lottie animation JSONs
│           ├── res/                           # App icon and XML resources
│           └── java/com/recreated/netflix/
│               ├── MainActivity.kt            # Edge-to-edge entrypoint activity
│               ├── theme/                     # Hawkins design tokens
│               │   ├── Color.kt               # Base & Eclipse palettes, Netflix Red
│               │   ├── Type.kt                # Typography scale (Display, Title, Body)
│               │   └── Theme.kt               # HawkinsTheme provider & variant switcher
│               ├── components/                # 10 Recreated UI components
│               │   ├── BillboardHero.kt        # Hero trailer backdrop & CTA buttons
│               │   ├── ContinueWatchingCard.kt # 16:9 thumbnail with progress indicator
│               │   ├── Top10RankCard.kt        # Top 10 rank numeral + 2:3 card
│               │   ├── LolomoRow.kt            # Movie rail with procedural Coil loader
│               │   ├── HawkinsButton.kt        # 6 button types, 3 sizes
│               │   ├── HawkinsTag.kt           # AV badges (Dolby, HDR, 4K) & tags
│               │   ├── HawkinsChip.kt          # Filter chips
│               │   ├── HawkinsAvatar.kt        # Profile avatar shapes & sizes
│               │   ├── HawkinsDivider.kt       # High/low emphasis dividers
│               │   └── NetflixLottieAnimation.kt # Animated Lottie wrapper
│               ├── navigation/
│               │   └── AppNavigation.kt       # 4 tabs, animated active glow bar, state machine
│               └── screens/                   # 8 Fully implemented screens
│                   ├── HomeScreen.kt          # Lolomo feed, billboard, shimmers
│                   ├── GamesScreen.kt         # Mobile games catalog & previews
│                   ├── NewAndHotScreen.kt     # Coming Soon & Everyone's Watching
│                   ├── MyNetflixScreen.kt     # Profile, downloads, theme toggle
│                   ├── DetailsScreen.kt       # Movie synopsis, episodes, similar titles
│                   ├── PlayerScreen.kt        # Fullscreen playback controls
│                   ├── ProfilePickerScreen.kt # Multi-user profile switcher
│                   └── SearchScreen.kt        # Instant search, empty & error states
│
├── tools/                                     # Python Reverse-Engineering & Synthesis Toolchain
│   ├── extract_xapk.py                        # XAPK unpacker & manifest parser
│   ├── extract_resources.py                   # APKTool resource & string decoder
│   ├── extract_manifest_activities.py         # Activity and UI entrypoint mapper
│   ├── extract_aapt2_resources.py             # AAPT2 resource table & custom style extractor
│   ├── extract_jadx_classes.py                # Targeted JADX bytecode decompiler
│   ├── extract_hawkins_tokens.py              # Hawkins token parser & enum extractor
│   ├── extract_screens_and_navigation.py      # Starcourt screen & Lolomo feed analyzer
│   ├── extract_lottie_and_assets.py           # Lottie animation & vector aggregator
│   ├── generate_compose_skeleton.py          # Jetpack Compose code generator
│   ├── test_pipeline.py                       # 11-test automated verification suite
│   └── compose_templates/                    # Source template files for generation
│
└── extraction_output/                         # Structured Catalogs & Extracted Assets
    ├── manifest_summary.json                  # Package metadata, SDK levels, permissions
    ├── en_strings.json                        # 3,834 localized English UI strings
    ├── colors.json                            # Decoded brand colors & palettes
    ├── dimens.json                            # Dimension tables
    ├── manifest_activities.json               # 97 declared activities, 12 UI entrypoints
    ├── aapt2_resources.json                   # 13 custom Netflix attrs, 68 button styles
    ├── jadx_class_analysis.json               # 13 decompiled priority classes & enums
    ├── hawkins_design_tokens.json             # Base/Eclipse tokens, typography, component specs
    ├── screens_and_navigation.json            # 4 tabs, Lolomo feed model, Billboard API
    ├── lottie_catalog.json                    # Index of 15 Lottie animations with trigger metadata
    ├── jadx_decompiled/                       # Decompiled Hawkins token interfaces
    └── ui_assets/                             # 49 Compose vector XMLs and app icon
```

---

## Quickstart: Building & Running the Android App

The Android application is completely standalone and does not require Python or reverse-engineering tools to compile.

### Prerequisites
- **JDK**: Java Development Kit **21** (required by Gradle `jvmTarget = "21"`).
- **Android SDK**: `compileSdk = 35`, `minSdk = 28` (Android 9.0+), Build-Tools `35.0.0`.
- **Android Studio**: Android Studio Ladybug (2024.2.1+) or Meerkat (recommended).

### Option A: Via Android Studio (Recommended)
1. Open Android Studio.
2. Select **Open** and navigate to the `generated_app/` directory.
3. Allow Gradle to sync dependencies from the Version Catalog (`gradle/libs.versions.toml`).
4. Select a connected device or Android Virtual Device (AVD) running API 28+.
5. Click **Run** (`Shift + F10`).

### Option B: Via Command Line (Gradle)
Navigate to `generated_app` and run:

```bash
cd generated_app

# 1. Run Kotlin compilation check (0 errors, 0 warnings)
./gradlew compileDebugKotlin

# 2. Build the Debug APK
./gradlew assembleDebug

# 3. Install directly onto a connected device or running emulator
./gradlew installDebug
```

The compiled APK will be generated at:
```text
generated_app/app/build/outputs/apk/debug/app-debug.apk
```

---

## Extraction & Verification Toolchain (Advanced)

For researchers and developers interested in running or extending the reverse-engineering pipeline:

### Toolchain Requirements
- **Python**: 3.10+
- **JADX**: 1.5.0+ (for DEX bytecode decompilation)
- **APKTool**: 2.9.0+ (for resource decoding)
- **AAPT2**: Android SDK Build-Tools

### Running the Verification Suite
Verify the integrity of all extracted catalogs, Hawkins token enums, Lottie assets, AST syntax of all 23 Kotlin UI files, and Gradle scripts:

```bash
python3 tools/test_pipeline.py
```
*Output: `[✓] ALL 11 VERIFICATION TESTS PASSED SUCCESSFULLY!`*

### Running the Full Pipeline
To execute all 10 stages end-to-end:

```bash
python3 run_pipeline.py
```

---

## Git Setup & Hygiene Guidance

When pushing this project to GitHub, follow these instructions to keep the repository lightweight (< 5 MB) and ensure compliance:

1. **Do NOT commit proprietary binaries**:
   - Exclude `.xapk` / `.apk` packages.
   - Exclude `extraction_output/apktool_decoded/` (contains raw proprietary DEX files).
2. **Exclude build artifacts and machine-specific files**:
   - Exclude `build/`, `.gradle/`, `.idea/`, `.kotlin/`.
   - Exclude `local.properties` (contains machine-specific SDK paths).
3. **Exclude foreign projects**:
   - Exclude `mjland-web/` (unrelated cloned web project).

A production-ready `.gitignore` is provided in the repository root. To initialize and push:

```bash
# Initialize git repository
git init

# Stage tracked source, tools, and catalogs
git add generated_app/ tools/ extraction_output/ README.md AGENTS.md run_pipeline.py .gitignore

# Commit
git commit -m "Initial commit: Netflix Android Jetpack Compose UI recreation with Hawkins Design System"

# Add remote and push
git branch -M main
git remote add origin https://github.com/<your-username>/<your-repo-name>.git
git push -u origin main
```

---

## Legal Disclaimer & Clean-Room Notice

> **IMPORTANT LEGAL & CLEAN-ROOM NOTICE**
> 
> 1. **Purpose**: This repository is created strictly for **educational, academic research, and design system interoperability analysis** under Fair Use principles.
> 2. **Trademark Notice**: "Netflix", the Netflix logo, and the "N" emblem are registered trademarks of Netflix, Inc. This project is independent, unofficial, and is **not affiliated with, endorsed by, sponsored by, or associated with Netflix, Inc.** in any manner.
> 3. **Clean-Room Boundary**:
>    - All Jetpack Compose UI code in `generated_app/` was independently authored and reconstructed from public design system specifications and architectural analysis.
>    - This project does **NOT** contain, distribute, bypass, or tamper with any Digital Rights Management (DRM) technologies, Widevine Content Decryption Modules (CDM), cryptographic keys, or proprietary media streaming protocols.
>    - No proprietary video streams or commercial copyrighted video data are hosted or transmitted by this software. All artwork and video metadata in the demo application are procedural algorithmic fallbacks or mock data intended solely for layout demonstration.

---

## License

The Jetpack Compose recreation code and reverse-engineering scripts are distributed under the [MIT License](https://opensource.org/licenses/MIT).
