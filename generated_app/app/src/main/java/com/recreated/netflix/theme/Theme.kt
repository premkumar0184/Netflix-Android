package com.recreated.netflix.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class HawkinsColors(
    val background: Color,
    val surface: Color,
    val surfaceSecondary: Color,
    val surfaceCard: Color,
    val foregroundPrimary: Color,
    val foregroundSecondary: Color,
    val foregroundMuted: Color,
    val accent: Color,
    val accentGlow: Color,
    val divider: Color
)

val LocalHawkinsColors = staticCompositionLocalOf {
    HawkinsColors(
        background = HawkinsBaseBackground,
        surface = HawkinsBaseSurface,
        surfaceSecondary = HawkinsBaseSurfaceSecondary,
        surfaceCard = HawkinsBaseSurfaceCard,
        foregroundPrimary = HawkinsBaseForegroundPrimary,
        foregroundSecondary = HawkinsBaseForegroundSecondary,
        foregroundMuted = HawkinsBaseForegroundMuted,
        accent = NetflixRed,
        accentGlow = NetflixRedGlow,
        divider = HawkinsBaseDivider
    )
}

enum class HawkinsThemeVariant {
    Base,
    Eclipse
}

@Composable
fun NetflixAppTheme(
    variant: HawkinsThemeVariant = HawkinsThemeVariant.Base,
    content: @Composable () -> Unit
) {
    val hawkinsColors = when (variant) {
        HawkinsThemeVariant.Base -> HawkinsColors(
            background = HawkinsBaseBackground,
            surface = HawkinsBaseSurface,
            surfaceSecondary = HawkinsBaseSurfaceSecondary,
            surfaceCard = HawkinsBaseSurfaceCard,
            foregroundPrimary = HawkinsBaseForegroundPrimary,
            foregroundSecondary = HawkinsBaseForegroundSecondary,
            foregroundMuted = HawkinsBaseForegroundMuted,
            accent = NetflixRed,
            accentGlow = NetflixRedGlow,
            divider = HawkinsBaseDivider
        )
        HawkinsThemeVariant.Eclipse -> HawkinsColors(
            background = HawkinsEclipseBackground,
            surface = HawkinsEclipseSurface,
            surfaceSecondary = HawkinsEclipseSurfaceSecondary,
            surfaceCard = HawkinsEclipseSurfaceCard,
            foregroundPrimary = HawkinsEclipseForegroundPrimary,
            foregroundSecondary = HawkinsEclipseForegroundSecondary,
            foregroundMuted = HawkinsEclipseForegroundMuted,
            accent = NetflixRed,
            accentGlow = NetflixRedGlow,
            divider = HawkinsEclipseDivider
        )
    }

    val materialColors = darkColorScheme(
        primary = NetflixRed,
        onPrimary = Color.White,
        background = hawkinsColors.background,
        onBackground = hawkinsColors.foregroundPrimary,
        surface = hawkinsColors.surface,
        onSurface = hawkinsColors.foregroundPrimary,
        surfaceVariant = hawkinsColors.surfaceSecondary,
        onSurfaceVariant = hawkinsColors.foregroundSecondary,
        outline = hawkinsColors.divider
    )

    CompositionLocalProvider(LocalHawkinsColors provides hawkinsColors) {
        MaterialTheme(
            colorScheme = materialColors,
            typography = HawkinsTypography,
            content = content
        )
    }
}
