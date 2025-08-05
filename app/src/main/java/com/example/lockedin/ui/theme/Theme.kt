package com.example.lockedin.ui.theme

import android.app.Activity
import android.graphics.Color
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val AppSingleTheme = darkColorScheme(
    primary = Purple80,
    secondary = Magnolia,
    tertiary = Pink80,
    background = PurpleBackground
)


@Composable
fun LockedInTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = AppSingleTheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Color.TRANSPARENT // Or any color you prefer
            window.navigationBarColor = Color.TRANSPARENT

            // Set this based on your single theme's nature
            // If AppSingleColorScheme is light, then isAppearanceLightStatusBars should be true.
            // If your single theme was dark, it would be false.
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = false
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}