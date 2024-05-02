package com.app.longexposurecalculator.presentation.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.MaterialTheme

@Composable
fun PrimaryButton(
    modifier: Modifier,
    image: ImageVector? = null,
    imageRes: Int? = null,
    imageTint: Color = Color.Unspecified,
    text: String? = null,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    AppButton(
        modifier = modifier,
        enabled = enabled,
        text = text,
        image = image,
        imageRes = imageRes,
        imageTint = imageTint,
        onClick = onClick
    )
}

@Composable
fun SecondaryButton(
    modifier: Modifier,
    image: ImageVector? = null,
    imageRes: Int? = null,
    imageTint: Color = Color.Unspecified,
    text: String? = null,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    AppButton(
        modifier = modifier,
        text = text,
        image = image,
        imageRes = imageRes,
        imageTint = imageTint,
        enabled = enabled,
        buttonColors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary,
            contentColor = MaterialTheme.colors.onSecondary
        ),
        onClick = onClick
    )
}

@Composable
fun PrimaryButtonWithValue(
    modifier: Modifier,
    image: ImageVector? = null,
    imageRes: Int? = null,
    imageTint: Color = Color.Unspecified,
    text: String? = null,
    value: String? = null,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    AppButtonWithValue(
        modifier = modifier,
        enabled = enabled,
        text = text,
        image = image,
        imageRes = imageRes,
        imageTint = imageTint,
        value = value,
        onClick = onClick
    )
}

@Composable
fun SecondaryButtonWithValue(
    modifier: Modifier,
    image: ImageVector? = null,
    imageRes: Int? = null,
    imageTint: Color = Color.Unspecified,
    text: String? = null,
    value: String? = null,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    AppButtonWithValue(
        modifier = modifier,
        text = text,
        image = image,
        imageRes = imageRes,
        imageTint = imageTint,
        enabled = enabled,
        value = value,
        buttonColors = ButtonDefaults.outlinedButtonColors(
            contentColor = MaterialTheme.colors.secondary
        ),
        onClick = onClick
    )
}