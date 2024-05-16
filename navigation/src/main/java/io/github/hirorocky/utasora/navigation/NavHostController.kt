package io.github.hirorocky.utasora.navigation

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController

fun NavHostController.navigateTo(route: String) =
    navigate(route) {
        popUpTo(route)
        launchSingleTop = true
    }

fun NavHostController.clearAndNavigateTo(route: String) =
    navigate(route) {
        popUpTo(id = 0) {
            saveState = true
            inclusive = true
        }
        launchSingleTop = true
        restoreState = true
    }

val NavHostController.canGoBack: Boolean
    get() = this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED
