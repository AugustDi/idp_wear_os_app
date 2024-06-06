package com.app.longexposurecalculator.presentation.ui.home.event

import com.app.longexposurecalculator.presentation.ui.home.components.ExposureParameter

sealed interface HomeScreenEvent {
    data object OnBackPressed: HomeScreenEvent
    data class OnValueChanged(
        val type: ExposureParameter
    ): HomeScreenEvent
    data object Calculate: HomeScreenEvent
}