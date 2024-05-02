package com.app.longexposurecalculator.presentation.ui.home

import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.rotary.onRotaryScrollEvent
import androidx.compose.ui.unit.dp
import androidx.wear.compose.foundation.ExperimentalWearFoundationApi
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.ScalingLazyColumnDefaults
import androidx.wear.compose.foundation.lazy.ScalingLazyListAnchorType
import androidx.wear.compose.foundation.lazy.items
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.foundation.rememberActiveFocusRequester
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.TimeText
import androidx.wear.compose.material.Vignette
import androidx.wear.compose.material.VignettePosition
import androidx.wear.compose.material.scrollAway
import com.app.longexposurecalculator.presentation.ui.components.PrimaryButtonWithValue
import com.app.longexposurecalculator.presentation.ui.extensions.topSpacerItem
import com.app.longexposurecalculator.presentation.ui.home.state.HomeScreenState
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = koinViewModel(),
) {

    val screenState by viewModel.screenState.collectAsState()

    HomeContent(
        screenState = screenState
    )
}

@OptIn(ExperimentalWearFoundationApi::class)
@Composable
private fun HomeContent(
    screenState: HomeScreenState,
) {
    val scrollState = rememberScalingLazyListState()
    val focusRequester = rememberActiveFocusRequester()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        positionIndicator = {
            PositionIndicator(scalingLazyListState = scrollState)
        },
        timeText = {
            TimeText(
                modifier = Modifier.scrollAway(scrollState)
            )
        },
        vignette = {
            Vignette(vignettePosition = VignettePosition.TopAndBottom)
        }
    ) {

        when (screenState) {
            HomeScreenState.Initial -> Unit
            is HomeScreenState.ShowButtons -> {
                ScalingLazyColumn(
                    modifier = Modifier
                        .displayCutoutPadding()
                        .onRotaryScrollEvent {
                            coroutineScope.launch {
                                scrollState.scrollBy(it.verticalScrollPixels)

                                scrollState.animateScrollBy(0f)
                            }
                            true
                        }
                        .focusRequester(focusRequester)
                        .focusable(),
                    state = scrollState,
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    scalingParams = ScalingLazyColumnDefaults.scalingParams(
                        edgeScale = 0.5f,
                        minTransitionArea = 0.65f,
                        maxTransitionArea = 0.70f
                    ),
                ) {

                    topSpacerItem()

                    items(screenState.buttons) { button ->

                        PrimaryButtonWithValue(
                            modifier = Modifier.fillMaxWidth(),
                            text = button.title,
                            value = if (button.value != null && button.value >= 0) button.value.toString() else null,
                            image = button.icon
                        ) {

                        }
                    }
                }
            }
        }
    }
}