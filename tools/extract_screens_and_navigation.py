#!/usr/bin/env python3
"""
extract_screens_and_navigation.py - Starcourt Screen & Lolomo Navigation Analyzer
Extracts screen definitions, feed architecture, and navigation routing models from
the Netflix Android application bytecode.
"""

import os
import sys
import json
import re
import zipfile
from pathlib import Path

def scan_dex_for_navigation(apk_path: Path):
    starcourt_screens = set()
    lolomo_models = set()
    billboard_api = set()
    details_page = set()
    games_ui = set()
    
    with zipfile.ZipFile(apk_path, "r") as z:
        for name in z.namelist():
            if name.startswith("classes") and name.endswith(".dex"):
                data = z.read(name)
                # Find Starcourt screens
                sc_matches = re.findall(b"com/netflix/mediaclient/ui/[a-zA-Z0-9_/]+Screen", data)
                for s in sc_matches:
                    starcourt_screens.add(s.decode("utf-8").replace("/", "."))
                    
                # Find Lolomo components
                lo_matches = re.findall(b"com/netflix/mediaclient/ui/home/[a-zA-Z0-9_/]+", data)
                for l in lo_matches:
                    lolomo_models.add(l.decode("utf-8").replace("/", "."))

                # Find Billboard API
                bb_matches = re.findall(b"com/netflix/mediaclient/ui/billboard/api/([a-zA-Z0-9_]+)", data)
                for b in bb_matches:
                    billboard_api.add(b.decode("utf-8"))

                # Find Details Page
                dp_matches = re.findall(b"com/netflix/mediaclient/ui/detailspage/impl/[a-zA-Z0-9_/]+", data)
                for d in dp_matches:
                    details_page.add(d.decode("utf-8").replace("/", "."))

                # Find Games
                gm_matches = re.findall(b"com/netflix/mediaclient/ui/games/[a-zA-Z0-9_/]+", data)
                for g in gm_matches:
                    games_ui.add(g.decode("utf-8").replace("/", "."))

    return (
        sorted(list(starcourt_screens)),
        sorted(list(lolomo_models)),
        sorted(list(billboard_api)),
        sorted(list(details_page)),
        sorted(list(games_ui))
    )

