package com.app.longexposurecalculator.navigation

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigator

sealed class Screen(
    private val name: String
) {
    val route get() = name + SCREEN_SUFFIX

    data object HomeScreen: Screen("home")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(name)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

    fun withArgsNullable(vararg args: String?): String {
        return buildString {
            append(name)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

    fun createArgsRoute(vararg args: String): String {
        return buildString {
            append(name)
            args.forEach { args ->
                append("/{$args}")
            }
        }
    }
    fun createNullableArgsRoute(vararg args: String): String {
        return buildString {
            append(name)
            args.forEach { args ->
                append("?$args={$args}")
            }
        }
    }

    @SuppressLint("RestrictedApi")
    fun NavController.navigateWithParam(
        route: String,
        data: Parcelable,
        key: String,
        navOptions: NavOptions? = null,
        navigatorExtras: Navigator.Extras? = null
    ) {
        try {
            val routeLink = NavDeepLinkRequest
                .Builder
                .fromUri(NavDestination.createRoute(route).toUri())
                .build()

            val bundle = Bundle()
            bundle.putParcelable(key, data)

            val deepLinkMatch = graph.matchDeepLink(routeLink)
            if (deepLinkMatch != null) {
                val destination = deepLinkMatch.destination
                val id = destination.id
                navigate(id, bundle, navOptions, navigatorExtras)
            } else {
                navigate(route, navOptions, navigatorExtras)
            }
        } catch (e: IllegalArgumentException) {
            Log.e("NavigationError", "-----> ${e.message}")

        }
    }

    @SuppressLint("RestrictedApi")
    fun NavController.navigateWithParam(
        route: String,
        data: Array<Parcelable>,
        key: String,
        navOptions: NavOptions? = null,
        navigatorExtras: Navigator.Extras? = null
    ) {
        val routeLink = NavDeepLinkRequest
            .Builder
            .fromUri(NavDestination.createRoute(route).toUri())
            .build()

        val bundle = Bundle()
        bundle.putParcelableArray(key, data)

        val deepLinkMatch = graph.matchDeepLink(routeLink)
        if (deepLinkMatch != null) {
            val destination = deepLinkMatch.destination
            val id = destination.id
            navigate(id, bundle, navOptions, navigatorExtras)
        } else {
            navigate(route, navOptions, navigatorExtras)
        }
    }

    companion object {
        const val SCREEN_SUFFIX = "_screen"
    }
}