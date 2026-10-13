package com.recreated.netflix.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.*

/**
 * Renders an extracted Netflix micro-animation asset from assets/lottie/
 */
@Composable
fun NetflixLottieAnimation(
    assetName: String,
    modifier: Modifier = Modifier,
    isPlaying: Boolean = true,
    iterations: Int = LottieConstants.IterateForever,
    speed: Float = 1.0f
) {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.Asset("lottie/$assetName")
    )

    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = isPlaying,
        iterations = iterations,
        speed = speed
    )

    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = modifier
    )
}
