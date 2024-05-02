package com.app.longexposurecalculator.presentation.ui.extensions

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.ui.Modifier
import androidx.wear.compose.foundation.lazy.ScalingLazyListScope

fun  ScalingLazyListScope.bottomSpacerItem() =
    item {
        Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.statusBars))
    }

fun ScalingLazyListScope.topSpacerItem() =
    item {
        Spacer(Modifier.windowInsetsTopHeight(WindowInsets.navigationBars))
    }