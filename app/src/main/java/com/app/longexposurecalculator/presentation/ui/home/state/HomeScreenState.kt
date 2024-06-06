package com.app.longexposurecalculator.presentation.ui.home.state

import androidx.annotation.StringRes
import com.app.longexposurecalculator.R
import com.app.longexposurecalculator.navigation.Screen
import com.app.longexposurecalculator.presentation.ui.home.components.AppButtonDvo

sealed class HomeScreenState(
    @StringRes
    val title: Int = R.string.exposure_calculator,
    val isCalculateButtonEnabled: Boolean = false,
    var updatedTimeLocal: Long? = System.currentTimeMillis(),
) {

    data object Initial: HomeScreenState()

    data class ShowButtons(
        val buttons: List<AppButtonDvo>,
    ): HomeScreenState()
}