package com.example.onlineshowp.ui.screens.log_in.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.example.onlineshowp.core.navigation.ShopNavigationDestination
import com.example.onlineshowp.ui.screens.log_in.LogInScreen
import com.example.onlineshowp.ui.screens.sign_in.SignInScreen
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation

object LogInDestination : ShopNavigationDestination {
    override val route = "loginIn_route"
    override val destination = "loginIn_destination"
}


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.loginIn(
    onBackClick: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {

    navigation(
        route = LogInDestination.route,
        startDestination = LogInDestination.destination,
    ) {
        composable(
            route = LogInDestination.destination,
        ) {
            LogInScreen()
        }
        nestedGraphs()
    }
}