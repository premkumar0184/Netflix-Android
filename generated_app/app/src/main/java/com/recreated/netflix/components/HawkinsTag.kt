package com.recreated.netflix.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.recreated.netflix.theme.NetflixRed

@Composable
fun HawkinsTag(
    text: String,
    modifier: Modifier = Modifier,
    isTop10: Boolean = false
) {
    val bgColor = if (isTop10) NetflixRed else Color.White.copy(alpha = 0.15f)
    val textColor = Color.White

    Text(
        text = text.uppercase(),
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold,
        color = textColor,
        modifier = modifier
            .background(bgColor, RoundedCornerShape(2.dp))
            .padding(horizontal = 6.dp, vertical = 2.dp)
    )
}
