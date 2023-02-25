package com.example.onlineshowp.core.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.EaseInOutQuad
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.example.onlineshowp.ui.screens.basket.navigation.basket
import com.example.onlineshowp.ui.screens.chat.navigation.chat
import com.example.onlineshowp.ui.screens.favorite.navigation.favorite
import com.example.onlineshowp.ui.screens.log_in.navigation.loginIn
import com.example.onlineshowp.ui.screens.page_1.navigation.Page1Destination
import com.example.onlineshowp.ui.screens.page_1.navigation.page1
import com.example.onlineshowp.ui.screens.page_2.navigation.page2
import com.example.onlineshowp.ui.screens.pofile.navigation.profile
import com.example.onlineshowp.ui.screens.sign_in.navigation.SignInDestination
import com.example.onlineshowp.ui.screens.sign_in.navigation.signIn
import com.google.accompanist.navigation.animation.AnimatedNavHost


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ShopNavHost(
    navController: NavHostController,
    onNavigateToDestination: (destination: ShopNavigationDestination, route: String?) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    AnimatedNavHost(
        navController = navController,
        startDestination = Page1Destination.route,
        modifier = modifier
    ) {
        page1(onBackClick = onBackClick) {

        }
        page2(onBackClick = onBackClick) {

        }
        favorite(onBackClick = onBackClick) {

        }
        basket(onBackClick = onBackClick) {

        }
        chat(onBackClick = onBackClick) {

        }
        loginIn(onBackClick = onBackClick) {

        }
        signIn(onBackClick = onBackClick) {

        }
        profile(onBackClick = onBackClick) {

        }
    }
}

@Composable
private fun startDestination(isAuthorization: Boolean) =
    if (isAuthorization) "MainDestination.route" else "AccountDestination.route"

const val DURATION_NAVIGATION_ANIMATION = 250

@OptIn(ExperimentalAnimationApi::class)
fun AnimatedContentScope<NavBackStackEntry>.currentRout() = initialState.destination.route

@OptIn(ExperimentalAnimationApi::class)
fun AnimatedContentScope<NavBackStackEntry>.targetRout() = targetState.destination.route

@OptIn(ExperimentalAnimationApi::class)
fun AnimatedContentScope<NavBackStackEntry>.slideIntoContainer(direction: Direction): EnterTransition {
    val slideDirection = when (direction) {
        Direction.Right -> AnimatedContentScope.SlideDirection.Right
        Direction.Left -> AnimatedContentScope.SlideDirection.Left
        Direction.Up -> AnimatedContentScope.SlideDirection.Up
        Direction.Down -> AnimatedContentScope.SlideDirection.Down
    }
    return slideIntoContainer(
        slideDirection,
        animationSpec = tween(
            durationMillis = DURATION_NAVIGATION_ANIMATION,
            easing = EaseInOutQuad
        )
    )
}

@OptIn(ExperimentalAnimationApi::class)
fun AnimatedContentScope<NavBackStackEntry>.slideOutOfContainer(direction: Direction): ExitTransition {
    val slideDirection = when (direction) {
        Direction.Right -> AnimatedContentScope.SlideDirection.Right
        Direction.Left -> AnimatedContentScope.SlideDirection.Left
        Direction.Up -> AnimatedContentScope.SlideDirection.Up
        Direction.Down -> AnimatedContentScope.SlideDirection.Down
    }
    return slideOutOfContainer(
        slideDirection,
        animationSpec = tween(
            durationMillis = DURATION_NAVIGATION_ANIMATION,
            easing = EaseInOutQuad
        )
    )
}

enum class Direction {
    Right, Left, Up, Down
}

