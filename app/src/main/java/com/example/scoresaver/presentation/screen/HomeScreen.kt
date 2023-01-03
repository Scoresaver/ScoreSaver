package com.example.scoresaver.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.wear.compose.material.*
import com.example.scoresaver.R
import com.example.scoresaver.presentation.navigation.Screen
import com.example.scoresaver.presentation.ui.widget.ButtonCustom

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ButtonCustom(text = stringResource(id = R.string.new_game),
            onClickButton = {
            navController.navigate(Screen.Menu.route)
        })
        Spacer(modifier = Modifier.padding(top = 10.dp))
        ButtonCustom(
            text = stringResource(id = R.string.history_game),
            imageVector = Icons.Rounded.History,
            onClickButton = {
                navController.navigate(Screen.History.route)
            }
        )
    }
}

