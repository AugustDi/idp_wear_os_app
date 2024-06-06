package com.app.longexposurecalculator.presentation.ui.home.state

sealed interface NavigationState {
    data object None: NavigationState
    data object NavigateBack: NavigationState
    data class NavigateTo(val route: String): NavigationState
}