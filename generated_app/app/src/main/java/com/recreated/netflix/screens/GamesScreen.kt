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
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.recreated.netflix.components.*
import com.recreated.netflix.theme.LocalHawkinsColors
import com.recreated.netflix.theme.NetflixRed

data class GameItem(
    val id: String,
    val title: String,
    val genre: String,
    val tag: String = "No Ads • No In-App Purchases",
    val imageUrl: String? = null
)

@Composable
fun GamesScreen(
    onNavigateToGameDetail: (String) -> Unit,
    modifier: Modifier = Modifier,
    bottomNavPadding: androidx.compose.ui.unit.Dp = 0.dp,
    initialLoadingState: ScreenLoadingState = ScreenLoadingState.Content
) {
    val hawkinsColors = LocalHawkinsColors.current
    var screenState by remember { mutableStateOf(initialLoadingState) }
    var selectedCategory by remember { mutableStateOf("All Games") }

    val categories = listOf("All Games", "Action", "Adventure", "Arcade", "Puzzle", "Strategy")

    val allGames = listOf(
        GameItem("g1", "Stranger Things 3: The Game", "Action / Adventure"),
        GameItem("g2", "Grand Theft Auto: San Andreas", "Action"),
        GameItem("g3", "Hades", "Action"),
        GameItem("g4", "Dead Cells: Netflix Edition", "Action"),
        GameItem("g5", "Football Manager 2024", "Strategy"),
        GameItem("g6", "Bloons TD 6", "Strategy"),
        GameItem("g7", "Cut the Rope Daily", "Puzzle"),
        GameItem("g8", "Exploding Kittens", "Arcade"),
        GameItem("g9", "Storyteller", "Puzzle")
    )

    val filteredGames = remember(selectedCategory) {
        if (selectedCategory == "All Games") allGames
        else allGames.filter { it.genre.contains(selectedCategory, ignoreCase = true) }
    }

    val trendingGames = filteredGames.take(5)
    val pickUpAndPlayGames = filteredGames.drop(2)

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
                        text = "Games",
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
                            contentDescription = "Search Games",
                            tint = Color.White
                        )
                    }
                }

                // Category Chips Row
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(categories) { cat ->
                        HawkinsChip(
                            text = cat,
                            selected = selectedCategory == cat,
                            onClick = { selectedCategory = cat },
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
                GamesScreenShimmer(
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
                    title = "No Games Found",
                    message = "We don't have games matching '$selectedCategory' yet.",
                    icon = Icons.Default.SportsEsports,
                    actionLabel = "View All Games",
                    onAction = {
                        selectedCategory = "All Games"
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
                    title = "Couldn't load Games",
                    message = "Check your connection and retry loading Netflix Games.",
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
                if (filteredGames.isEmpty()) {
                    EmptyStateView(
                        title = "No Games in this Category",
                        message = "Try selecting another category to see available mobile games.",
                        icon = Icons.Default.SportsEsports,
                        actionLabel = "View All Games",
                        onAction = { selectedCategory = "All Games" },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                top = innerPadding.calculateTopPadding(),
                                bottom = bottomNavPadding
                            )
                    )
                } else {
                    LazyColumn(
                        contentPadding = PaddingValues(
                            top = innerPadding.calculateTopPadding(),
                            bottom = bottomNavPadding + 16.dp
                        ),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        // Hero Game Banner
                        item {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(310.dp)
                                    .background(Color(0xFF1B1B1B))
                            ) {
                                ProceduralPosterArtwork(
                                    title = "Grand Theft Auto",
                                    seed = 777,
                                    isLandscape = true,
                                    showTitle = false,
                                    modifier = Modifier.fillMaxSize()
                                )

                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(
                                            Brush.verticalGradient(
                                                colors = listOf(
                                                    Color.Transparent,
                                                    hawkinsColors.background.copy(alpha = 0.5f),
                                                    hawkinsColors.background
                                                )
                                            )
                                        )
                                )

                                Column(
                                    modifier = Modifier
                                        .align(Alignment.BottomStart)
                                        .padding(16.dp)
                                ) {
                                    Text(
                                        text = "EXCLUSIVE ON NETFLIX",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = NetflixRed,
                                        letterSpacing = 1.sp
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "Grand Theft Auto: The Trilogy",
                                        fontSize = 22.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = "Play the genre-defining classics, updated for mobile with no ads.",
                                        fontSize = 13.sp,
                                        color = hawkinsColors.foregroundSecondary
                                    )
                                    Spacer(modifier = Modifier.height(14.dp))
                                    HawkinsButton(
                                        text = "Get Game",
                                        onClick = { onNavigateToGameDetail("g2") },
                                        type = HawkinsButtonType.Primary,
                                        leadingIcon = Icons.Default.Download,
                                        modifier = Modifier.defaultMinSize(minHeight = 48.dp)
                                    )
                                }
                            }
                        }

                        // Featured Games Carousel
                        item {
                            Text(
                                text = "Trending Games",
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 16.dp, top = 20.dp, bottom = 10.dp)
                            )

                            LazyRow(
                                contentPadding = PaddingValues(horizontal = 16.dp),
                                horizontalArrangement = Arrangement.spacedBy(14.dp)
                            ) {
                                items(trendingGames) { game ->
                                    GameCard(game = game, onClick = { onNavigateToGameDetail(game.id) })
                                }
                            }
                        }

                        // Casual & Puzzle Games
                        if (pickUpAndPlayGames.isNotEmpty()) {
                            item {
                                Text(
                                    text = "Pick Up and Play",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 16.dp, top = 24.dp, bottom = 10.dp)
                                )

                                LazyRow(
                                    contentPadding = PaddingValues(horizontal = 16.dp),
                                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                                ) {
                                    items(pickUpAndPlayGames) { game ->
                                        GameCard(game = game, onClick = { onNavigateToGameDetail(game.id) })
                                    }
                                }
                                Spacer(modifier = Modifier.height(32.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GameCard(
    game: GameItem,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .width(140.dp)
            .clickable { onClick() }
            .semantics(mergeDescendants = true) {
                contentDescription = "${game.title}, Genre: ${game.genre}. ${game.tag}."
            }
    ) {
        Box(
            modifier = Modifier
                .size(140.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFF262626))
        ) {
            CinematicAsyncImage(
                imageUrl = game.imageUrl,
                contentDescription = null,
                titleFallback = game.title,
                seedFallback = game.title.hashCode() + 11,
                aspectRatio = 1.0f,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = game.title,
            color = Color.White,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.SemiBold,
            maxLines = 1
        )

        Text(
            text = game.genre,
            color = Color(0xFFB3B3B3),
            fontSize = 11.sp,
            maxLines = 1
        )

        Text(
            text = game.tag,
            color = Color(0xFFA8A8A8),
            fontSize = 9.sp,
            maxLines = 1
        )
    }
}

/**
 * Dedicated shimmer skeleton layout for the Games Screen.
 */
@Composable
fun GamesScreenShimmer(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        item {
            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp),
                shape = RoundedCornerShape(0.dp)
            )
        }
        items(2) {
            Column(modifier = Modifier.padding(vertical = 12.dp)) {
                ShimmerBox(
                    modifier = Modifier
                        .padding(start = 16.dp, bottom = 12.dp)
                        .width(140.dp)
                        .height(20.dp)
                )

                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(4) {
                        ShimmerBox(
                            modifier = Modifier
                                .size(140.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )
                    }
                }
            }
        }
    }
}

