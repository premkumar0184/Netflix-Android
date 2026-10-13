package com.recreated.netflix.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.recreated.netflix.components.*
import com.recreated.netflix.theme.LocalHawkinsColors
import com.recreated.netflix.theme.NetflixRed

@Composable
fun MyNetflixScreen(
    onNavigateToDetails: (String) -> Unit,
    onSwitchProfileClick: () -> Unit,
    modifier: Modifier = Modifier,
    profileName: String = "Prem",
    profileColor: Color = NetflixRed,
    isEclipseTheme: Boolean = false,
    onToggleTheme: (() -> Unit)? = null,
    bottomNavPadding: androidx.compose.ui.unit.Dp = 0.dp,
    initialLoadingState: ScreenLoadingState = ScreenLoadingState.Content
) {
    val hawkinsColors = LocalHawkinsColors.current
    var screenState by remember { mutableStateOf(initialLoadingState) }
    var showEmptyDownloadsDialog by remember { mutableStateOf(false) }

    val myListItems = listOfNotNull(
        NetflixMediaCatalog["1"],
        NetflixMediaCatalog["2"],
        NetflixMediaCatalog["4"],
        NetflixMediaCatalog["5"],
        NetflixMediaCatalog["7"]
    )

    val likedItems = listOfNotNull(
        NetflixMediaCatalog["3"],
        NetflixMediaCatalog["6"],
        NetflixMediaCatalog["8"],
        NetflixMediaCatalog["9"]
    )

    Scaffold(
        modifier = modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets(0.dp),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Black.copy(alpha = 0.9f),
                                Color.Black.copy(alpha = 0.6f),
                                Color.Transparent
                            )
                        )
                    )
                    .statusBarsPadding()
                    .padding(horizontal = 16.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "My Netflix",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.weight(1f))

                IconButton(
                    onClick = {},
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Cast,
                        contentDescription = "Cast to Device",
                        tint = Color.White
                    )
                }
                IconButton(
                    onClick = {},
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Catalog",
                        tint = Color.White
                    )
                }
                IconButton(
                    onClick = {},
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Account Settings Menu",
                        tint = Color.White
                    )
                }
            }
        },
        containerColor = hawkinsColors.background
    ) { innerPadding ->
        when (screenState) {
            ScreenLoadingState.Loading -> {
                MyNetflixShimmer(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            top = innerPadding.calculateTopPadding(),
                            bottom = bottomNavPadding
                        )
                )
            }
            ScreenLoadingState.Empty -> {
                EmptyStateView(
                    title = "Your Watchlist is Empty",
                    message = "Explore movies and TV shows, and tap + My List to save favorites for later.",
                    actionLabel = "Browse Catalog",
                    onAction = { screenState = ScreenLoadingState.Content },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            top = innerPadding.calculateTopPadding(),
                            bottom = bottomNavPadding
                        )
                )
            }
            ScreenLoadingState.Error -> {
                ErrorStateView(
                    title = "Couldn't load profile details",
                    message = "Unable to sync your profile and downloads right now.",
                    onRetry = { screenState = ScreenLoadingState.Content },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            top = innerPadding.calculateTopPadding(),
                            bottom = bottomNavPadding
                        )
                )
            }
            ScreenLoadingState.Content -> {
                LazyColumn(
                    contentPadding = PaddingValues(
                        top = innerPadding.calculateTopPadding(),
                        bottom = bottomNavPadding + 16.dp
                    ),
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Profile Header Card
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp, bottom = 24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            HawkinsAvatar(
                                name = profileName,
                                size = HawkinsAvatarSize.ExtraLarge,
                                avatarColor = profileColor,
                                onClick = onSwitchProfileClick
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .defaultMinSize(minHeight = 48.dp)
                                    .semantics(mergeDescendants = true) {
                                        role = Role.Button
                                        contentDescription = "Current profile: $profileName. Tap to switch profile."
                                    }
                                    .clickable { onSwitchProfileClick() }
                                    .padding(horizontal = 16.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    text = profileName,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowDown,
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            }
                        }
                    }

                    // Notifications Row with 48dp Touch Target
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .defaultMinSize(minHeight = 56.dp)
                                .semantics(mergeDescendants = true) {
                                    role = Role.Button
                                    contentDescription = "Notifications, 3 new releases waiting for you"
                                }
                                .clickable {}
                                .padding(horizontal = 16.dp, vertical = 10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .background(NetflixRed),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Notifications,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(22.dp)
                                )
                            }

                            Spacer(modifier = Modifier.width(16.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "Notifications",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.White
                                )
                                Text(
                                    text = "3 new releases waiting for you",
                                    fontSize = 12.sp,
                                    color = hawkinsColors.foregroundSecondary
                                )
                            }

                            Icon(
                                imageVector = Icons.Default.ChevronRight,
                                contentDescription = null,
                                tint = hawkinsColors.foregroundSecondary
                            )
                        }
                        HawkinsDivider(modifier = Modifier.padding(horizontal = 16.dp))
                    }

                    // Downloads Row with 48dp Touch Target
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .defaultMinSize(minHeight = 56.dp)
                                .semantics(mergeDescendants = true) {
                                    role = Role.Button
                                    contentDescription = "Downloads, Smart Downloads 4 episodes 1.2 GB"
                                }
                                .clickable { showEmptyDownloadsDialog = true }
                                .padding(horizontal = 16.dp, vertical = 10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFF0071EB)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Download,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(22.dp)
                                )
                            }

                            Spacer(modifier = Modifier.width(16.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "Downloads",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.White
                                )
                                Text(
                                    text = "Smart Downloads • 4 episodes (1.2 GB)",
                                    fontSize = 12.sp,
                                    color = hawkinsColors.foregroundSecondary
                                )
                            }

                            Icon(
                                imageVector = Icons.Default.ChevronRight,
                                contentDescription = null,
                                tint = hawkinsColors.foregroundSecondary
                            )
                        }
                        HawkinsDivider(modifier = Modifier.padding(horizontal = 16.dp))
                    }

                    // Theme Appearance Row (Base vs Eclipse)
                    if (onToggleTheme != null) {
                        item {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .defaultMinSize(minHeight = 56.dp)
                                    .semantics(mergeDescendants = true) {
                                        role = Role.Switch
                                        this.selected = isEclipseTheme
                                        contentDescription = "Hawkins Dark Theme, ${if (isEclipseTheme) "Eclipse AMOLED active. Tap to switch to Base Dark." else "Base Dark active. Tap to switch to Eclipse AMOLED."}"
                                    }
                                    .clickable { onToggleTheme() }
                                    .padding(horizontal = 16.dp, vertical = 10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clip(CircleShape)
                                        .background(if (isEclipseTheme) Color.Black else Color(0xFF262626)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Palette,
                                        contentDescription = null,
                                        tint = NetflixRed,
                                        modifier = Modifier.size(22.dp)
                                    )
                                }

                                Spacer(modifier = Modifier.width(16.dp))

                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = "Hawkins Dark Theme",
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color.White
                                    )
                                    Text(
                                        text = if (isEclipseTheme) "Eclipse AMOLED (#000000) • Active" else "Base Dark (#141414) • Active",
                                        fontSize = 12.sp,
                                        color = hawkinsColors.foregroundSecondary
                                    )
                                }

                                Text(
                                    text = if (isEclipseTheme) "ECLIPSE" else "BASE",
                                    color = NetflixRed,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            HawkinsDivider(modifier = Modifier.padding(horizontal = 16.dp))
                        }
                    }

                    // My List Carousel (STRICT 2:3 Aspect Ratio)
                    item {
                        Text(
                            text = "My List",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 16.dp, top = 24.dp, bottom = 10.dp)
                        )

                        LazyRow(
                            contentPadding = PaddingValues(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            items(myListItems) { item ->
                                MovieCard(item = item, onClick = { onNavigateToDetails(item.id) })
                            }
                        }
                    }

                    // Liked Titles Carousel (STRICT 2:3 Aspect Ratio)
                    item {
                        Text(
                            text = "Titles You've Liked",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 16.dp, top = 24.dp, bottom = 10.dp)
                        )

                        LazyRow(
                            contentPadding = PaddingValues(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            items(likedItems) { item ->
                                MovieCard(item = item, onClick = { onNavigateToDetails(item.id) })
                            }
                        }
                        Spacer(modifier = Modifier.height(36.dp))
                    }
                }
            }
        }
    }

    // Optional Empty Downloads Dialog for realistic state exploration
    if (showEmptyDownloadsDialog) {
        AlertDialog(
            onDismissRequest = { showEmptyDownloadsDialog = false },
            containerColor = hawkinsColors.surface,
            title = {
                Text(text = "Downloads", fontWeight = FontWeight.Bold, color = Color.White)
            },
            text = {
                Text(
                    text = "Movies and TV shows that you download appear here so you can watch offline anytime without Wi-Fi.",
                    color = hawkinsColors.foregroundSecondary,
                    lineHeight = 20.sp
                )
            },
            confirmButton = {
                TextButton(onClick = { showEmptyDownloadsDialog = false }) {
                    Text("OK", color = NetflixRed, fontWeight = FontWeight.Bold)
                }
            }
        )
    }
}

/**
 * Dedicated shimmer skeleton layout for My Netflix Screen.
 */
@Composable
fun MyNetflixShimmer(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Spacer(modifier = Modifier.height(16.dp))
            ShimmerBox(modifier = Modifier.size(96.dp), shape = CircleShape)
            Spacer(modifier = Modifier.height(12.dp))
            ShimmerBox(modifier = Modifier.size(100.dp, 20.dp))
            Spacer(modifier = Modifier.height(28.dp))
        }
        items(2) {
            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(vertical = 4.dp)
            )
        }
        item {
            Spacer(modifier = Modifier.height(24.dp))
            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .height(20.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                items(3) {
                    ShimmerBox(
                        modifier = Modifier
                            .width(120.dp)
                            .aspectRatio(2f / 3f)
                            .clip(RoundedCornerShape(6.dp))
                    )
                }
            }
        }
    }
}

