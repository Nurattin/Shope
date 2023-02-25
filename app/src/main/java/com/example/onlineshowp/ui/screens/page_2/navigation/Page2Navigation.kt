package com.example.onlineshowp.ui.screens.page_2.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.example.onlineshowp.core.navigation.ShopNavigationDestination
import com.example.onlineshowp.ui.screens.page_1.Page1Screen
import com.example.onlineshowp.ui.screens.page_2.Page2Screen
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation

object Page2Destination : ShopNavigationDestination {
    override val route = "page2_route"
    override val destination = "page2_destination"
}


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.page2(
    onBackClick: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {

    navigation(
        route = Page2Destination.route,
        startDestination = Page2Destination.destination,
    ) {
        composable(
            route = Page2Destination.destination,
        ) {
            Page2Screen()
        }
        nestedGraphs()
    }
}