package com.example.scoresaver.presentation.navigation


sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Home : Screen("home_screen")
    object Menu: Screen("menu_screen")
    object History: Screen("history_screen")
}
