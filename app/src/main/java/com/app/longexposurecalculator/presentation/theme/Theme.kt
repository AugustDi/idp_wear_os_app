package com.app.longexposurecalculator.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.wear.compose.material.Colors
import androidx.wear.compose.material.LocalContentColor
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Typography

private val colorScheme = Colors(
    primary =  Color(0xFFAECBFA),
    primaryVariant = Color(0xFF8AB4FA),
    secondary = Color(0xFFFDE293),
    secondaryVariant = Color(0xFFFDD663),
    background = Color(0xFF000000),
    surface = Color(0xFF303133),
    error = Color(0xFFEE675C),
    onPrimary = Color(0xFFDBDCE0),
    onSecondary = Color(0xFFDBDCE0),
    onBackground = Color(0xFFDBDCE0),
    onSurface = Color(0xFFDBDCE0),
    onError = Color(0xFFDBDCE0)
)

@Composable
fun LongExposureCalculatorTheme(
    content: @Composable () -> Unit
) {
    /**
     * Empty theme to customize for your app.
     * See: https://developer.android.com/jetpack/compose/designsystems/custom
     */

    MaterialTheme(
        colors = colorScheme,
        content = content
    )
}