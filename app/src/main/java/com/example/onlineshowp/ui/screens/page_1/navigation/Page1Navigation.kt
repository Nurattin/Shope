package com.example.onlineshowp.ui.screens.page_1.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.example.onlineshowp.core.navigation.ShopNavigationDestination
import com.example.onlineshowp.ui.screens.page_1.Page1Screen
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation

object Page1Destination : ShopNavigationDestination {
    override val route = "page1_route"
    override val destination = "page1_destination"
}


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.page1(
    onBackClick: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {

    navigation(
        route = Page1Destination.route,
        startDestination = Page1Destination.destination,
    ) {
        composable(
            route = Page1Destination.destination,
        ) {
            Page1Screen()
        }
        nestedGraphs()
    }
}