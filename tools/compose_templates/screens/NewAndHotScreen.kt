package com.recreated.netflix.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cast
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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

data class UpcomingTitle(
    val id: String,
    val month: String,
    val day: String,
    val releaseDate: String,
    val title: String,
    val synopsis: String,
    val genres: List<String>,
    val maturityRating: String = "16+",
    val imageUrl: String? = null
)

@Composable
fun NewAndHotScreen(
    onNavigateToDetails: (String) -> Unit,
    modifier: Modifier = Modifier,
    bottomNavPadding: androidx.compose.ui.unit.Dp = 0.dp,
    initialLoadingState: ScreenLoadingState = ScreenLoadingState.Content
) {
    val hawkinsColors = LocalHawkinsColors.current
    var screenState by remember { mutableStateOf(initialLoadingState) }
    var selectedTab by remember { mutableStateOf("🍿 Coming Soon") }

    val filterTabs = listOf("🍿 Coming Soon", "🔥 Everyone's Watching", "🔟 Top 10 TV Shows", "🔟 Top 10 Movies")

    val upcomingItems = listOf(
        UpcomingTitle(
            id = "nh1",
            month = "NOV",
            day = "08",
            releaseDate = "Coming Friday, November 8",
            title = "Arcane: Season 2",
            synopsis = "Jinx and Vi face the consequences of their choices as war erupts between the utopian city of Piltover and the underground city of Zaun.",
            genres = listOf("Steampunk", "Action", "Cyberpunk", "Animation")
        ),
        UpcomingTitle(
            id = "nh2",
            month = "NOV",
            day = "15",
            releaseDate = "Coming November 15",
            title = "Cobra Kai: Season 6 Part 2",
            synopsis = "With the global Sekai Taikai tournament approaching, Daniel and Johnny work to rebuild their team amidst fierce international competition.",
            genres = listOf("Martial Arts", "Rivalry", "Action", "Comedy")
        ),
        UpcomingTitle(
            id = "nh3",
            month = "DEC",
            day = "26",
            releaseDate = "Coming December 26",
            title = "Squid Game: Season 2",
            synopsis = "Three years after winning Squid Game, Player 456 gave up going to the states and is back with a new resolution in his mind.",
            genres = listOf("Suspenseful", "Dystopian", "Psychological Thriller")
        )
    )

    Scaffold(
        modifier = modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets(0.dp),
        topBar = {
            Column(
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
            ) {
                // Top Header Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "New & Hot",
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
                }

                // Filter Tabs
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(filterTabs) { tab ->
                        HawkinsChip(
                            text = tab,
                            selected = selectedTab == tab,
                            onClick = { selectedTab = tab },
                            size = HawkinsChipSize.Small
                        )
                    }
                }
            }
        },
        containerColor = hawkinsColors.background
    ) { innerPadding ->
        when (screenState) {
            ScreenLoadingState.Loading -> {
                NewAndHotShimmer(
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
                    title = "Nothing Scheduled Yet",
                    message = "We don't have titles announced for this category yet. Check back soon!",
                    actionLabel = "View Coming Soon",
                    onAction = {
                        selectedTab = "🍿 Coming Soon"
                        screenState = ScreenLoadingState.Content
                    },
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
                    title = "Couldn't load release calendar",
                    message = "Please check your network and retry loading New & Hot.",
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
                        top = innerPadding.calculateTopPadding() + 8.dp,
                        bottom = bottomNavPadding + 16.dp
                    ),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(upcomingItems) { item ->
                        NewAndHotCard(item = item, onClick = { onNavigateToDetails(item.id) })
                        Spacer(modifier = Modifier.height(28.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun NewAndHotCard(
    item: UpcomingTitle,
    onClick: () -> Unit
) {
    var isReminderSet by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clickable { onClick() }
            .semantics {
                contentDescription = "${item.title}, releasing on ${item.releaseDate}"
            }
    ) {
        // Date Timeline Column
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(48.dp)
        ) {
            Text(
                text = item.month,
                color = Color(0xFFB3B3B3),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = item.day,
                color = Color.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Black
            )
        }

        Spacer(modifier = Modifier.width(14.dp))

        // Content Body
        Column(modifier = Modifier.weight(1f)) {
            // Video Thumbnail enforcing STRICT 16:9 Landscape Aspect Ratio
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f) // STRICT 16:9 Landscape Aspect Ratio
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF242424))
            ) {
                CinematicAsyncImage(
                    imageUrl = item.imageUrl,
                    contentDescription = null,
                    titleFallback = item.title,
                    seedFallback = item.title.hashCode() + 55,
                    aspectRatio = 16f / 9f,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Action Buttons Row (Remind Me & Share with 48dp Minimum Touch Targets)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )

                // Remind Me Button
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .defaultMinSize(minWidth = 48.dp, minHeight = 48.dp)
                        .semantics(mergeDescendants = true) {
                            role = Role.Checkbox
                            this.selected = isReminderSet
                            contentDescription = if (isReminderSet) "Reminder set for ${item.title}" else "Set reminder for ${item.title}"
                        }
                        .clickable { isReminderSet = !isReminderSet }
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Icon(
                        imageVector = if (isReminderSet) Icons.Default.Notifications else Icons.Default.NotificationsNone,
                        contentDescription = null,
                        tint = if (isReminderSet) NetflixRed else Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = if (isReminderSet) "Reminded" else "Remind Me",
                        fontSize = 10.sp,
                        color = if (isReminderSet) NetflixRed else Color(0xFFB3B3B3),
                        fontWeight = FontWeight.Medium
                    )
                }

                // Share Button
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .defaultMinSize(minWidth = 48.dp, minHeight = 48.dp)
                        .semantics(mergeDescendants = true) {
                            role = Role.Button
                            contentDescription = "Share ${item.title}"
                        }
                        .clickable {}
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "Share",
                        fontSize = 10.sp,
                        color = Color(0xFFB3B3B3),
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = item.releaseDate,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = item.synopsis,
                fontSize = 13.sp,
                color = Color(0xFFB3B3B3),
                lineHeight = 18.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Genres
            Text(
                text = item.genres.joinToString(" • "),
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White.copy(alpha = 0.9f)
            )
        }
    }
}

/**
 * Dedicated shimmer skeleton layout for New & Hot Screen.
 */
@Composable
fun NewAndHotShimmer(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.fillMaxSize().padding(16.dp)) {
        items(3) {
            Row(modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp)) {
                // Date shimmer
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(48.dp)) {
                    ShimmerBox(modifier = Modifier.size(36.dp, 16.dp))
                    Spacer(modifier = Modifier.height(4.dp))
                    ShimmerBox(modifier = Modifier.size(36.dp, 28.dp))
                }
                Spacer(modifier = Modifier.width(14.dp))
                // Body shimmer
                Column(modifier = Modifier.weight(1f)) {
                    ShimmerBox(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(16f / 9f)
                            .clip(RoundedCornerShape(8.dp))
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    ShimmerBox(modifier = Modifier.fillMaxWidth(0.6f).height(20.dp))
                    Spacer(modifier = Modifier.height(8.dp))
                    ShimmerBox(modifier = Modifier.fillMaxWidth().height(16.dp))
                    Spacer(modifier = Modifier.height(4.dp))
                    ShimmerBox(modifier = Modifier.fillMaxWidth(0.85f).height(16.dp))
                }
            }
        }
    }
}

