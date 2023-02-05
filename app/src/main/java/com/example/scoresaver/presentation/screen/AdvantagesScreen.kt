package com.example.scoresaver.presentation.screen


import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
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
fun AdvantagesScreen() {

    val context = LocalContext.current
    val iconModifier = Modifier
        .padding(end = 10.dp)
        .size(12.dp)

    val advantagesType = WidgetSharedPrefsUtil.loadPreferences(
        context,
        settingsType = SETTINGS_TYPE.TYPE_ADVANTAGES.value
    )

    var stateAvClassic by remember {
        mutableStateOf(false)
    }

    var stateAvKiller by remember {
        mutableStateOf(false)
    }
    val listState = rememberScalingLazyListState()

    when (advantagesType) {
        Constants.CLASSIC -> {
            stateAvClassic = true
            stateAvKiller = false
        }
        Constants.KILLER -> {
            stateAvClassic = false
            stateAvKiller = true
        }
        else -> {
            stateAvClassic = false
            stateAvKiller = false
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
            autoCentering = AutoCenteringParams(itemIndex = 3),
            state = listState
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.advantages),
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
                    imageVector = if (stateAvClassic) ImageVector.vectorResource(id = R.drawable.ic_check) else null
                )
            }
            item {
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
                    imageVector = if (stateAvKiller) ImageVector.vectorResource(id = R.drawable.ic_check) else null
                )
            }
            item {
                Row {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_warning),
                        modifier = Modifier
                            .padding(start = 12.dp)
                            .size(12.dp),
                        tint = Orange,
                        contentDescription = null
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 5.dp),
                        text = stringResource(id = R.string.description_killer_point),
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 10.sp
                        )
                    )
                }
            }
        }
    }
}