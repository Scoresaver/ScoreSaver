package com.example.scoresaver.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import com.example.scoresaver.presentation.screen.HomeScreen
import com.example.scoresaver.presentation.screen.SplashScreen
import com.example.scoresaver.presentation.util.EnterAnimation


@Composable
fun SetupNavGraph(navController: NavHostController) {
    SwipeDismissableNavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.Home.route) {
            EnterAnimation {
                HomeScreen()
            }
        }
    }
}