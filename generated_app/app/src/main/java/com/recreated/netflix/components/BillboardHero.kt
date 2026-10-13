package com.recreated.netflix.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
    modifier: Modifier = Modifier,
    imageUrl: String? = null,
    isTop10: Boolean = true,
    top10BadgeText: String = "Top 10 in TV Shows Today",
    isSavedToMyList: Boolean = false
) {
    val hawkinsColors = LocalHawkinsColors.current

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(530.dp)
            .background(hawkinsColors.background)
    ) {
        // Full-bleed key artwork background (Coil async image or procedural cinematic fallback)
        CinematicAsyncImage(
            imageUrl = imageUrl,
            contentDescription = "$title key artwork",
            titleFallback = title,
            seedFallback = title.hashCode() + 42,
            aspectRatio = 0.75f,
            contentScale = ContentScale.Crop,
            showTitleFallback = false,
            modifier = Modifier.fillMaxSize()
        )

        // Top Status Bar Gradient Scrim
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.85f),
                            Color.Black.copy(alpha = 0.4f),
                            Color.Transparent
                        )
                    )
                )
        )

        // Cinematic Side Edge Vignettes
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.4f),
                            Color.Transparent,
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.4f)
                        )
                    )
                )
        )

        // Dynamic Multi-Stop Bottom Vignette Gradient
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Transparent,
                            hawkinsColors.background.copy(alpha = 0.35f),
                            hawkinsColors.background.copy(alpha = 0.75f),
                            hawkinsColors.background.copy(alpha = 0.95f),
                            hawkinsColors.background
                        ),
                        startY = 180f
                    )
                )
        )

        // Billboard Foreground Information & CTA Action Buttons
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 14.dp, start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (isTop10) {
                HawkinsTag(text = top10BadgeText, isTop10 = true)
                Spacer(modifier = Modifier.height(10.dp))
            }

            Text(
                text = title,
                fontSize = 34.sp,
                fontWeight = FontWeight.Black,
                color = Color.White,
                textAlign = TextAlign.Center,
                lineHeight = 38.sp,
                style = TextStyle(
                    shadow = Shadow(color = Color.Black, blurRadius = 14f)
                ),
                modifier = Modifier.semantics {
                    this.contentDescription = "$title, Featured Title"
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = categories.joinToString(" • "),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = hawkinsColors.foregroundSecondary,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    shadow = Shadow(color = Color.Black, blurRadius = 6f)
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // CTA Button Row with Clear Visual Hierarchy & 48dp Minimum Touch Targets
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Secondary Button: My List
                HawkinsButton(
                    text = if (isSavedToMyList) "In List" else "My List",
                    onClick = onMyListClick,
                    type = HawkinsButtonType.Secondary,
                    leadingIcon = if (isSavedToMyList) Icons.Default.Check else Icons.Default.Add,
                    modifier = Modifier
                        .weight(1f)
                        .defaultMinSize(minHeight = 48.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                // Primary Prominent Button: Play
                HawkinsButton(
                    text = "Play",
                    onClick = onPlayClick,
                    type = HawkinsButtonType.Primary,
                    leadingIcon = Icons.Default.PlayArrow,
                    modifier = Modifier
                        .weight(1.3f)
                        .defaultMinSize(minHeight = 48.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                // Secondary Button: Info
                HawkinsButton(
                    text = "Info",
                    onClick = onInfoClick,
                    type = HawkinsButtonType.Secondary,
                    leadingIcon = Icons.Default.Info,
                    modifier = Modifier
                        .weight(1f)
                        .defaultMinSize(minHeight = 48.dp)
                )
            }
        }
    }
}

