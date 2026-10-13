package com.recreated.netflix.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.recreated.netflix.theme.LocalHawkinsColors
import com.recreated.netflix.theme.NetflixRed

enum class HawkinsButtonType {
    Primary,
    Secondary,
    Tertiary,
    Supplemental,
    Brand,
    Destructive
}

enum class HawkinsButtonSize(val iconSize: Dp, val height: Dp) {
    Small(iconSize = 16.dp, height = 32.dp),
    Standard(iconSize = 24.dp, height = 40.dp),
    Large(iconSize = 36.dp, height = 48.dp)
}

@Composable
fun HawkinsButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    type: HawkinsButtonType = HawkinsButtonType.Primary,
    size: HawkinsButtonSize = HawkinsButtonSize.Standard,
    leadingIcon: ImageVector? = null,
    enabled: Boolean = true
) {
    val hawkinsColors = LocalHawkinsColors.current

    val (containerColor, contentColor) = when (type) {
        HawkinsButtonType.Primary -> Color.White to Color.Black
        HawkinsButtonType.Secondary -> Color.White.copy(alpha = 0.2f) to Color.White
        HawkinsButtonType.Tertiary -> Color.Transparent to Color.White
        HawkinsButtonType.Supplemental -> hawkinsColors.surfaceSecondary to hawkinsColors.foregroundPrimary
        HawkinsButtonType.Brand -> NetflixRed to Color.White
        HawkinsButtonType.Destructive -> Color(0xFFCC0000) to Color.White
    }

    val horizontalPad = when (size) {
        HawkinsButtonSize.Small -> 8.dp
        HawkinsButtonSize.Standard -> 10.dp
        HawkinsButtonSize.Large -> 16.dp
    }

    Button(
        onClick = onClick,
        modifier = modifier
            .defaultMinSize(minWidth = 48.dp, minHeight = 48.dp)
            .heightIn(min = size.height),
        enabled = enabled,
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = containerColor.copy(alpha = 0.4f),
            disabledContentColor = contentColor.copy(alpha = 0.4f)
        ),
        contentPadding = PaddingValues(horizontal = horizontalPad, vertical = 0.dp)
    ) {
        if (leadingIcon != null) {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null,
                modifier = Modifier.size(size.iconSize)
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
