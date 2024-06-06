package com.app.longexposurecalculator.di

import com.app.longexposurecalculator.presentation.ui.home.HomeScreenViewModel
import com.app.longexposurecalculator.presentation.ui.sensor.SensorsDataViewModel
import com.app.longexposurecalculator.presentation.ui.wheel_select_picker.BaseWheelSelectPickerViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { HomeScreenViewModel(androidContext()) }
    viewModelOf(::HomeScreenViewModel)

    viewModel { BaseWheelSelectPickerViewModel(androidContext()) }
    viewModelOf(::BaseWheelSelectPickerViewModel)

    viewModel { SensorsDataViewModel(androidContext()) }
    viewModelOf(::SensorsDataViewModel)
}
