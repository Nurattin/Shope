package com.example.onlineshowp.ui.screens.basket.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.example.onlineshowp.core.navigation.ShopNavigationDestination
import com.example.onlineshowp.ui.screens.basket.BasketScreen
import com.example.onlineshowp.ui.screens.chat.ChatScreen
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation

object BasketDestination : ShopNavigationDestination {
    override val route = "basket_route"
    override val destination = "basket_destination"
}


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.basket(
    onBackClick: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {

    navigation(
        route = BasketDestination.route,
        startDestination = BasketDestination.destination,
    ) {
        composable(
            route = BasketDestination.destination,
        ) {
            BasketScreen()
        }
        nestedGraphs()
    }
}