package com.example.scoresaver.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.wear.compose.material.Text
import com.example.scoresaver.R
import com.example.scoresaver.presentation.navigation.Screen
import com.example.scoresaver.presentation.theme.BackgroundLight
import com.example.scoresaver.presentation.theme.BackgroundOrange
import com.example.scoresaver.presentation.theme.Light
import com.example.scoresaver.presentation.theme.Orange
import com.example.scoresaver.presentation.ui.widget.ButtonCustom

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.padding(bottom = 30.dp),
            text = stringResource(id = R.string.title),
            color = Orange,
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.quanticoregular))
        )

        ButtonCustom(
            text = stringResource(id = R.string.new_game),
            imageVector = ImageVector.vectorResource(id = R.drawable.icon_add),
            onClickButton = {
                navController.navigate(Screen.Menu.route)
            },
            backgroundColor = Orange,
            borderColor = BackgroundOrange,
            textColor = Color.Black,
            tintColor = Color.Black
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))
        ButtonCustom(
            text = stringResource(id = R.string.history_game),
            imageVector = ImageVector.vectorResource(id = R.drawable.icon_undo),
            onClickButton = {
                navController.navigate(Screen.History.route)
            },
            backgroundColor = Light,
            borderColor = BackgroundLight,
            textColor = Color.Black,
            tintColor = Color.Black
        )
    }
}

