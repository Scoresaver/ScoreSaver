package com.example.scoresaver.presentation.navigation


sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Home : Screen("home_screen")
    object Menu: Screen("menu_screen")
    object History: Screen("history_screen")
    object TypeGame: Screen("type_game_screen")
    object OrderService: Screen("order_service_screen")
    object Advantages: Screen("advantages_screen")
    object StartGame: Screen("start_game_screen")
}
