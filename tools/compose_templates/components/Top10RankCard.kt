package com.recreated.netflix.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Top 10 Rank Card with authentic Netflix typography and strict 2:3 portrait poster aspect ratio.
 */
@Composable
fun Top10RankCard(
    rank: Int,
    item: MediaItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clickable { onClick() }
            .semantics(mergeDescendants = true) {
                contentDescription = "Rank $rank: ${item.title}, Tap to view details."
            },
        verticalAlignment = Alignment.Bottom
    ) {
        // Large Top 10 Rank Numeral (Netflix Typography Style with 3D drop shadow)
        Text(
            text = "$rank",
            fontSize = 110.sp,
            fontWeight = FontWeight.Black,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 110.sp,
            color = Color(0xFF595959),
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Black,
                    blurRadius = 12f
                )
            ),
            modifier = Modifier
                .offset(x = 14.dp, y = 6.dp)
        )

        // Poster Card with STRICT 2:3 portrait aspect ratio
        Box(
            modifier = Modifier
                .width(120.dp)
                .aspectRatio(2f / 3f) // STRICT 2:3 portrait poster aspect ratio
                .clip(RoundedCornerShape(6.dp))
                .border(BorderStroke(1.dp, Color.White.copy(alpha = 0.08f)), RoundedCornerShape(6.dp))
                .shadow(4.dp, RoundedCornerShape(6.dp))
        ) {
            CinematicAsyncImage(
                imageUrl = item.imageUrl,
                contentDescription = null,
                titleFallback = item.title,
                seedFallback = item.title.hashCode(),
                aspectRatio = 2f / 3f,
                modifier = Modifier.fillMaxSize()
            )

            HawkinsTag(
                text = "TOP 10",
                isTop10 = true,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(5.dp)
            )
        }
    }
}

