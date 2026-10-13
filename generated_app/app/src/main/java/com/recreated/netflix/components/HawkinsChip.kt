package com.recreated.netflix.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.recreated.netflix.theme.LocalHawkinsColors

/**
 * Real Hawkins Chip Types decompiled from:
 * com.netflix.hawkins.consumer.component.chip.HawkinsChipType
 */
enum class HawkinsChipType {
    Border,
    Borderless
}

/**
 * Real Hawkins Chip Sizes decompiled from:
 * com.netflix.hawkins.consumer.component.chip.HawkinsChipSize
 */
enum class HawkinsChipSize(val height: Dp, val horizontalPadding: Dp, val fontSize: Int) {
    Small(height = 28.dp, horizontalPadding = 10.dp, fontSize = 12),
    Standard(height = 36.dp, horizontalPadding = 14.dp, fontSize = 14)
}

@Composable
fun HawkinsChip(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    type: HawkinsChipType = HawkinsChipType.Border,
    size: HawkinsChipSize = HawkinsChipSize.Standard,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null
) {
    val hawkinsColors = LocalHawkinsColors.current

    val backgroundColor = when {
        selected -> Color.White
        type == HawkinsChipType.Borderless -> Color.Transparent
        else -> Color.Black.copy(alpha = 0.6f)
    }

    val contentColor = when {
        selected -> Color.Black
        else -> Color.White
    }

    val border = when {
        selected || type == HawkinsChipType.Borderless -> null
        else -> BorderStroke(1.dp, Color.White.copy(alpha = 0.35f))
    }

    Box(
        modifier = modifier
            .defaultMinSize(minWidth = 48.dp, minHeight = 48.dp)
            .semantics(mergeDescendants = true) {
                role = Role.Checkbox
                this.selected = selected
                contentDescription = "$text filter chip, ${if (selected) "Selected" else "Not selected"}"
            }
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Surface(
            onClick = onClick,
            modifier = Modifier
                .height(size.height)
                .clip(RoundedCornerShape(999.dp)),
            shape = RoundedCornerShape(999.dp),
            color = backgroundColor,
            contentColor = contentColor,
            border = border
        ) {
            Row(
                modifier = Modifier.padding(horizontal = size.horizontalPadding),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                if (leadingIcon != null) {
                    Icon(
                        imageVector = leadingIcon,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = contentColor
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                }

                Text(
                    text = text,
                    fontSize = size.fontSize.sp,
                    style = MaterialTheme.typography.labelMedium,
                    color = contentColor
                )

                if (trailingIcon != null) {
                    Spacer(modifier = Modifier.width(6.dp))
                    Icon(
                        imageVector = trailingIcon,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = contentColor
                    )
                }
            }
        }
    }
}
