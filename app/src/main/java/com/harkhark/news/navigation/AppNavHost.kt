package com.harkhark.news.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.harkhark.feature.detail.navigation.detailScreen
import com.harkhark.feature.home.navigation.homeScreen
import com.harkhark.feature.home.navigation.navigateToHome
import com.harkhark.feature.splash.navigation.SPLASH_ROUTE
import com.harkhark.feature.splash.navigation.splashScreen
import com.harkhark.news.ui.AppState

@Composable
fun AppNavHost(
    appState: AppState,
    onShowSnackbar: suspend (String) -> Boolean,
) {
    val navController = appState.navController

    val modifier = Modifier.fillMaxSize()

    NavHost(
        navController = navController,
        startDestination = SPLASH_ROUTE,
        modifier = Modifier.fillMaxSize(),
    ) {
        // Main Activity에서 사용되는 화면들을 등록
        splashScreen(
            modifier = modifier,
            navigateToHome = navController::navigateToHome,
        )

        homeScreen(
            modifier = modifier,
            onClickDetail = navController::navigateUp,
        )
        detailScreen(
            modifier = modifier,
        )
    }
}