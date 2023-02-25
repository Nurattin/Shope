package com.example.onlineshowp

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.onlineshowp.core.navigation.*


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AppScreen() {
    val appState: ShopAppState = rememberShopAppState()
    Scaffold(
        bottomBar = {
            MappaBottomBar(
                destinations = topLevelDestinations,
                onNavigateToDestination = { appState.navigate(destination = it, null) },
                currentDestination = appState.currentDestination,
            )
        },
        backgroundColor = Color(0xFFCDCBC7)
    ) {
        ShopNavHost(
            navController = appState.navController,
            onBackClick = appState::onBackClick,
            onNavigateToDestination = appState::navigate,
            modifier = Modifier,
        )
    }
}


@Composable
fun MappaBottomBar(
    modifier: Modifier = Modifier,
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            .fillMaxWidth()
            .background(Color.White)
            .padding(start = 23.dp, top = 13.dp, bottom = 10.dp, end = 23.dp)
            .selectableGroup(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        destinations.forEach { destination ->
            MappaBottomBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == destination.route } == true,
                onClick = onNavigateToDestination,
                destination = destination,
            )
        }
    }
}

@Composable
fun MappaBottomBarItem(
    onClick: (TopLevelDestination) -> Unit,
    selected: Boolean = false,
    destination: TopLevelDestination,
) {

    val animBg by animateFloatAsState(
        targetValue = if (selected) 1f else 0f,
        animationSpec = tween(500)
    )
    val animTn by animateColorAsState(
        targetValue = if (selected) Color(0xFF737297) else Color(0xFF909090),
        animationSpec = tween(500)
    )
    val animSc by animateFloatAsState(
        targetValue = if (selected) 1.2f else 1f,
        animationSpec = tween(500)
    )
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = false),
                onClick = { onClick(destination) })
            .background(color = Color(0xFFEEEFF4).copy(alpha = animBg))
        ,
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.scale(animSc),
            painter = painterResource(id = destination.icon),
            contentDescription = null,
            tint = animTn
        )
    }
}
