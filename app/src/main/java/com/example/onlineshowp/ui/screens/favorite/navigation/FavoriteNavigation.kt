package com.example.onlineshowp.ui.screens.favorite.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.example.onlineshowp.core.navigation.ShopNavigationDestination
import com.example.onlineshowp.ui.screens.favorite.FavoriteScreen
import com.example.onlineshowp.ui.screens.log_in.LogInScreen
import com.example.onlineshowp.ui.screens.sign_in.SignInScreen
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation

object FavoriteDestination : ShopNavigationDestination {
    override val route = "favorite_route"
    override val destination = "favorite_destination"
}


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.favorite(
    onBackClick: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {

    navigation(
        route = FavoriteDestination.route,
        startDestination = FavoriteDestination.destination,
    ) {
        composable(
            route = FavoriteDestination.destination,
        ) {
            FavoriteScreen()
        }
        nestedGraphs()
    }
}