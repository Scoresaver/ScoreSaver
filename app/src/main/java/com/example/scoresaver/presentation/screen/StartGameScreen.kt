package com.example.scoresaver.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.wear.compose.material.Text
import com.example.scoresaver.presentation.util.SETTINGS_TYPE
import com.example.scoresaver.presentation.util.WidgetSharedPrefsUtil

@Composable
fun StartGameScreen() {

    val listService = WidgetSharedPrefsUtil.loadOrderServiceList(
        context = LocalContext.current,
        settingsType = SETTINGS_TYPE.ORDER_SERVICE_LIST.value
    )
    Column(Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = listService.toString())
    }
}