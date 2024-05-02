package com.app.longexposurecalculator.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import com.app.longexposurecalculator.presentation.ui.home.HomeScreen

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
            HomeScreen()
        }
    }
}