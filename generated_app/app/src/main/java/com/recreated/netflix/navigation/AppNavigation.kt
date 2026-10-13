package com.recreated.netflix.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.recreated.netflix.screens.DetailsScreen
import com.recreated.netflix.screens.GamesScreen
import com.recreated.netflix.screens.HomeScreen
import com.recreated.netflix.screens.MyNetflixScreen
import com.recreated.netflix.screens.NewAndHotScreen
import com.recreated.netflix.screens.PlayerScreen
import com.recreated.netflix.screens.ProfilePickerScreen
import com.recreated.netflix.screens.SearchScreen
import com.recreated.netflix.theme.HawkinsThemeVariant
import com.recreated.netflix.theme.LocalHawkinsColors
import com.recreated.netflix.theme.NetflixAppTheme
import com.recreated.netflix.theme.NetflixRed
import com.recreated.netflix.theme.NetflixRedGlow

enum class NavigationTab(
    val title: String,
    val icon: ImageVector
) {
    Home("Home", Icons.Default.Home),
    Games("Games", Icons.Default.PlayArrow),
    NewAndHot("New & Hot", Icons.Default.VideoLibrary),
    MyNetflix("My Netflix", Icons.Default.Person)
}

private sealed interface AppDestination {
    data class Player(val title: String) : AppDestination
    data class Details(val mediaId: String) : AppDestination
    data object Search : AppDestination
    data object ProfilePicker : AppDestination
    data class Main(val tab: NavigationTab) : AppDestination
}

