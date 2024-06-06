package com.app.longexposurecalculator.presentation.ui.sensor

import android.app.Application
import android.content.Context.SENSOR_SERVICE
import android.hardware.SensorManager
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.HorizontalPageIndicator
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.InlineSlider
import androidx.wear.compose.material.InlineSliderDefaults
import androidx.wear.compose.material.PageIndicatorState
import org.koin.androidx.compose.koinViewModel

@Composable
fun SensorsDataScreen(
    vm: SensorsDataViewModel = koinViewModel(),
) {
    SensorDataScreen()
}

@Composable
private fun SensorDataScreen() {
    val maxPages = 9
    var selectedPage by remember { mutableStateOf(0) }
    var finalValue by remember { mutableStateOf(0) }

    val animatedSelectedPage by animateFloatAsState(
        targetValue = selectedPage.toFloat(), label = "",
    ) {
        finalValue = it.toInt()
    }

    val pageIndicatorState: PageIndicatorState = remember {
        object : PageIndicatorState {
            override val pageOffset: Float
                get() = animatedSelectedPage - finalValue
            override val selectedPage: Int
                get() = finalValue
            override val pageCount: Int
                get() = maxPages
        }
    }

    Box(modifier = Modifier.fillMaxSize().padding(6.dp)) {
        InlineSlider(
            modifier = Modifier.align(Alignment.Center),
            value = selectedPage,
            increaseIcon = { Icon(InlineSliderDefaults.Increase, "Increase") },
            decreaseIcon = { Icon(InlineSliderDefaults.Decrease, "Decrease") },
            valueProgression = 0 until maxPages,
            onValueChange = { selectedPage = it }
        )
        HorizontalPageIndicator(
            pageIndicatorState = pageIndicatorState
        )
    }

}