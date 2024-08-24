package com.harkhark.feature.detail.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.harkhark.feature.detail.DetailScreen


const val DETAIL_ROUTE = "detail_route"

fun NavController.navigateToDetail(navOptions: NavOptions) = navigate(DETAIL_ROUTE, navOptions)

fun NavGraphBuilder.detailScreen(
    modifier: Modifier,
) {
    composable(route = DETAIL_ROUTE) {
        DetailScreen()
    }
}
