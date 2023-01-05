package com.example.scoresaver.presentation.screen

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text
import com.example.scoresaver.R
import com.example.scoresaver.presentation.navigation.Screen
import com.example.scoresaver.presentation.theme.BackgroundGrey
import com.example.scoresaver.presentation.theme.Orange
import com.example.scoresaver.presentation.ui.widget.ButtonCustom

@Composable
fun MenuScreen(
    navController: NavController
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.icon_back),
            modifier = Modifier
                .padding(start = 16.dp, top = 18.dp)
                .clickable {
                    navController.popBackStack()
                },
            contentDescription = "icon button",
            tint = Orange
        )
        Text(
            modifier = Modifier.padding(start = 7.dp, top = 17.dp),
            text = stringResource(id = R.string.new_game),
            color = Orange,
            fontSize = 12.sp
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ButtonCustom(
            text = stringResource(id = R.string.type_game),
            height = 27,
            backgroundColor = BackgroundGrey,
            borderColor = BackgroundGrey,
            imageVector = ImageVector.vectorResource(id = R.drawable.icon_next),
            sizeIcon = 12,
            onClickButton = {
                navController.navigate(Screen.TypeGame.route)
            }
        )
        Spacer(modifier = Modifier.padding(top = 8.dp))
        ButtonCustom(
            text = stringResource(id = R.string.order_service),
            height = 27,
            backgroundColor = BackgroundGrey,
            borderColor = BackgroundGrey,
            imageVector = ImageVector.vectorResource(id = R.drawable.icon_next),
            sizeIcon = 12,
            onClickButton = {
                navController.navigate(Screen.OrderService.route)
            }
        )
        Spacer(modifier = Modifier.padding(top = 8.dp))
        ButtonCustom(
            text = stringResource(id = R.string.advantages),
            height = 27,
            backgroundColor = BackgroundGrey,
            borderColor = BackgroundGrey,
            imageVector = ImageVector.vectorResource(id = R.drawable.icon_next),
            sizeIcon = 12,
            onClickButton = {
                navController.navigate(Screen.Advantages.route)
            }
        )
        Spacer(modifier = Modifier.padding(top = 18.dp))

        ButtonCustom(
            text = stringResource(
                id = R.string.next
            ),
            backgroundColor = Orange,
            borderColor = Orange,
            positionText = TextAlign.Center,
            textColor = Color.Black,
            onClickButton = {
                navController.navigate(Screen.StartGame.route)
            }
        )

    }
}