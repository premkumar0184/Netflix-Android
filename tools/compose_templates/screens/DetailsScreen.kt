package com.recreated.netflix.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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

@Composable
fun DetailsScreen(
    mediaId: String,
    onCloseClick: () -> Unit,
    onPlayClick: ((String) -> Unit)? = null,
    onNavigateToDetails: ((String) -> Unit)? = null,
    modifier: Modifier = Modifier,
    initialLoadingState: ScreenLoadingState = ScreenLoadingState.Content
) {
    val hawkinsColors = LocalHawkinsColors.current
    var screenState by remember { mutableStateOf(initialLoadingState) }
    var isMyListAdded by remember { mutableStateOf(false) }

    val mediaItem = remember(mediaId) { findMediaItemById(mediaId) }
    val moreLikeThis = remember(mediaId) {
        NetflixMediaCatalog.values.filter { it.id != mediaId }.take(6)
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets(0.dp),
        containerColor = hawkinsColors.background
    ) { _ ->
        when (screenState) {
            ScreenLoadingState.Loading -> {
                DetailsScreenShimmer(
                    onCloseClick = onCloseClick,
                    modifier = Modifier
                        .fillMaxSize()
                        .navigationBarsPadding()
                )
            }
            ScreenLoadingState.Empty -> {
                EmptyStateView(
                    title = "Title Unavailable",
                    message = "This title is not currently available in your region.",
                    actionLabel = "Back to Browse",
                    onAction = onCloseClick,
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding()
                        .navigationBarsPadding()
                )
            }
            ScreenLoadingState.Error -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    IconButton(
                        onClick = onCloseClick,
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .statusBarsPadding()
                            .padding(8.dp)
                            .size(48.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(Color.Black.copy(alpha = 0.65f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(imageVector = Icons.Default.Close, contentDescription = "Close details screen", tint = Color.White, modifier = Modifier.size(20.dp))
                        }
                    }
                    ErrorStateView(
                        title = "Couldn't load title details",
                        message = "Please check your network connection and try again.",
                        onRetry = { screenState = ScreenLoadingState.Content },
                        modifier = Modifier
                            .fillMaxSize()
                            .statusBarsPadding()
                            .navigationBarsPadding()
                    )
                }
            }
            ScreenLoadingState.Content -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .navigationBarsPadding()
                    ) {
                        // Header Backdrop with 16:9 Aspect Ratio
                        item {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(16f / 9f)
                                    .background(Color(0xFF181818))
                            ) {
                                CinematicAsyncImage(
                                    imageUrl = mediaItem.backdropUrl ?: mediaItem.imageUrl,
                                    contentDescription = "${mediaItem.title} trailer backdrop",
                                    titleFallback = mediaItem.title,
                                    seedFallback = mediaItem.title.hashCode() + 111,
                                    aspectRatio = 16f / 9f,
                                    contentScale = ContentScale.Crop,
                                    showTitleFallback = false,
                                    modifier = Modifier.fillMaxSize()
                                )

                                // Top gradient scrim
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(80.dp)
                                        .background(
                                            Brush.verticalGradient(
                                                colors = listOf(
                                                    Color.Black.copy(alpha = 0.8f),
                                                    Color.Transparent
                                                )
                                            )
                                        )
                                )

                                // Center Play Trailer Indicator
                                Box(
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(CircleShape)
                                        .background(Color.Black.copy(alpha = 0.6f))
                                        .align(Alignment.Center)
                                        .clickable { onPlayClick?.invoke(mediaItem.title) },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.PlayArrow,
                                        contentDescription = "Play Trailer",
                                        tint = Color.White,
                                        modifier = Modifier.size(36.dp)
                                    )
                                }
                            }
                        }

                    // Title and Metadata Details
                    item {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = mediaItem.title,
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White,
                                fontWeight = FontWeight.Black
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text(
                                    text = mediaItem.releaseYear,
                                    color = hawkinsColors.foregroundSecondary,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium
                                )
                                HawkinsTag(text = mediaItem.maturityRating)
                                Text(
                                    text = mediaItem.durationOrSeasons,
                                    color = hawkinsColors.foregroundSecondary,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium
                                )
                                HawkinsTag(text = "Vision")
                                HawkinsTag(text = "Atmos")
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            // Play Button (48dp minimum touch target)
                            HawkinsButton(
                                text = "Play",
                                onClick = { onPlayClick?.invoke(mediaItem.title) },
                                type = HawkinsButtonType.Primary,
                                leadingIcon = Icons.Default.PlayArrow,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .defaultMinSize(minHeight = 48.dp)
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            // Download Button (48dp minimum touch target)
                            HawkinsButton(
                                text = if (mediaItem.durationOrSeasons.contains("Season")) "Download S1:E1" else "Download Movie",
                                onClick = {},
                                type = HawkinsButtonType.Secondary,
                                leadingIcon = Icons.Default.Download,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .defaultMinSize(minHeight = 48.dp)
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            Text(
                                text = mediaItem.synopsis,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.White.copy(alpha = 0.95f),
                                lineHeight = 22.sp
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            Text(
                                text = "Starring: ${mediaItem.starring}",
                                style = MaterialTheme.typography.bodySmall,
                                color = hawkinsColors.foregroundSecondary
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "Genres: ${mediaItem.genres.joinToString(", ")}",
                                style = MaterialTheme.typography.bodySmall,
                                color = hawkinsColors.foregroundSecondary
                            )

                            Spacer(modifier = Modifier.height(24.dp))

                            // Action Row: My List, Rate, Share with 48dp Minimum Touch Targets
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier
                                        .defaultMinSize(minWidth = 48.dp, minHeight = 48.dp)
                                        .semantics(mergeDescendants = true) {
                                            role = Role.Checkbox
                                            this.selected = isMyListAdded
                                            contentDescription = if (isMyListAdded) "In My List. Tap to remove ${mediaItem.title}" else "Add ${mediaItem.title} to My List"
                                        }
                                        .clickable { isMyListAdded = !isMyListAdded }
                                        .padding(horizontal = 12.dp, vertical = 6.dp)
                                ) {
                                    Icon(
                                        imageVector = if (isMyListAdded) Icons.Default.Check else Icons.Default.Add,
                                        contentDescription = null,
                                        tint = Color.White,
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "My List",
                                        color = hawkinsColors.foregroundSecondary,
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                }

                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier
                                        .defaultMinSize(minWidth = 48.dp, minHeight = 48.dp)
                                        .semantics(mergeDescendants = true) {
                                            role = Role.Button
                                            contentDescription = "Rate ${mediaItem.title}"
                                        }
                                        .clickable {}
                                        .padding(horizontal = 12.dp, vertical = 6.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.ThumbUp,
                                        contentDescription = null,
                                        tint = Color.White,
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "Rate",
                                        color = hawkinsColors.foregroundSecondary,
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                }

                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier
                                        .defaultMinSize(minWidth = 48.dp, minHeight = 48.dp)
                                        .semantics(mergeDescendants = true) {
                                            role = Role.Button
                                            contentDescription = "Share ${mediaItem.title}"
                                        }
                                        .clickable {}
                                        .padding(horizontal = 12.dp, vertical = 6.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Share,
                                        contentDescription = null,
                                        tint = Color.White,
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "Share",
                                        color = hawkinsColors.foregroundSecondary,
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                }
                            }
                        }
                    }

                    // Divider & "More Like This" (STRICT 2:3 Aspect Ratio)
                    item {
                        HawkinsDivider(modifier = Modifier.padding(horizontal = 16.dp))
                        Text(
                            text = "More Like This",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(16.dp)
                        )
                    }

                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            moreLikeThis.take(3).forEach { item ->
                                Box(modifier = Modifier.weight(1f)) {
                                    MovieCard(
                                        item = item,
                                        onClick = { onNavigateToDetails?.invoke(item.id) },
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            moreLikeThis.drop(3).take(3).forEach { item ->
                                Box(modifier = Modifier.weight(1f)) {
                                    MovieCard(
                                        item = item,
                                        onClick = { onNavigateToDetails?.invoke(item.id) },
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(36.dp))
                    }
                }

                // Pinned High-Contrast Close Button Overlay (48dp Touch Target)
                IconButton(
                    onClick = onCloseClick,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .statusBarsPadding()
                        .padding(8.dp)
                        .size(48.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(Color.Black.copy(alpha = 0.65f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close details screen",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}
}

/**
 * Dedicated shimmer skeleton layout for Details Screen.
 */
@Composable
fun DetailsScreenShimmer(
    onCloseClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9f)
                ) {
                    ShimmerBox(modifier = Modifier.fillMaxSize())
                }
                Column(modifier = Modifier.padding(16.dp)) {
                    ShimmerBox(modifier = Modifier.fillMaxWidth(0.6f).height(28.dp))
                    Spacer(modifier = Modifier.height(12.dp))
                    ShimmerBox(modifier = Modifier.fillMaxWidth(0.4f).height(16.dp))
                    Spacer(modifier = Modifier.height(16.dp))
                    ShimmerBox(modifier = Modifier.fillMaxWidth().height(48.dp))
                    Spacer(modifier = Modifier.height(8.dp))
                    ShimmerBox(modifier = Modifier.fillMaxWidth().height(48.dp))
                    Spacer(modifier = Modifier.height(16.dp))
                    ShimmerBox(modifier = Modifier.fillMaxWidth().height(16.dp))
                    Spacer(modifier = Modifier.height(6.dp))
                    ShimmerBox(modifier = Modifier.fillMaxWidth(0.9f).height(16.dp))
                }
            }
        }

        // Pinned High-Contrast Close Button Overlay in Shimmer state
        IconButton(
            onClick = onCloseClick,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .statusBarsPadding()
                .padding(8.dp)
                .size(48.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(Color.Black.copy(alpha = 0.65f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close details screen",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

