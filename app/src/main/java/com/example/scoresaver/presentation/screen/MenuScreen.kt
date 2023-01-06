package com.example.scoresaver.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.wear.compose.material.*
import com.example.scoresaver.R
import com.example.scoresaver.presentation.MenuViewModel
import com.example.scoresaver.presentation.navigation.Screen
import com.example.scoresaver.presentation.theme.BackgroundGrey
import com.example.scoresaver.presentation.theme.BackgroundOrange
import com.example.scoresaver.presentation.theme.ButtonDisabled
import com.example.scoresaver.presentation.theme.Orange
import com.example.scoresaver.presentation.ui.widget.ButtonCustom

@Composable
fun MenuScreen(
    navController: NavController,
    menuViewModel: MenuViewModel = viewModel()
) {

    val stateButton by menuViewModel.uiStateButton.collectAsState()
    val listState = rememberScalingLazyListState()

    val iconModifier = Modifier
        .padding(end = 10.dp)
        .size(12.dp)

    Scaffold(
        vignette = {
            Vignette(vignettePosition = VignettePosition.TopAndBottom)
        },
        positionIndicator = {
            PositionIndicator(
                scalingLazyListState = listState
            )
        }
    ) {
        ScalingLazyColumn(
            modifier = Modifier.fillMaxSize(),
            autoCentering = AutoCenteringParams(itemIndex = 3),
            state = listState
        ) {

            item {
                Text(
                    text = stringResource(id = R.string.new_game),
                    color = Orange,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center
                )
            }
            item {
                Spacer(modifier = Modifier.padding(top = 8.dp))
            }
            item {
                ButtonCustom(
                    iconModifier = iconModifier,
                    text = stringResource(id = R.string.type_game),
                    backgroundColor = BackgroundGrey,
                    borderColor = BackgroundGrey,
                    imageVector = ImageVector.vectorResource(id = R.drawable.icon_next),
                    onClickButton = {
                        navController.navigate(Screen.TypeGame.route)
                    }
                )
            }
            item {
                ButtonCustom(
                    iconModifier = iconModifier,
                    text = stringResource(id = R.string.order_service),
                    backgroundColor = BackgroundGrey,
                    borderColor = BackgroundGrey,
                    imageVector = ImageVector.vectorResource(id = R.drawable.icon_next),
                    onClickButton = {
                        navController.navigate(Screen.OrderService.route)
                    }
                )
            }

            item {
                ButtonCustom(
                    iconModifier = iconModifier,
                    text = stringResource(id = R.string.advantages),
                    backgroundColor = BackgroundGrey,
                    borderColor = BackgroundGrey,
                    imageVector = ImageVector.vectorResource(id = R.drawable.icon_next),
                    onClickButton = {
                        navController.navigate(Screen.Advantages.route)
                    }
                )
            }

            item {
                ButtonCustom(
                    iconModifier = iconModifier,
                    text = stringResource(
                        id = R.string.next
                    ),
                    backgroundColor = if (stateButton) Orange else ButtonDisabled,
                    borderColor = if (stateButton) Orange else ButtonDisabled,
                    textColor = if (stateButton) Color.Black else Color.White,
                    positionText = TextAlign.Center,
                    onClickButton = {
                        if (stateButton) {
                            navController.navigate(Screen.StartGame.route)
                        } else {
                            null
                        }
                    }
                )
            }
        }
    }
}