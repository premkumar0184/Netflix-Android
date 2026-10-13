package com.recreated.netflix.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SearchOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.recreated.netflix.components.*
import com.recreated.netflix.theme.LocalHawkinsColors

@Composable
fun SearchScreen(
    onNavigateToDetails: (String) -> Unit,
    onCloseClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    initialLoadingState: ScreenLoadingState = ScreenLoadingState.Content
) {
    val hawkinsColors = LocalHawkinsColors.current
    var screenState by remember { mutableStateOf(initialLoadingState) }
    var query by remember { mutableStateOf("") }

    val allCatalogItems = remember { NetflixMediaCatalog.values.toList() }
    val topSearches = remember { (1..10).mapNotNull { NetflixMediaCatalog[it.toString()] } }
    val popularSuggestions = listOf("Stranger Things", "Squid Game", "Arcane", "Sci-Fi", "Action", "Thriller")

    val searchResults = remember(query) {
        if (query.isBlank()) emptyList()
        else allCatalogItems.filter {
            it.title.contains(query, ignoreCase = true) ||
            it.genres.any { g -> g.contains(query, ignoreCase = true) }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(hawkinsColors.background)
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        // Search Input Bar with 48dp Touch Targets
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (onCloseClick != null) {
                IconButton(
                    onClick = onCloseClick,
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            }
            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                placeholder = {
                    Text(
                        text = "Search movies, shows, genres...",
                        color = hawkinsColors.foregroundSecondary,
                        fontSize = 14.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = hawkinsColors.foregroundSecondary
                    )
                },
                trailingIcon = {
                    if (query.isNotEmpty()) {
                        IconButton(
                            onClick = { query = "" },
                            modifier = Modifier.size(48.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Clear search text",
                                tint = Color.White
                            )
                        }
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = hawkinsColors.surfaceSecondary,
                    unfocusedContainerColor = hawkinsColors.surfaceSecondary,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                ),
                shape = RoundedCornerShape(6.dp),
                singleLine = true
            )
        }

        when (screenState) {
            ScreenLoadingState.Loading -> {
                SearchShimmerGrid()
            }
            ScreenLoadingState.Error -> {
                ErrorStateView(
                    title = "Search Error",
                    message = "Could not execute search. Check your connection.",
                    onRetry = { screenState = ScreenLoadingState.Content }
                )
            }
            ScreenLoadingState.Empty -> {
                EmptyStateView(
                    title = "Search is Empty",
                    message = "Type a title, actor, or genre into the search bar above.",
                    icon = Icons.Default.SearchOff,
                    actionLabel = "Clear Search",
                    onAction = {
                        query = ""
                        screenState = ScreenLoadingState.Content
                    }
                )
            }
            ScreenLoadingState.Content -> {
                if (query.isBlank()) {
                    // Prequery / Top Searches
                    Text(
                        text = "Top Searches",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
                    )

                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(topSearches) { item ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { onNavigateToDetails(item.id) }
                                    .semantics(mergeDescendants = true) {
                                        contentDescription = "${item.title}. Tap to view details."
                                    }
                                    .padding(horizontal = 16.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .aspectRatio(16f / 9f) // STRICT 16:9 Landscape Aspect Ratio
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(Color(0xFF262626))
                                ) {
                                    ProceduralPosterArtwork(
                                        title = item.title,
                                        seed = item.title.hashCode(),
                                        isLandscape = true,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                }

                                Spacer(modifier = Modifier.width(16.dp))

                                Text(
                                    text = item.title,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier.weight(1f)
                                )

                                IconButton(
                                    onClick = { onNavigateToDetails(item.id) },
                                    modifier = Modifier.size(48.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.PlayCircleOutline,
                                        contentDescription = "Play ${item.title}",
                                        tint = Color.White,
                                        modifier = Modifier.size(28.dp)
                                    )
                                }
                            }
                        }
                    }
                } else if (searchResults.isEmpty()) {
                    // Intuitive Empty Search State with Suggestion Chips
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 24.dp, vertical = 32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .size(64.dp)
                                .clip(RoundedCornerShape(32.dp))
                                .background(Color.White.copy(alpha = 0.08f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.SearchOff,
                                contentDescription = null,
                                tint = Color.LightGray,
                                modifier = Modifier.size(32.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Oh no! We couldn't find matches for \"$query\"",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Try searching for another movie, TV show, actor, or genre.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = hawkinsColors.foregroundSecondary
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        Text(
                            text = "Popular Searches:",
                            style = MaterialTheme.typography.labelMedium,
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(popularSuggestions) { sug ->
                                HawkinsChip(
                                    text = sug,
                                    onClick = { query = sug },
                                    size = HawkinsChipSize.Small
                                )
                            }
                        }
                    }
                } else {
                    // Search Results Grid enforcing STRICT 2:3 Portrait Poster Aspect Ratio
                    Text(
                        text = "Movies & TV",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(3),
                        contentPadding = PaddingValues(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(searchResults) { item ->
                            MovieCard(
                                item = item,
                                onClick = { onNavigateToDetails(item.id) },
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            }
        }
    }
}

/**
 * Shimmer skeleton grid for search results loading state.
 */
@Composable
fun SearchShimmerGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(9) {
            ShimmerBox(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2f / 3f)
                    .clip(RoundedCornerShape(6.dp))
            )
        }
    }
}

