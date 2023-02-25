package com.example.onlineshowp.core.navigation

import androidx.annotation.DrawableRes


/**
 * Each of these destinations
 * can contain one or more screens
 */
data class TopLevelDestination(
    override val route: String,
    override val destination: String,
    @DrawableRes val icon: Int,
    val title: String,
): ShopNavigationDestination