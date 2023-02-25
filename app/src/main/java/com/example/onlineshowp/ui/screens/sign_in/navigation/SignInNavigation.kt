package com.example.onlineshowp.ui.screens.sign_in.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.example.onlineshowp.core.navigation.ShopNavigationDestination
import com.example.onlineshowp.ui.screens.pofile.ProfileScreen
import com.example.onlineshowp.ui.screens.sign_in.SignInScreen
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation

object SignInDestination : ShopNavigationDestination {
    override val route = "signIn_route"
    override val destination = "signIn_destination"
}


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.signIn(
    onBackClick: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {

    navigation(
        route = SignInDestination.route,
        startDestination = SignInDestination.destination,
    ) {
        composable(
            route = SignInDestination.destination,
        ) {
            SignInScreen()
        }
        nestedGraphs()
    }
}