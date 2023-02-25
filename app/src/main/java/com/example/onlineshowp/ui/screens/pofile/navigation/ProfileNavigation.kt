package com.example.onlineshowp.ui.screens.pofile.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.example.onlineshowp.core.navigation.ShopNavigationDestination
import com.example.onlineshowp.ui.screens.page_2.Page2Screen
import com.example.onlineshowp.ui.screens.pofile.ProfileScreen
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation

object ProfileDestination : ShopNavigationDestination {
    override val route = "profile_route"
    override val destination = "profile_destination"
}


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.profile(
    onBackClick: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {

    navigation(
        route = ProfileDestination.route,
        startDestination = ProfileDestination.destination,
    ) {
        composable(
            route = ProfileDestination.destination,
        ) {
            ProfileScreen()
        }
        nestedGraphs()
    }
}