package com.recreated.netflix.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.recreated.netflix.theme.LocalHawkinsColors

/**
 * Real Hawkins Divider Emphasis decompiled from:
 * com.netflix.hawkins.consumer.component.divider.HawkinsDividerEmphasis
 */
enum class HawkinsDividerEmphasis {
    High,
    Low
}

@Composable
fun HawkinsDivider(
    modifier: Modifier = Modifier,
    emphasis: HawkinsDividerEmphasis = HawkinsDividerEmphasis.Low,
    thickness: Dp = 1.dp
) {
    val hawkinsColors = LocalHawkinsColors.current
    val dividerColor = when (emphasis) {
        HawkinsDividerEmphasis.High -> Color(0xFF4D4D4D)
        HawkinsDividerEmphasis.Low -> hawkinsColors.divider
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(thickness)
            .background(dividerColor)
    )
}
