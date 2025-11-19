package com.machinetest.ui.theme.navigation

import android.annotation.SuppressLint
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.machinetest.ui.theme.White
import com.machinetest.ui.theme.features.login.LoginScreen
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.machinetest.ui.theme.features.home.ForecastViewModel
import com.machinetest.ui.theme.features.home.HomeScreen

/**
 * ParentNav
 *
 * @author stephingeorge
 * @date 18/11/2025
 */

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ParentNav() {
    val navHostController = rememberNavController()
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = false)
    }
    Scaffold(
        containerColor = White,
        bottomBar = {
            // Show bottom bar only when inside the BottomNavGraph
            val navBackStackEntry by navHostController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination?.route
            if (currentDestination != NavScreens.Login.toString()) {
                // BottomBar(navController)
            }
        }) {

        RootNavGraph(navHostController)

    }

}

@Composable
fun RootNavGraph(navController: NavHostController) {
    val viewModel : ForecastViewModel= hiltViewModel()

    NavHost(
        navController = navController, startDestination = NavScreens.Login,
        enterTransition = { fadeIn(animationSpec = tween(300)) },
        exitTransition = { fadeOut(animationSpec = tween(300)) }) {

        composable<NavScreens.Login> {
            LoginScreen(
                onLoggedIn = {
                    navController.navigate(NavScreens.Home) {
                        popUpTo(NavScreens.Login) { inclusive = true }
                    }
                }
            )
        }
        composable<NavScreens.Home> {
            HomeScreen(viewModel)
        }

    }
}
