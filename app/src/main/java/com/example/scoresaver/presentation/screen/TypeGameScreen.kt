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
import androidx.compose.ui.unit.dp
import com.example.scoresaver.R
import com.example.scoresaver.presentation.theme.BackgroundGrey
import com.example.scoresaver.presentation.ui.widget.ButtonCustom
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

    when (loadTypeGame) {
        "single" -> {
            stateSingleGame = true
            stateDoubleGame = false
        }
        "double" -> {
            stateSingleGame = false
            stateDoubleGame = true
        }
        else -> {
            stateSingleGame = false
            stateDoubleGame = false
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
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
                    "single"
                )
                null
            },
            imageVector = if (stateSingleGame) ImageVector.vectorResource(id = R.drawable.ic_check) else null,
            roundedShape = 5
        )
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
                    "double"
                )
                null
            },
            imageVector = if (stateDoubleGame) ImageVector.vectorResource(id = R.drawable.ic_check) else null,
            roundedShape = 5
        )
    }
}