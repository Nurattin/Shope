package com.example.onlineshowp.ui.screens.chat.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.example.onlineshowp.core.navigation.ShopNavigationDestination
import com.example.onlineshowp.ui.screens.chat.ChatScreen
import com.example.onlineshowp.ui.screens.log_in.LogInScreen
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation

object ChatDestination : ShopNavigationDestination {
    override val route = "chat_route"
    override val destination = "chat_destination"
}


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.chat(
    onBackClick: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {

    navigation(
        route = ChatDestination.route,
        startDestination = ChatDestination.destination,
    ) {
        composable(
            route = ChatDestination.destination,
        ) {
            ChatScreen()
        }
        nestedGraphs()
    }
}