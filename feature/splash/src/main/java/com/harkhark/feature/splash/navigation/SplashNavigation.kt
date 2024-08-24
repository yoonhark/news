package com.harkhark.feature.splash.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.harkhark.feature.splash.SplashScreen


const val SPLASH_ROUTE = "splash_route"

fun NavController.navigateToSplash(navOptions: NavOptions) = navigate(SPLASH_ROUTE, navOptions)

fun NavGraphBuilder.splashScreen(
    modifier: Modifier,
    navigateToHome: () -> Unit,
) {
    composable(route = SPLASH_ROUTE) {
        SplashScreen(modifier, navigateToHome)
    }
}
