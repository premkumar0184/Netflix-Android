package com.recreated.netflix.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Real Hawkins Avatar Shapes decompiled from:
 * com.netflix.hawkins.consumer.component.avatar.HawkinsAvatarShape
 */
enum class HawkinsAvatarShape {
    Circle,
    Square
}

/**
 * Real Hawkins Avatar Sizes decompiled from:
 * com.netflix.hawkins.consumer.component.avatar.HawkinsAvatarSize
 */
enum class HawkinsAvatarSize(val sizeDp: Dp, val cornerRadiusDp: Dp) {
    ExtraSmall(sizeDp = 20.dp, cornerRadiusDp = 2.dp),
    Small(sizeDp = 28.dp, cornerRadiusDp = 4.dp),
    Medium(sizeDp = 36.dp, cornerRadiusDp = 4.dp),
    Large(sizeDp = 56.dp, cornerRadiusDp = 6.dp),
    ExtraLarge(sizeDp = 96.dp, cornerRadiusDp = 8.dp)
}

@Composable
fun HawkinsAvatar(
    name: String,
    modifier: Modifier = Modifier,
    avatarColor: Color = Color(0xFFE50914),
    shape: HawkinsAvatarShape = HawkinsAvatarShape.Square,
    size: HawkinsAvatarSize = HawkinsAvatarSize.Medium,
    showEditBadge: Boolean = false,
    onClick: (() -> Unit)? = null
) {
    val clipShape = when (shape) {
        HawkinsAvatarShape.Circle -> CircleShape
        HawkinsAvatarShape.Square -> RoundedCornerShape(size.cornerRadiusDp)
    }

    val avatarDescription = if (name.isNotBlank()) "Profile avatar for $name" else "Profile avatar"

    Box(
        modifier = modifier
            .defaultMinSize(minWidth = 48.dp, minHeight = 48.dp)
            .semantics(mergeDescendants = true) {
                contentDescription = avatarDescription
            }
            .then(if (onClick != null) Modifier.clickable { onClick() } else Modifier),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(size.sizeDp)
                .clip(clipShape)
                .background(avatarColor),
            contentAlignment = Alignment.Center
        ) {
            if (name.isNotBlank()) {
                Text(
                    text = name.take(1).uppercase(),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = (size.sizeDp.value * 0.45f).sp
                )
            } else {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(size.sizeDp * 0.6f)
                )
            }

            if (showEditBadge) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.55f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit Profile",
                        tint = Color.White,
                        modifier = Modifier.size(size.sizeDp * 0.35f)
                    )
                }
            }
        }
    }
}
