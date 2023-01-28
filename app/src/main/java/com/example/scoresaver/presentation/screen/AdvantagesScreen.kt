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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Text
import com.example.scoresaver.R
import com.example.scoresaver.presentation.theme.BackgroundGrey
import com.example.scoresaver.presentation.ui.widget.ButtonCustom
import com.example.scoresaver.presentation.util.SETTINGS_TYPE
import com.example.scoresaver.presentation.util.WidgetSharedPrefsUtil

@Composable
fun AdvantagesScreen() {

    val context = LocalContext.current
    val iconModifier = Modifier
        .padding(end = 10.dp)
        .size(12.dp)

    val adavtangesType = WidgetSharedPrefsUtil.loadPreferences(
        context,
        settingsType = SETTINGS_TYPE.TYPE_ADVANTAGES.value
    )

    var stateAvClassic by remember {
        mutableStateOf(false)
    }

    var stateAvKiller by remember {
        mutableStateOf(false)
    }

    when (adavtangesType) {
        "classic" -> {
            stateAvClassic = true
            stateAvKiller = false
        }
        "killer" -> {
            stateAvClassic = false
            stateAvKiller = true
        }
        else -> {
            stateAvClassic = false
            stateAvKiller = false
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ButtonCustom(
            text = stringResource(id = R.string.advantages),
            borderColor = BackgroundGrey,
            backgroundColor = BackgroundGrey,
            textColor = Color.White,
            iconModifier = iconModifier,
            onClickButton = {
                stateAvKiller = false
                stateAvClassic = !stateAvClassic
                WidgetSharedPrefsUtil.savePreferencesInfo(
                    context,
                    settingsType = SETTINGS_TYPE.TYPE_ADVANTAGES.value,
                    "classic"
                )
                null
            },
            imageVector = if (stateAvClassic) ImageVector.vectorResource(id = R.drawable.ic_check) else null,
            roundedShape = 5
        )
        ButtonCustom(
            text = stringResource(id = R.string.killer_text),
            borderColor = BackgroundGrey,
            backgroundColor = BackgroundGrey,
            textColor = Color.White,
            iconModifier = iconModifier,
            onClickButton = {
                stateAvClassic = false
                stateAvKiller = !stateAvKiller
                WidgetSharedPrefsUtil.savePreferencesInfo(
                    context,
                    settingsType = SETTINGS_TYPE.TYPE_ADVANTAGES.value,
                    "killer"
                )
                null
            },
            imageVector = if (stateAvKiller) ImageVector.vectorResource(id = R.drawable.ic_check) else null,
            roundedShape = 5
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            text = stringResource(id = R.string.description_killer_point),
            color = Color.White,
            style = TextStyle(
                fontSize = 10.sp
            )
        )
    }

}