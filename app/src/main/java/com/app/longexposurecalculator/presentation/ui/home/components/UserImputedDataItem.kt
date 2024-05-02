package com.app.longexposurecalculator.presentation.ui.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.wear.compose.foundation.lazy.ScalingLazyListScope
import com.app.longexposurecalculator.presentation.ui.components.PrimaryButtonWithValue

@Composable
fun UserCameraValueItem(
    title: String,
    value: String,
    image: ImageVector,
    onClick: () -> Unit,
) {
    PrimaryButtonWithValue(
        modifier = Modifier.fillMaxWidth(),
        text = title,
        value = value,
        image = image
    ) {
        onClick()
    }
}

fun ScalingLazyListScope.userCameraValueItem(
    title: String,
    value: String,
    image: ImageVector,
    onClick: () -> Unit,
) = item {
    UserCameraValueItem(
        title = title,
        value = value,
        image = image,
        onClick = onClick
    )
}