package com.machinetest.ui.theme.navigation

import kotlinx.serialization.Serializable

/**
 * NavScreens
 *
 * @author stephingeorge
 * @date 18/11/2025
 */
sealed class NavScreens {
    @Serializable
    object Home : NavScreens()

    @Serializable
    object Settings : NavScreens()

    @Serializable
    object Login : NavScreens()

    @Serializable
    object BottomNavGraph : NavScreens()
}