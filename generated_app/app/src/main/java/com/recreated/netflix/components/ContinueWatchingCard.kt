package com.recreated.netflix.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.recreated.netflix.theme.LocalHawkinsColors
import com.recreated.netflix.theme.NetflixRed

/**
 * Netflix Continue Watching Card enforcing strict 16:9 landscape aspect ratio.
 */
@Composable
fun ContinueWatchingCard(
    item: MediaItem,
    progress: Float, // 0.0f to 1.0f
    episodeLabel: String,
    onPlayClick: () -> Unit,
    onInfoClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val hawkinsColors = LocalHawkinsColors.current

    Column(
        modifier = modifier
            .width(220.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(hawkinsColors.surfaceCard)
            .border(BorderStroke(1.dp, Color.White.copy(alpha = 0.08f)), RoundedCornerShape(6.dp))
            .shadow(4.dp, RoundedCornerShape(6.dp))
    ) {
        // Thumbnail Box enforcing STRICT 16:9 landscape aspect ratio
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f) // STRICT 16:9 Landscape Aspect Ratio
                .clip(RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp))
                .clickable { onPlayClick() }
                .semantics(mergeDescendants = true) {
                    contentDescription = "Resume playing ${item.title}, $episodeLabel"
                }
        ) {
            CinematicAsyncImage(
                imageUrl = item.backdropUrl ?: item.imageUrl,
                contentDescription = null,
                titleFallback = item.title,
                seedFallback = item.title.hashCode() + 99,
                aspectRatio = 16f / 9f,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // Central Play Circle with 48dp minimum touch target
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Color.Black.copy(alpha = 0.65f))
                    .border(BorderStroke(1.5.dp, Color.White), CircleShape)
                    .align(Alignment.Center),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Play",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
            }

            // Episode Tag Badge (e.g. S1:E3)
            Surface(
                color = Color.Black.copy(alpha = 0.75f),
                shape = RoundedCornerShape(3.dp),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(8.dp)
            ) {
                Text(
                    text = episodeLabel,
                    color = Color.White,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                )
            }

            // Authentic Netflix Red Progress Indicator Bar
            LinearProgressIndicator(
                progress = { progress.coerceIn(0f, 1f) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(3.5.dp)
                    .align(Alignment.BottomCenter),
                color = NetflixRed,
                trackColor = Color.White.copy(alpha = 0.25f)
            )
        }

        // Action and Info Row with 48dp Touch Targets
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 2.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 4.dp)
            ) {
                Text(
                    text = item.title,
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = episodeLabel,
                    color = hawkinsColors.foregroundSecondary,
                    fontSize = 11.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            IconButton(
                onClick = onInfoClick,
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Info for ${item.title}",
                    tint = hawkinsColors.foregroundSecondary,
                    modifier = Modifier.size(20.dp)
                )
            }

            IconButton(
                onClick = {},
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Options for ${item.title}",
                    tint = hawkinsColors.foregroundSecondary,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

