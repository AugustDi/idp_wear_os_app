package com.app.longexposurecalculator.presentation.ui.home

import android.app.Application
import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Adjust
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Iso
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.ShutterSpeed
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.app.longexposurecalculator.R
import com.app.longexposurecalculator.presentation.ui.home.components.AppButtonDvo
import com.app.longexposurecalculator.presentation.ui.home.components.ExposureParameter
import com.app.longexposurecalculator.presentation.ui.home.state.HomeScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeScreenViewModel(
    context: Context
): AndroidViewModel(context.applicationContext as Application) {

    private val _screenState = MutableStateFlow<HomeScreenState>(HomeScreenState.Initial)
    val screenState = _screenState.asStateFlow()

    init {
        _screenState.update {
            HomeScreenState.ShowButtons(
                buttons = buildButtons()
            )
        }
    }


    private fun buildButtons(): List<AppButtonDvo> {
        val body = mutableListOf<AppButtonDvo>()

        body.add(buildIsoButton())
        body.add(buildApertureButton())
        body.add(buildShutterSpeedButton())
        body.add(buildSaveButton())

        return body
    }

    private fun buildIsoButton() = AppButtonDvo.Builder()
        .setIcon(Icons.Default.Iso)
        .setTitle(getApplication<Application>().getString(ExposureParameter.ISO.titleRes))
        .setType(ExposureParameter.ISO)
        .setValue(ExposureParameter.ISO.defaultValue)
        .build()

    private fun buildApertureButton() = AppButtonDvo.Builder()
        .setIcon(Icons.Default.Adjust)
        .setTitle(getApplication<Application>().getString(ExposureParameter.APERTURE.titleRes))
        .setType(ExposureParameter.APERTURE)
        .setValue(ExposureParameter.APERTURE.defaultValue)
        .build()

    private fun buildShutterSpeedButton() = AppButtonDvo.Builder()
        .setIcon(Icons.Default.ShutterSpeed)
        .setTitle(getApplication<Application>().getString(ExposureParameter.SHUTTER_SPEED.titleRes))
        .setType(ExposureParameter.SHUTTER_SPEED)
        .setValue(ExposureParameter.SHUTTER_SPEED.defaultValue)
        .build()

    private fun buildSaveButton() = AppButtonDvo.Builder()
        .setIcon(Icons.Default.Calculate)
        .setTitle(getApplication<Application>().getString(R.string.calculate))
        .build()
}