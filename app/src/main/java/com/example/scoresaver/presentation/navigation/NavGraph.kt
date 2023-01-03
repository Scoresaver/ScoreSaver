package com.example.scoresaver.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import com.example.scoresaver.presentation.screen.*
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
                HomeScreen(navController = navController)
            }
        }
        composable(Screen.Menu.route) {
            MenuScreen(navController = navController)
        }
        composable(Screen.History.route) {
            HistoryScreen()
        }
        composable(Screen.TypeGame.route) {
            TypeGameScreen()
        }
        composable(Screen.OrderService.route) {
            OrderServiceScreen()
        }
        composable(Screen.Advantages.route) {
            AdvantagesScreen()
        }
        composable(Screen.StartGame.route) {
            StartGameScreen()
        }
    }
}