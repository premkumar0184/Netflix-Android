package com.recreated.netflix.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cast
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.recreated.netflix.components.*
import com.recreated.netflix.theme.LocalHawkinsColors
import com.recreated.netflix.theme.NetflixRed

@Composable
fun HomeScreen(
    onNavigateToDetails: (String) -> Unit,
    onSearchClick: () -> Unit = {},
    onPlayClick: (String) -> Unit = {},
    modifier: Modifier = Modifier,
    profileName: String = "Prem",
    bottomNavPadding: androidx.compose.ui.unit.Dp = 0.dp,
    initialLoadingState: ScreenLoadingState = ScreenLoadingState.Content
) {
    val hawkinsColors = LocalHawkinsColors.current
    var screenState by remember { mutableStateOf(initialLoadingState) }
    var isHeroSavedToMyList by remember { mutableStateOf(false) }

    // Curated rich media items from central catalog
    val continueWatchingItems = listOfNotNull(
        NetflixMediaCatalog["1"]?.copy(progress = 0.65f, episodeLabel = "S4:E1 Chapter One"),
        NetflixMediaCatalog["2"]?.copy(progress = 0.30f, episodeLabel = "S1:E3 The Man with the Umbrella"),
        NetflixMediaCatalog["3"]?.copy(progress = 0.85f, episodeLabel = "S1:E4 Woe What a Night")
    )

    val trendingItems = listOfNotNull(
        NetflixMediaCatalog["1"],
        NetflixMediaCatalog["2"],
        NetflixMediaCatalog["3"],
        NetflixMediaCatalog["4"],
        NetflixMediaCatalog["5"],
        NetflixMediaCatalog["6"],
        NetflixMediaCatalog["7"],
        NetflixMediaCatalog["8"]
    )

    val popularItems = listOfNotNull(
        NetflixMediaCatalog["6"],
        NetflixMediaCatalog["7"],
        NetflixMediaCatalog["8"],
        NetflixMediaCatalog["9"],
        NetflixMediaCatalog["10"],
        NetflixMediaCatalog["11"]
    )

    val animeAndSciFiItems = listOfNotNull(
        NetflixMediaCatalog["12"],
        NetflixMediaCatalog["13"],
        NetflixMediaCatalog["14"],
        NetflixMediaCatalog["15"]
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(hawkinsColors.background)
    ) {
        when (screenState) {
            ScreenLoadingState.Loading -> {
                HomeScreenShimmer(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = bottomNavPadding)
                )
            }
            ScreenLoadingState.Empty -> {
                EmptyStateView(
                    title = "Your Feed is Empty",
                    message = "Browse our library and add movies or shows to start seeing recommendations tailored for you.",
                    actionLabel = "Explore Trending",
                    onAction = { screenState = ScreenLoadingState.Content },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = bottomNavPadding)
                )
            }
            ScreenLoadingState.Error -> {
                ErrorStateView(
                    title = "Can't load Home feed",
                    message = "We couldn't connect to Netflix services. Please check your internet connection.",
                    onRetry = { screenState = ScreenLoadingState.Content },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = bottomNavPadding)
                )
            }
            ScreenLoadingState.Content -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(bottom = bottomNavPadding + 24.dp)
                ) {
                    // Billboard Hero Key Art (Full-Bleed at y=0)
                    item {
                        BillboardHero(
                            title = "Stranger Things",
                            categories = listOf("Sci-Fi", "Suspenseful", "Nostalgic", "80s"),
                            onPlayClick = { onPlayClick("Stranger Things") },
                            onMyListClick = { isHeroSavedToMyList = !isHeroSavedToMyList },
                            onInfoClick = { onNavigateToDetails("1") },
                            isSavedToMyList = isHeroSavedToMyList
                        )
                    }

                    // Continue Watching Rail (STRICT 16:9 Landscape Aspect Ratio)
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp)
                        ) {
                            Text(
                                text = "Continue Watching for $profileName",
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                            )

                            LazyRow(
                                contentPadding = PaddingValues(horizontal = 16.dp),
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                items(continueWatchingItems.size) { index ->
                                    val item = continueWatchingItems[index]
                                    ContinueWatchingCard(
                                        item = item,
                                        progress = item.progress ?: 0.5f,
                                        episodeLabel = item.episodeLabel ?: "Episode",
                                        onPlayClick = { onPlayClick(item.title) },
                                        onInfoClick = { onNavigateToDetails(item.id) }
                                    )
                                }
                            }
                        }
                    }

                    // Top 10 in TV Shows Today Rail (STRICT 2:3 Aspect Ratio + Overlapping Rank)
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp)
                        ) {
                            Text(
                                text = "Top 10 TV Shows Today",
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                            )

                            LazyRow(
                                contentPadding = PaddingValues(horizontal = 16.dp),
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                items(trendingItems.size) { index ->
                                    val item = trendingItems[index]
                                    Top10RankCard(
                                        rank = index + 1,
                                        item = item,
                                        onClick = { onNavigateToDetails(item.id) }
                                    )
                                }
                            }
                        }
                    }

                    // Trending Now Rail (STRICT 2:3 Aspect Ratio)
                    item {
                        LolomoRow(
                            rowTitle = "Trending Now",
                            items = popularItems,
                            onItemClick = { onNavigateToDetails(it.id) }
                        )
                    }

                    // Only on Netflix Sci-Fi & Anime Rail
                    item {
                        LolomoRow(
                            rowTitle = "Only on Netflix • Sci-Fi & Action",
                            items = animeAndSciFiItems,
                            onItemClick = { onNavigateToDetails(it.id) }
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.height(32.dp))
                    }
                }
            }
        }

        // Top Navigation Header Overlay with Gradient Scrim
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.85f),
                            Color.Black.copy(alpha = 0.4f),
                            Color.Transparent
                        )
                    )
                )
                .statusBarsPadding()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "N",
                color = NetflixRed,
                fontSize = 34.sp,
                fontWeight = FontWeight.Black
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
                onClick = onSearchClick,
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Catalog",
                    tint = Color.White
                )
            }
        }
    }
}

/**
 * Dedicated shimmer skeleton layout for the Home Screen during data loading.
 */
@Composable
fun HomeScreenShimmer(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        // Billboard shimmer
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(480.dp)
            ) {
                ShimmerBox(
                    modifier = Modifier.fillMaxSize(),
                    shape = RoundedCornerShape(0.dp)
                )
            }
        }

        // Shimmer rails
        items(3) {
            Column(modifier = Modifier.padding(vertical = 12.dp)) {
                ShimmerBox(
                    modifier = Modifier
                        .padding(start = 16.dp, bottom = 8.dp)
                        .width(160.dp)
                        .height(20.dp)
                )

                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(4) {
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
}

