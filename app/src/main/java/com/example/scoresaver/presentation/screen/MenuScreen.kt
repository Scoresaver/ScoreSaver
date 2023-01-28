package com.example.scoresaver.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.wear.compose.material.*
import com.example.scoresaver.R
import com.example.scoresaver.presentation.navigation.Screen
import com.example.scoresaver.presentation.theme.BackgroundGrey
import com.example.scoresaver.presentation.theme.ButtonDisabled
import com.example.scoresaver.presentation.theme.Orange
import com.example.scoresaver.presentation.ui.widget.ButtonCustom
import com.example.scoresaver.presentation.util.SETTINGS_TYPE
import com.example.scoresaver.presentation.util.VIEW_TYPE_ORDER_SERVICE
import com.example.scoresaver.presentation.util.WidgetSharedPrefsUtil

@Composable
fun MenuScreen(
    navController: NavController
) {

    val listState = rememberScalingLazyListState()
    val context = LocalContext.current

    val loadTypeGame = WidgetSharedPrefsUtil.loadPreferences(
        context,
        settingsType = SETTINGS_TYPE.TYPE_GAME.value
    )

    val adantagesType = WidgetSharedPrefsUtil.loadPreferences(
        context,
        settingsType = SETTINGS_TYPE.TYPE_ADVANTAGES.value
    )

    val seeOrderService = WidgetSharedPrefsUtil.loadFirstViewOrderService(
        context,
        settingsType = SETTINGS_TYPE.FIRST_VIEW_ORDER_SERVICE.value
    )

    val enabledButton = if (loadTypeGame == "single") {
        loadTypeGame.isNotEmpty() && !adantagesType.isNullOrEmpty()
    } else {
        !loadTypeGame.isNullOrEmpty() && !adantagesType.isNullOrEmpty() && seeOrderService == VIEW_TYPE_ORDER_SERVICE.VIEW.value
    }

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
                    text = when (loadTypeGame) {
                        "single" -> stringResource(id = R.string.single_game)
                        "double" -> stringResource(id = R.string.double_game)
                        else -> stringResource(id = R.string.type_game)
                    },
                    backgroundColor = BackgroundGrey,
                    borderColor = BackgroundGrey,
                    imageVector = ImageVector.vectorResource(id = R.drawable.icon_next),
                    onClickButton = {
                        navController.navigate(Screen.TypeGame.route)
                    },
                    iconChecked = if (loadTypeGame.isNullOrEmpty()) null else ImageVector.vectorResource(
                        id = R.drawable.ic_check
                    )
                )
            }
            if (loadTypeGame != "single") {
                item {
                    ButtonCustom(
                        iconModifier = iconModifier,
                        text = stringResource(id = R.string.order_service),
                        backgroundColor = BackgroundGrey,
                        borderColor = BackgroundGrey,
                        imageVector = ImageVector.vectorResource(id = R.drawable.icon_next),
                        onClickButton = {
                            navController.navigate(Screen.OrderService.route)
                        },
                        iconChecked = if (seeOrderService == VIEW_TYPE_ORDER_SERVICE.VIEW.value) ImageVector.vectorResource(id = R.drawable.ic_check) else null
                    )
                }
            }

            item {
                ButtonCustom(
                    iconModifier = iconModifier,
                    text = when (adantagesType) {
                        "classic" -> stringResource(id = R.string.advantages)
                        "killer" -> stringResource(id = R.string.killer_text)
                        else -> stringResource(id = R.string.advantages)
                    },
                    backgroundColor = BackgroundGrey,
                    borderColor = BackgroundGrey,
                    imageVector = ImageVector.vectorResource(id = R.drawable.icon_next),
                    onClickButton = {
                        navController.navigate(Screen.Advantages.route)
                    },
                    iconChecked = if (adantagesType.isNullOrEmpty()) null else ImageVector.vectorResource(
                        id = R.drawable.ic_check
                    )
                )
            }

            item {
                ButtonCustom(
                    iconModifier = iconModifier,
                    text = stringResource(
                        id = R.string.next
                    ),
                    backgroundColor = if (enabledButton) Orange else ButtonDisabled,
                    borderColor = if (enabledButton) Orange else ButtonDisabled,
                    textColor = if (enabledButton) Color.Black else Color.White,
                    positionText = TextAlign.Center,
                    onClickButton = {
                        if (enabledButton) {
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
