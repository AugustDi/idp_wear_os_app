package com.app.longexposurecalculator.presentation.ui.home.components

import androidx.compose.ui.graphics.vector.ImageVector

class AppButtonDvo private constructor(
    val title: String?,
    val icon: ImageVector?,
    val value: Double?,
    val type: ExposureParameter?
) {

    data class Builder(
        var title: String? = null,
        var icon: ImageVector? = null,
        var value: Double? = null,
        var type: ExposureParameter? = null
    ) {

        fun setTitle(title: String) = apply { this.title = title }
        fun setIcon(icon: ImageVector) = apply { this.icon = icon }
        fun setValue(value: Double) = apply { this.value = value}
        fun setType(type: ExposureParameter) = apply { this.type = type }
        fun build() = AppButtonDvo(title, icon, value, type)
    }
}


