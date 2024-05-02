package com.app.longexposurecalculator.presentation.ui.home.components

import androidx.annotation.StringRes
import com.app.longexposurecalculator.R

enum class ExposureParameter {
    ISO,
    APERTURE,
    SHUTTER_SPEED;

    @get:StringRes
    val titleRes: Int
        get() = when (this) {
            ISO -> R.string.iso_sensitivity
            SHUTTER_SPEED -> R.string.shutter_speed
            APERTURE -> R.string.aperture
        }

    val defaultValue: Double
        get() = when(this) {
            ISO -> 100.0
            APERTURE -> 2.8
            SHUTTER_SPEED -> 10000.0
        }
}