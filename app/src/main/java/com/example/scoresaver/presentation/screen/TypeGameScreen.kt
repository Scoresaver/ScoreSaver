package com.example.scoresaver.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.*
import com.example.scoresaver.R
import com.example.scoresaver.presentation.theme.BackgroundGrey
import com.example.scoresaver.presentation.theme.Orange
import com.example.scoresaver.presentation.ui.widget.ButtonCustom
import com.example.scoresaver.presentation.util.Constants
import com.example.scoresaver.presentation.util.SETTINGS_TYPE
import com.example.scoresaver.presentation.util.WidgetSharedPrefsUtil


@Composable
fun TypeGameScreen() {

    val context = LocalContext.current
    val iconModifier = Modifier
        .padding(end = 10.dp)
        .size(12.dp)

    val loadTypeGame = WidgetSharedPrefsUtil.loadPreferences(
        context,
        settingsType = SETTINGS_TYPE.TYPE_GAME.value
    )

    var stateSingleGame by remember {
        mutableStateOf(false)
    }

    var stateDoubleGame by remember {
        mutableStateOf(false)
    }

    val listState = rememberScalingLazyListState()

    when (loadTypeGame) {
        Constants.SINGLE -> {
            stateSingleGame = true
            stateDoubleGame = false
        }
        Constants.DOUBLE -> {
            stateSingleGame = false
            stateDoubleGame = true
        }
        else -> {
            stateSingleGame = false
            stateDoubleGame = false
        }
    }

    Scaffold(
        vignette = {
            Vignette(vignettePosition = VignettePosition.TopAndBottom)
        },
        positionIndicator = {
            PositionIndicator(
                scalingLazyListState = listState
            )
        },
    ) {
        ScalingLazyColumn(
            modifier = Modifier.fillMaxSize(),
            autoCentering = AutoCenteringParams(itemIndex = 2),
            state = listState
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.type_game),
                        color = Orange,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.padding(top = 12.dp))
            }
            item {
                ButtonCustom(
                    text = stringResource(id = R.string.single_game),
                    borderColor = BackgroundGrey,
                    backgroundColor = BackgroundGrey,
                    textColor = Color.White,
                    iconModifier = iconModifier,
                    onClickButton = {
                        stateDoubleGame = false
                        stateSingleGame = !stateSingleGame
                        WidgetSharedPrefsUtil.savePreferencesInfo(
                            context,
                            settingsType = SETTINGS_TYPE.TYPE_GAME.value,
                            Constants.SINGLE
                        )
                        null
                    },
                    imageVector = if (stateSingleGame) ImageVector.vectorResource(id = R.drawable.ic_check) else null
                )
            }
            item {
                ButtonCustom(
                    text = stringResource(id = R.string.double_game),
                    borderColor = BackgroundGrey,
                    backgroundColor = BackgroundGrey,
                    textColor = Color.White,
                    iconModifier = iconModifier,
                    onClickButton = {
                        stateSingleGame = false
                        stateDoubleGame = !stateDoubleGame
                        WidgetSharedPrefsUtil.savePreferencesInfo(
                            context,
                            settingsType = SETTINGS_TYPE.TYPE_GAME.value,
                            Constants.DOUBLE
                        )
                        null
                    },
                    imageVector = if (stateDoubleGame) ImageVector.vectorResource(id = R.drawable.ic_check) else null
                )
            }
        }
    }
}