@Composable
fun AppNavigation() {
    var themeVariant by remember { mutableStateOf(HawkinsThemeVariant.Base) }

    NetflixAppTheme(variant = themeVariant) {
        val hawkinsColors = LocalHawkinsColors.current
        var currentTab by remember { mutableStateOf(NavigationTab.Home) }
        var currentProfileName by remember { mutableStateOf("Prem") }
        var currentProfileColor by remember { mutableStateOf(NetflixRed) }
        var selectedMediaId by remember { mutableStateOf<String?>(null) }
        var playingMediaTitle by remember { mutableStateOf<String?>(null) }
        var isSearching by remember { mutableStateOf(false) }
        var isSelectingProfile by remember { mutableStateOf(false) }

        val currentDestination: AppDestination = when {
            playingMediaTitle != null -> AppDestination.Player(playingMediaTitle!!)
            selectedMediaId != null -> AppDestination.Details(selectedMediaId!!)
            isSearching -> AppDestination.Search
            isSelectingProfile -> AppDestination.ProfilePicker
            else -> AppDestination.Main(currentTab)
        }

        AnimatedContent(
            targetState = currentDestination,
            transitionSpec = {
                fadeIn(animationSpec = tween(240)) togetherWith fadeOut(animationSpec = tween(200))
            },
            label = "app_destination_transition"
        ) { destination ->
            when (destination) {
                is AppDestination.Player -> {
                    BackHandler { playingMediaTitle = null }
                    PlayerScreen(
                        title = destination.title,
                        onCloseClick = { playingMediaTitle = null }
                    )
                }
                is AppDestination.Details -> {
                    BackHandler { selectedMediaId = null }
                    DetailsScreen(
                        mediaId = destination.mediaId,
                        onCloseClick = { selectedMediaId = null },
                        onPlayClick = { title -> playingMediaTitle = title },
                        onNavigateToDetails = { newId -> selectedMediaId = newId }
                    )
                }
                is AppDestination.Search -> {
                    BackHandler { isSearching = false }
                    SearchScreen(
                        onNavigateToDetails = {
                            selectedMediaId = it
                            isSearching = false
                        },
                        onCloseClick = { isSearching = false }
                    )
                }
                is AppDestination.ProfilePicker -> {
                    BackHandler { isSelectingProfile = false }
                    ProfilePickerScreen(
                        onProfileSelected = { profile ->
                            currentProfileName = profile.name
                            currentProfileColor = profile.color
                            isSelectingProfile = false
                        }
                    )
                }
                is AppDestination.Main -> {
                Scaffold(
                    contentWindowInsets = WindowInsets(0.dp),
                    bottomBar = {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(hawkinsColors.background.copy(alpha = 0.98f))
                        ) {
                            // Subtle top border divider line
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(hawkinsColors.divider)
                            )

                            // Elevated Bottom Navigation Bar with Active Glow Indicators
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(58.dp)
                                    .selectableGroup(),
                                horizontalArrangement = Arrangement.SpaceAround,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                NavigationTab.entries.forEach { tab ->
                                    val isSelected = currentTab == tab
                                    val indicatorWidth by animateDpAsState(
                                        targetValue = if (isSelected) 26.dp else 0.dp,
                                        animationSpec = tween(durationMillis = 200, easing = FastOutSlowInEasing),
                                        label = "tab_indicator_width"
                                    )
                                    val glowAlpha by animateFloatAsState(
                                        targetValue = if (isSelected) 0.25f else 0f,
                                        animationSpec = tween(durationMillis = 200, easing = FastOutSlowInEasing),
                                        label = "tab_glow_alpha"
                                    )
                                    val itemColor by animateColorAsState(
                                        targetValue = if (isSelected) Color.White else hawkinsColors.foregroundMuted,
                                        animationSpec = tween(durationMillis = 200, easing = FastOutSlowInEasing),
                                        label = "tab_item_color"
                                    )

                                    Column(
                                        modifier = Modifier
                                            .weight(1f)
                                            .fillMaxHeight()
                                            .defaultMinSize(minWidth = 48.dp, minHeight = 48.dp)
                                            .clickable(
                                                interactionSource = remember { MutableInteractionSource() },
                                                indication = ripple(bounded = false, radius = 28.dp, color = NetflixRed.copy(alpha = 0.25f))
                                            ) { currentTab = tab }
                                            .semantics {
                                                role = Role.Tab
                                                this.selected = isSelected
                                                contentDescription = "${tab.title} tab, ${if (isSelected) "Active" else "Inactive"}"
                                            },
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        // Active Tab Top Glow Line Indicator with smooth width animation
                                        Box(
                                            modifier = Modifier
                                                .width(indicatorWidth)
                                                .height(3.dp)
                                                .clip(RoundedCornerShape(bottomStart = 3.dp, bottomEnd = 3.dp))
                                                .background(if (indicatorWidth > 0.dp) NetflixRed else Color.Transparent)
                                        )

                                        Spacer(modifier = Modifier.weight(1f))

                                        // Tab Icon with active glow when selected
                                        Box(
                                            contentAlignment = Alignment.Center
                                        ) {
                                            if (glowAlpha > 0.01f) {
                                                Box(
                                                    modifier = Modifier
                                                        .size(32.dp)
                                                        .clip(RoundedCornerShape(16.dp))
                                                        .background(NetflixRedGlow.copy(alpha = glowAlpha))
                                                )
                                            }
                                            Icon(
                                                imageVector = tab.icon,
                                                contentDescription = null,
                                                tint = itemColor,
                                                modifier = Modifier.size(24.dp)
                                            )
                                        }

                                        Spacer(modifier = Modifier.height(4.dp))

                                        // Tab Label
                                        Text(
                                            text = tab.title,
                                            color = itemColor,
                                            fontSize = 11.sp,
                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                                        )

                                        Spacer(modifier = Modifier.height(6.dp))
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.navigationBarsPadding())
                        }
                    }
                ) { innerPadding ->
                    val bottomPadding = innerPadding.calculateBottomPadding()
                    AnimatedContent(
                        targetState = currentTab,
                        transitionSpec = {
                            fadeIn(animationSpec = tween(200)) togetherWith fadeOut(animationSpec = tween(160))
                        },
                        label = "tab_content_transition"
                    ) { activeTab ->
                        when (activeTab) {
                            NavigationTab.Home -> HomeScreen(
                                onNavigateToDetails = { selectedMediaId = it },
                                onSearchClick = { isSearching = true },
                                onPlayClick = { playingMediaTitle = it },
                                profileName = currentProfileName,
                                bottomNavPadding = bottomPadding
                            )
                            NavigationTab.Games -> GamesScreen(
                                onNavigateToGameDetail = { selectedMediaId = it },
                                bottomNavPadding = bottomPadding
                            )
                            NavigationTab.NewAndHot -> NewAndHotScreen(
                                onNavigateToDetails = { selectedMediaId = it },
                                bottomNavPadding = bottomPadding
                            )
                            NavigationTab.MyNetflix -> MyNetflixScreen(
                                onNavigateToDetails = { selectedMediaId = it },
                                onSwitchProfileClick = { isSelectingProfile = true },
                                profileName = currentProfileName,
                                profileColor = currentProfileColor,
                                isEclipseTheme = (themeVariant == HawkinsThemeVariant.Eclipse),
                                onToggleTheme = {
                                    themeVariant = if (themeVariant == HawkinsThemeVariant.Base) {
                                        HawkinsThemeVariant.Eclipse
                                    } else {
                                        HawkinsThemeVariant.Base
                                    }
                                },
                                bottomNavPadding = bottomPadding
                            )
                        }
                    }
                }
            }
        }
    }
}
}


