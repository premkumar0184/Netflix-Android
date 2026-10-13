#!/usr/bin/env python3
"""
generate_compose_skeleton.py - Jetpack Compose Android App Generator
Generates a complete, production-grade Jetpack Compose starter project using extracted
Hawkins design tokens, Starcourt screen architectures, and Lottie assets.
"""

import os
import sys
import json
import shutil
from pathlib import Path

def generate_compose_app(base_dir: Path, output_dir: Path):
    print("=" * 60)
    print("Stage 6: Generating Modern Jetpack Compose Android App")
    print("=" * 60)
    
    app_root = base_dir / "generated_app"
    java_dir = app_root / "app" / "src" / "main" / "java" / "com" / "recreated" / "netflix"
    res_dir = app_root / "app" / "src" / "main" / "res"
    assets_dir = app_root / "app" / "src" / "main" / "assets"
    
    # Create directory structure
    for d in [
        java_dir / "theme",
        java_dir / "components",
        java_dir / "navigation",
        java_dir / "screens",
        res_dir / "values",
        assets_dir / "lottie"
    ]:
        d.mkdir(parents=True, exist_ok=True)
        
    tokens_file = output_dir / "hawkins_design_tokens.json"
    with open(tokens_file, "r", encoding="utf-8") as f:
        tokens = json.load(f)
        
    # 1. Color.kt
    color_kt = '''package com.recreated.netflix.theme

import androidx.compose.ui.graphics.Color

// Netflix Core Brand Colors
val NetflixRed = Color(0xFFE50914)
val NetflixDarkRed = Color(0xFFB9090B)
val NetflixBloodRed = Color(0xFF590101)

// Hawkins Base Theme (Standard Dark Mode)
val HawkinsBaseBackground = Color(0xFF141414)
val HawkinsBaseSurface = Color(0xFF1F1F1F)
val HawkinsBaseSurfaceSecondary = Color(0xFF2B2B2B)
val HawkinsBaseSurfaceCard = Color(0xFF181818)
val HawkinsBaseForegroundPrimary = Color(0xFFFFFFFF)
val HawkinsBaseForegroundSecondary = Color(0xFFB3B3B3)
val HawkinsBaseForegroundMuted = Color(0xFF9E9E9E)
val HawkinsBaseDivider = Color(0xFF262626)

// Hawkins Eclipse Theme (AMOLED Deep Black)
val HawkinsEclipseBackground = Color(0xFF000000)
val HawkinsEclipseSurface = Color(0xFF121212)
val HawkinsEclipseSurfaceSecondary = Color(0xFF1A1A1A)
val HawkinsEclipseForegroundPrimary = Color(0xFFFFFFFF)
val HawkinsEclipseForegroundSecondary = Color(0xFFCCCCCC)
val HawkinsEclipseForegroundMuted = Color(0xFF9E9E9E)
val HawkinsEclipseDivider = Color(0xFF222222)
'''
    with open(java_dir / "theme" / "Color.kt", "w", encoding="utf-8") as f:
        f.write(color_kt)
        
    # 2. Type.kt
    type_kt = '''package com.recreated.netflix.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Hawkins Typography Scale
val HawkinsTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = (-0.5).sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 24.sp
    ),
    titleSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 15.sp,
        lineHeight = 20.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.2.sp
    )
)
'''
    with open(java_dir / "theme" / "Type.kt", "w", encoding="utf-8") as f:
        f.write(type_kt)
        
    # 3. Theme.kt
    theme_kt = '''package com.recreated.netflix.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class HawkinsColors(
    val background: Color,
    val surface: Color,
    val surfaceSecondary: Color,
    val foregroundPrimary: Color,
    val foregroundSecondary: Color,
    val foregroundMuted: Color,
    val accent: Color,
    val divider: Color
)

val LocalHawkinsColors = staticCompositionLocalOf {
    HawkinsColors(
        background = HawkinsBaseBackground,
        surface = HawkinsBaseSurface,
        surfaceSecondary = HawkinsBaseSurfaceSecondary,
        foregroundPrimary = HawkinsBaseForegroundPrimary,
        foregroundSecondary = HawkinsBaseForegroundSecondary,
        foregroundMuted = HawkinsBaseForegroundMuted,
        accent = NetflixRed,
        divider = HawkinsBaseDivider
    )
}

enum class HawkinsThemeVariant {
    Base,
    Eclipse
}

@Composable
fun NetflixAppTheme(
    variant: HawkinsThemeVariant = HawkinsThemeVariant.Base,
    content: @Composable () -> Unit
) {
    val hawkinsColors = when (variant) {
        HawkinsThemeVariant.Base -> HawkinsColors(
            background = HawkinsBaseBackground,
            surface = HawkinsBaseSurface,
            surfaceSecondary = HawkinsBaseSurfaceSecondary,
            foregroundPrimary = HawkinsBaseForegroundPrimary,
            foregroundSecondary = HawkinsBaseForegroundSecondary,
            foregroundMuted = HawkinsBaseForegroundMuted,
            accent = NetflixRed,
            divider = HawkinsBaseDivider
        )
        HawkinsThemeVariant.Eclipse -> HawkinsColors(
            background = HawkinsEclipseBackground,
            surface = HawkinsEclipseSurface,
            surfaceSecondary = HawkinsEclipseSurfaceSecondary,
            foregroundPrimary = HawkinsEclipseForegroundPrimary,
            foregroundSecondary = HawkinsEclipseForegroundSecondary,
            foregroundMuted = HawkinsEclipseForegroundMuted,
            accent = NetflixRed,
            divider = HawkinsEclipseDivider
        )
    }

    val materialColors = darkColorScheme(
        primary = NetflixRed,
        background = hawkinsColors.background,
        surface = hawkinsColors.surface,
        onPrimary = Color.White,
        onBackground = hawkinsColors.foregroundPrimary,
        onSurface = hawkinsColors.foregroundPrimary
    )

    CompositionLocalProvider(LocalHawkinsColors provides hawkinsColors) {
        MaterialTheme(
            colorScheme = materialColors,
            typography = HawkinsTypography,
            content = content
        )
    }
}
'''
    with open(java_dir / "theme" / "Theme.kt", "w", encoding="utf-8") as f:
        f.write(theme_kt)
        
    # 4. HawkinsButton.kt
    button_kt = '''package com.recreated.netflix.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.recreated.netflix.theme.LocalHawkinsColors
import com.recreated.netflix.theme.NetflixRed

enum class HawkinsButtonType {
    Primary,
    Secondary,
    Tertiary,
    Supplemental,
    Brand,
    Destructive
}

enum class HawkinsButtonSize(val iconSize: Dp, val height: Dp) {
    Small(iconSize = 16.dp, height = 32.dp),
    Standard(iconSize = 24.dp, height = 40.dp),
    Large(iconSize = 36.dp, height = 48.dp)
}

@Composable
fun HawkinsButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    type: HawkinsButtonType = HawkinsButtonType.Primary,
    size: HawkinsButtonSize = HawkinsButtonSize.Standard,
    leadingIcon: ImageVector? = null,
    enabled: Boolean = true
) {
    val hawkinsColors = LocalHawkinsColors.current

    val (containerColor, contentColor) = when (type) {
        HawkinsButtonType.Primary -> Color.White to Color.Black
        HawkinsButtonType.Secondary -> Color.White.copy(alpha = 0.2f) to Color.White
        HawkinsButtonType.Tertiary -> Color.Transparent to Color.White
        HawkinsButtonType.Supplemental -> hawkinsColors.surfaceSecondary to hawkinsColors.foregroundPrimary
        HawkinsButtonType.Brand -> NetflixRed to Color.White
        HawkinsButtonType.Destructive -> Color(0xFFCC0000) to Color.White
    }

    Button(
        onClick = onClick,
        modifier = modifier.height(size.height),
        enabled = enabled,
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = containerColor.copy(alpha = 0.4f),
            disabledContentColor = contentColor.copy(alpha = 0.4f)
        ),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        if (leadingIcon != null) {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null,
                modifier = Modifier.size(size.iconSize)
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge
        )
    }
}
'''
    with open(java_dir / "components" / "HawkinsButton.kt", "w", encoding="utf-8") as f:
        f.write(button_kt)
        
    # 5. HawkinsTag.kt
    tag_kt = '''package com.recreated.netflix.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.recreated.netflix.theme.NetflixRed

@Composable
fun HawkinsTag(
    text: String,
    modifier: Modifier = Modifier,
    isTop10: Boolean = false
) {
    val bgColor = if (isTop10) NetflixRed else Color.White.copy(alpha = 0.15f)
    val textColor = Color.White

    Text(
        text = text.uppercase(),
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold,
        color = textColor,
        modifier = modifier
            .background(bgColor, RoundedCornerShape(2.dp))
            .padding(horizontal = 6.dp, vertical = 2.dp)
    )
}
'''
    with open(java_dir / "components" / "HawkinsTag.kt", "w", encoding="utf-8") as f:
        f.write(tag_kt)
        
    # 6. BillboardHero.kt
    billboard_kt = '''package com.recreated.netflix.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.recreated.netflix.theme.LocalHawkinsColors

@Composable
fun BillboardHero(
    title: String,
    categories: List<String>,
    onPlayClick: () -> Unit,
    onMyListClick: () -> Unit,
    onInfoClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val hawkinsColors = LocalHawkinsColors.current

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(520.dp)
            .background(Color(0xFF181818))
    ) {
        // Gradient overlay simulating the dark vignette scrim
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Transparent,
                            hawkinsColors.background.copy(alpha = 0.6f),
                            hawkinsColors.background
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp, start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HawkinsTag(text = "Top 10 in TV Shows Today", isTop10 = true)
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = title,
                fontSize = 32.sp,
                fontWeight = FontWeight.Black,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = categories.joinToString(" • "),
                fontSize = 12.sp,
                color = hawkinsColors.foregroundSecondary
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                HawkinsButton(
                    text = "My List",
                    onClick = onMyListClick,
                    type = HawkinsButtonType.Secondary,
                    leadingIcon = Icons.Default.Add,
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(12.dp))

                HawkinsButton(
                    text = "Play",
                    onClick = onPlayClick,
                    type = HawkinsButtonType.Primary,
                    leadingIcon = Icons.Default.PlayArrow,
                    modifier = Modifier.weight(1.2f)
                )

                Spacer(modifier = Modifier.width(12.dp))

                HawkinsButton(
                    text = "Info",
                    onClick = onInfoClick,
                    type = HawkinsButtonType.Secondary,
                    leadingIcon = Icons.Default.Info,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}
'''
    with open(java_dir / "components" / "BillboardHero.kt", "w", encoding="utf-8") as f:
        f.write(billboard_kt)
        
    # 7. LolomoRow.kt
    lolomo_kt = '''package com.recreated.netflix.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class MediaItem(
    val id: String,
    val title: String,
    val isTop10: Boolean = false,
    val rank: Int? = null
)

@Composable
fun LolomoRow(
    rowTitle: String,
    items: List<MediaItem>,
    onItemClick: (MediaItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth().padding(vertical = 10.dp)) {
        Text(
            text = rowTitle,
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(items) { index, item ->
                MovieCard(item = item, onClick = { onItemClick(item) })
            }
        }
    }
}

@Composable
fun MovieCard(
    item: MediaItem,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(115.dp)
            .height(165.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(Color(0xFF262626))
            .clickable { onClick() }
    ) {
        // Placeholder poster surface
        Text(
            text = item.title,
            color = Color.White.copy(alpha = 0.8f),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(8.dp)
        )

        if (item.isTop10 && item.rank != null) {
            HawkinsTag(
                text = "#${item.rank}",
                isTop10 = true,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(4.dp)
            )
        }
    }
}
'''
    with open(java_dir / "components" / "LolomoRow.kt", "w", encoding="utf-8") as f:
        f.write(lolomo_kt)
        
    # 8. HomeScreen.kt
    home_kt = '''package com.recreated.netflix.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cast
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.recreated.netflix.components.BillboardHero
import com.recreated.netflix.components.LolomoRow
import com.recreated.netflix.components.MediaItem
import com.recreated.netflix.theme.LocalHawkinsColors
import com.recreated.netflix.theme.NetflixRed

@Composable
fun HomeScreen(
    onNavigateToDetails: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val hawkinsColors = LocalHawkinsColors.current

    // Sample Lolomo feed items
    val trendingItems = listOf(
        MediaItem("1", "Stranger Things", isTop10 = true, rank = 1),
        MediaItem("2", "Squid Game", isTop10 = true, rank = 2),
        MediaItem("3", "Wednesday", isTop10 = true, rank = 3),
        MediaItem("4", "Bridgerton"),
        MediaItem("5", "The Witcher")
    )

    val popularItems = listOf(
        MediaItem("6", "Red Notice"),
        MediaItem("7", "Glass Onion"),
        MediaItem("8", "The Gray Man"),
        MediaItem("9", "Extraction 2")
    )

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .statusBarsPadding()
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "N",
                    color = NetflixRed,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Black
                )

                Spacer(modifier = Modifier.weight(1f))

                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Cast, contentDescription = "Cast", tint = Color.White)
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search", tint = Color.White)
                }
            }
        },
        containerColor = hawkinsColors.background
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(bottom = innerPadding.calculateBottomPadding())
        ) {
            item {
                BillboardHero(
                    title = "Stranger Things",
                    categories = listOf("Sci-Fi", "Suspenseful", "Nostalgic", "80s"),
                    onPlayClick = { onNavigateToDetails("1") },
                    onMyListClick = {},
                    onInfoClick = { onNavigateToDetails("1") }
                )
            }

            item {
                LolomoRow(
                    rowTitle = "Continue Watching",
                    items = trendingItems,
                    onItemClick = { onNavigateToDetails(it.id) }
                )
            }

            item {
                LolomoRow(
                    rowTitle = "Trending Now",
                    items = popularItems,
                    onItemClick = { onNavigateToDetails(it.id) }
                )
            }

            item {
                LolomoRow(
                    rowTitle = "Top 10 TV Shows Today",
                    items = trendingItems,
                    onItemClick = { onNavigateToDetails(it.id) }
                )
            }
        }
    }
}
'''
    with open(java_dir / "screens" / "HomeScreen.kt", "w", encoding="utf-8") as f:
        f.write(home_kt)
        
    # 9. AppNavigation.kt
    # 9. AppNavigation.kt
    nav_kt = '''package com.recreated.netflix.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.recreated.netflix.screens.HomeScreen
import com.recreated.netflix.theme.LocalHawkinsColors
import com.recreated.netflix.theme.NetflixRed

enum class NavigationTab(
    val title: String,
    val icon: ImageVector
) {
    Home("Home", Icons.Default.Home),
    Games("Games", Icons.Default.PlayArrow),
    NewAndHot("New & Hot", Icons.Default.VideoLibrary),
    MyNetflix("My Netflix", Icons.Default.Person)
}

@Composable
fun AppNavigation() {
    val hawkinsColors = LocalHawkinsColors.current
    var currentTab by remember { mutableStateOf(NavigationTab.Home) }

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = hawkinsColors.background,
                contentColor = Color.White
            ) {
                NavigationTab.entries.forEach { tab ->
                    NavigationBarItem(
                        selected = currentTab == tab,
                        onClick = { currentTab = tab },
                        icon = {
                            Icon(
                                imageVector = tab.icon,
                                contentDescription = tab.title
                            )
                        },
                        label = { Text(tab.title) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.White,
                            selectedTextColor = Color.White,
                            indicatorColor = Color.Transparent,
                            unselectedIconColor = hawkinsColors.foregroundSecondary,
                            unselectedTextColor = hawkinsColors.foregroundSecondary
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        when (currentTab) {
            NavigationTab.Home -> HomeScreen(
                onNavigateToDetails = {},
                modifier = Modifier.padding(innerPadding)
            )
            NavigationTab.Games -> HomeScreen(
                onNavigateToDetails = {},
                modifier = Modifier.padding(innerPadding)
            )
            NavigationTab.NewAndHot -> HomeScreen(
                onNavigateToDetails = {},
                modifier = Modifier.padding(innerPadding)
            )
            NavigationTab.MyNetflix -> HomeScreen(
                onNavigateToDetails = {},
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
'''
    with open(java_dir / "navigation" / "AppNavigation.kt", "w", encoding="utf-8") as f:
        f.write(nav_kt)
        
    # 10. MainActivity.kt
    main_activity_kt = '''package com.recreated.netflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.recreated.netflix.navigation.AppNavigation
import com.recreated.netflix.theme.NetflixAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NetflixAppTheme {
                AppNavigation()
            }
        }
    }
}
'''
    with open(java_dir / "MainActivity.kt", "w", encoding="utf-8") as f:
        f.write(main_activity_kt)
        
    # 11. AndroidManifest.xml
    manifest_xml = '''<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="Recreated Netflix"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@android:style/Theme.Material.NoActionBar">
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
</manifest>
'''
    with open(app_root / "app" / "src" / "main" / "AndroidManifest.xml", "w", encoding="utf-8") as f:
        f.write(manifest_xml)

    # 12. Gradle configuration
    build_gradle = '''plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.recreated.netflix"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.recreated.netflix"
        minSdk = 28
        targetSdk = 35
        versionCode = 1
        versionName = "1.0.0"
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    kotlinOptions {
        jvmTarget = "21"
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.material.icons.extended)
    implementation(libs.androidx.activity.compose)
    implementation(libs.airbnb.lottie.compose)
    implementation(libs.coil.compose)
}
'''
    with open(app_root / "app" / "build.gradle.kts", "w", encoding="utf-8") as f:
        f.write(build_gradle)
        
    # Copy all enhanced templates if available
    templates_dir = base_dir / "tools" / "compose_templates"
    if templates_dir.exists():
        for src_file in templates_dir.rglob("*.kt"):
            rel_path = src_file.relative_to(templates_dir)
            dest_file = java_dir / rel_path
            dest_file.parent.mkdir(parents=True, exist_ok=True)
            shutil.copy2(src_file, dest_file)
        print(f"[+] Synced {len(list(templates_dir.rglob('*.kt')))} Kotlin UI modules from templates")

    # Ensure launcher icons from app_icon.png
    icon_src = output_dir / "ui_assets" / "app_icon.png"
    if icon_src.exists():
        mipmap_dir = res_dir / "mipmap-xxhdpi"
        mipmap_dir.mkdir(parents=True, exist_ok=True)
        shutil.copy2(icon_src, mipmap_dir / "ic_launcher.png")
        shutil.copy2(icon_src, mipmap_dir / "ic_launcher_round.png")

    # Ensure strings.xml and colors.xml exist
    strings_xml_path = res_dir / "values" / "strings.xml"
    if not strings_xml_path.exists():
        strings_xml_path.write_text('<?xml version="1.0" encoding="utf-8"?>\n<resources>\n    <string name="app_name">Recreated Netflix</string>\n</resources>\n', encoding="utf-8")
    colors_xml_path = res_dir / "values" / "colors.xml"
    if not colors_xml_path.exists():
        colors_xml_path.write_text('<?xml version="1.0" encoding="utf-8"?>\n<resources>\n    <color name="netflix_red">#E50914</color>\n    <color name="black">#FF000000</color>\n    <color name="white">#FFFFFFFF</color>\n</resources>\n', encoding="utf-8")

    # Ensure local.properties exists
    local_props_path = app_root / "local.properties"
    if not local_props_path.exists():
        sdk_path = Path("/home/prem/Android/Sdk")
        if sdk_path.exists():
            local_props_path.write_text(f"sdk.dir={sdk_path}\n", encoding="utf-8")

    # Ensure gradle.properties exists
    gradle_props_path = app_root / "gradle.properties"
    if not gradle_props_path.exists():
        gradle_props_path.write_text("org.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8\nandroid.useAndroidX=true\nandroid.nonTransitiveRClass=true\n", encoding="utf-8")

    # Copy Lottie files to generated app assets
    lottie_src = output_dir / "ui_assets" / "lottiefiles"
    if lottie_src.exists():
        for lf in lottie_src.glob("*.json"):
            shutil.copy(lf, assets_dir / "lottie" / lf.name)
        print(f"[+] Transferred Lottie micro-animations into {assets_dir / 'lottie'}")
        
    print(f"[+] Android Jetpack Compose app generated successfully in: {app_root}")
    return app_root

if __name__ == "__main__":
    base = Path(__file__).resolve().parent.parent
    out = base / "extraction_output"
    generate_compose_app(base, out)
