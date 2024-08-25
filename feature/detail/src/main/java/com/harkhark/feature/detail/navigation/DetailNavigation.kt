package com.harkhark.feature.detail.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.harkhark.feature.detail.DetailScreen
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


const val DETAIL_ROUTE = "detail_route"
const val ARGS_URL = "url"

fun NavController.navigateToDetail(url: String) {
    val encodedUrl = URLEncoder.encode(url, StandardCharsets.UTF_8.toString())
    navigate("$DETAIL_ROUTE/$encodedUrl")
}

fun NavGraphBuilder.detailScreen(
    modifier: Modifier,
) {
    composable(
        route = "$DETAIL_ROUTE/{$ARGS_URL}",
        arguments = listOf(
            navArgument(ARGS_URL) {
                type = NavType.StringType
            },
        )
    ) {
        val url = it.arguments?.getString(ARGS_URL)?.let { encodedUrl ->
            URLDecoder.decode(encodedUrl, StandardCharsets.UTF_8.toString())
        } ?: ""
        DetailScreen(modifier = modifier, url = url)
    }
}
