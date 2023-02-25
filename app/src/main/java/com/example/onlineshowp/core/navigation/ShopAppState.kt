package com.example.onlineshowp.core.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.onlineshowp.R
import com.example.onlineshowp.ui.screens.basket.navigation.BasketDestination
import com.example.onlineshowp.ui.screens.chat.navigation.ChatDestination
import com.example.onlineshowp.ui.screens.favorite.navigation.FavoriteDestination
import com.example.onlineshowp.ui.screens.page_1.navigation.Page1Destination
import com.example.onlineshowp.ui.screens.pofile.navigation.ProfileDestination
import com.google.accompanist.navigation.animation.rememberAnimatedNavController


val topLevelDestinations: List<TopLevelDestination> = listOf(
    TopLevelDestination(
        route = Page1Destination.route,
        destination = Page1Destination.destination,
        icon = R.drawable.ic_home,
        title = "Home",
    ),
    TopLevelDestination(
        route = FavoriteDestination.route,
        destination = FavoriteDestination.destination,
        icon = R.drawable.ic_favorite,
        title = "Favorite",
    ),
    TopLevelDestination(
        route = BasketDestination.route,
        destination = BasketDestination.destination,
        icon = R.drawable.ic_basket,
        title = "Basket"
    ),
    TopLevelDestination(
        route = ChatDestination.route,
        destination = ChatDestination.destination,
        icon = R.drawable.ic_chat,
        title = "Chat"
    ),
    TopLevelDestination(
        route = ProfileDestination.route,
        destination = ProfileDestination.destination,
        icon = R.drawable.ic_user,
        title = "Profile",
    )
)

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun rememberShopAppState(
    navController: NavHostController = rememberAnimatedNavController(),
): ShopAppState {
    return remember(navController) { ShopAppState(navController) }
}

@Stable
class ShopAppState constructor(
    val navController: NavHostController,
) {

    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    /**
     * UI logic for navigating to a particular destination in the app. The NavigationOptions to
     * navigate with are based on the type of destination, which could be a top level destination or
     * just a regular destination.
     *
     * Top level destinations have only one copy of the destination of the back stack, and save and
     * restore state whenever you navigate to and from it.
     * Regular destinations can have multiple copies in the back stack and state isn't saved nor
     * restored.
     *
     * @param destination: The [MappaNavigationDestination] the app needs to navigate to.
     * @param route: Optional route to navigate to in case the destination contains arguments.
     */

    fun navigate(destination: ShopNavigationDestination, route: String? = null) {
        if (destination is TopLevelDestination) {
            navController.navigate(route ?: destination.route) {
                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                launchSingleTop = true
                restoreState = true
            }
        } else {
            navController.navigate(route ?: destination.route) {
                launchSingleTop = true
            }
        }
    }

    fun onBackClick() {
        navController.popBackStack()
    }
}