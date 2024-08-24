package com.harkhark.feature.home.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.harkhark.feature.home.HomeScreen


const val HOME_ROUTE = "home_route"

fun NavController.navigateToHome() = navigate(HOME_ROUTE)

fun NavGraphBuilder.homeScreen(
    modifier: Modifier,
    onClickDetail:() -> Unit
) {
    composable(route = HOME_ROUTE) {
        HomeScreen(modifier)
    }
}