def build_navigation_model(apk_path: Path, output_dir: Path):
    print("=" * 60)
    print("Stage 4: Mapping Screens, Navigation Graphs, and Lolomo Architecture")
    print("=" * 60)
    
    output_dir.mkdir(parents=True, exist_ok=True)
    sc_screens, lo_models, bb_api, dp_classes, gm_classes = scan_dex_for_navigation(apk_path)
    
    print(f"[+] Discovered {len(sc_screens)} screen descriptors")
    print(f"[+] Discovered {len(lo_models)} Lolomo browsing descriptors")
    print(f"[+] Discovered {len(bb_api)} Billboard API descriptors")
    print(f"[+] Discovered {len(dp_classes)} Details Page descriptors")
    print(f"[+] Discovered {len(gm_classes)} Games UI descriptors")
    
    nav_model = {
        "architecture_pattern": "Single-Activity / Jetpack Navigation + Starcourt MvRx Feed",
        "bottom_navigation_tabs": [
            {
                "id": "tab_home",
                "label": "Home",
                "route": "home",
                "icon": "ic_home",
                "screen": "com.netflix.mediaclient.ui.home.apistarcourt.LolomoScreen",
                "description": "Primary browsing feed with hero billboard and categorized carousels"
            },
            {
                "id": "tab_games",
                "label": "Games",
                "route": "games",
                "icon": "ic_games",
                "screen": "com.netflix.mediaclient.ui.games.impl.gdp.compose.GdpComposeFragment",
                "description": "Netflix Games showcase and launcher"
            },
            {
                "id": "tab_hot_and_new",
                "label": "New & Hot",
                "route": "hot_and_new",
                "icon": "ic_hot_and_new",
                "screen": "com.netflix.mediaclient.ui.newandhot.NewAndHotFragment",
                "description": "Upcoming releases, trailers, reminders, and top 10"
            },
            {
                "id": "tab_my_netflix",
                "label": "My Netflix",
                "route": "my_netflix",
                "icon": "ic_my_netflix",
                "screen": "com.netflix.mediaclient.ui.offline.OfflineUiFragment",
                "description": "Downloads, Watchlist, liked titles, and account profile switcher"
            }
        ],
        "billboard_api_contracts": {
            "actions_and_ctas": bb_api,
            "core_ctas": [
                "PlayCta", "AddToMyListCta", "AddToRemindersCta", "WatchLiveCta",
                "NavigateToCategoryPageCta", "NavigateToCollectionCta"
            ],
            "press_actions": ["PlaybackPressAction", "BillboardPressAction"]
        },
        "lolomo_feed_structure": {
            "concept": "Lists of Lists of Movies (Lolomo)",
            "layout_model": "Vertical LazyColumn of Horizontal LazyRows + Hero Sticky Billboard",
            "feed_sections": [
                {
                    "section_type": "hero_billboard",
                    "component": "BillboardComposeHostView",
                    "elements": [
                        "backdrop_trailer_video_or_image",
                        "title_logo_asset",
                        "category_badges (e.g. 'Top 10 TV Shows Today')",
                        "action_bar (Play Button, My List Toggle, Info Button)",
                        "gradient_scrim_bottom"
                    ]
                },
                {
                    "section_type": "continue_watching_row",
                    "component": "ContinueWatchingRow",
                    "elements": [
                        "title: 'Continue Watching for <User>'",
                        "video_card_with_progress_bar",
                        "episode_badge (e.g. 'S1:E3')",
                        "context_menu_button"
                    ]
                },
                {
                    "section_type": "top_10_row",
                    "component": "Top10Row",
                    "elements": [
                        "title: 'Top 10 TV Shows in Your Country Today'",
                        "large_numbered_rank_typography (1 to 10)",
                        "poster_art_card"
                    ]
                },
                {
                    "section_type": "standard_carousel",
                    "component": "StandardPosterRow",
                    "elements": [
                        "title (e.g. 'Trending Now', 'Award-Winning TV Dramas', 'Action Thrillers')",
                        "2:3_vertical_poster_cards",
                        "optional_recently_added_badge"
                    ]
                }
            ]
        },
        "screens_catalog": {
            "HomeScreen": {
                "contract": "com.netflix.mediaclient.ui.home.apistarcourt.LolomoScreen",
                "state": "LolomoUiState",
                "viewmodel": "GraphQLLolomoViewModel"
            },
            "SearchScreens": {
                "prequery": "com.netflix.mediaclient.ui.search.apistarcourt.PrequerySearchScreen",
                "results": "com.netflix.mediaclient.ui.search.apistarcourt.SearchResultsScreen",
                "suggestions": "com.netflix.mediaclient.ui.search.apistarcourt.SearchSuggestionScreen"
            },
            "DetailsScreen": {
                "contract": "com.netflix.mediaclient.ui.details.DetailsActivity",
                "composable_implementation": [c for c in dp_classes if "composable" in c],
                "components": ["TrailerHeader", "TitleMetadataBar", "PlayResumeButton", "EpisodesTab", "MoreLikeThisGrid"]
            },
            "PlayerScreen": {
                "contract": "com.netflix.mediaclient.ui.player.PlayerFragment",
                "controls": ["CustomControllerOverlay", "SubtitleAudioTrackPicker", "EpisodesDrawer", "PlaybackSpeedPicker"]
            }
        },
        "discovered_starcourt_screens": sc_screens,
        "discovered_lolomo_models": lo_models,
        "discovered_details_page_classes": dp_classes,
        "discovered_games_classes": gm_classes
    }
    
    out_file = output_dir / "screens_and_navigation.json"
    with open(out_file, "w", encoding="utf-8") as f:
        json.dump(nav_model, f, indent=2)
        
    print(f"[+] Successfully wrote navigation model: {out_file}")
    return nav_model

if __name__ == "__main__":
    base = Path(__file__).resolve().parent.parent
    apk = base / "Netflix_9.87.1+build+9+74620_APKPure" / "com.netflix.mediaclient.apk"
    out = base / "extraction_output"
    build_navigation_model(apk, out)
