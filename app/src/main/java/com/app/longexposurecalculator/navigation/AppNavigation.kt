package com.app.longexposurecalculator.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import com.app.longexposurecalculator.presentation.ui.home.HomeScreen
import com.app.longexposurecalculator.presentation.ui.sensor.SensorsDataScreen
import com.app.longexposurecalculator.presentation.ui.wheel_select_picker.BaseWheelSelectPickerScreen

@Composable
fun AppNavigation(
    navController: NavHostController,
) {
    SwipeDismissableNavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route,
    ) {
        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen(
                navigateBack = {
                    navController.popBackStack()
                },
                navigateTo = {
                    navController.navigate(it)
                }
            )
        }

        composable(
            route = Screen.SelectIsoScreen.route
        ) {
            BaseWheelSelectPickerScreen()
        }

        composable(
            route = Screen.SensorsScreen.route
        ) {
            SensorsDataScreen()
        }
    }
}