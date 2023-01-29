package com.example.scoresaver.presentation.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Ballot
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.compose.material.Icon
import com.example.scoresaver.presentation.navigation.Screen
import com.example.scoresaver.presentation.util.SETTINGS_TYPE
import com.example.scoresaver.presentation.util.WidgetSharedPrefsUtil
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(3000)
        navController.popBackStack()
        navController.navigate(Screen.Home.route)

    }
    WidgetSharedPrefsUtil.deletePref(
        LocalContext.current,
        settingsType = SETTINGS_TYPE.TYPE_GAME.value
    )
    WidgetSharedPrefsUtil.deletePref(
        LocalContext.current,
        settingsType = SETTINGS_TYPE.TYPE_ADVANTAGES.value
    )
    WidgetSharedPrefsUtil.deletePref(
        LocalContext.current,
        settingsType = SETTINGS_TYPE.FIRST_VIEW_ORDER_SERVICE.value
    )
    WidgetSharedPrefsUtil.deletePref(
        LocalContext.current,
        settingsType = SETTINGS_TYPE.ORDER_SERVICE.value
    )
    Splash(alpha = alphaAnimation.value)
}

@Composable
fun Splash(alpha: Float) {
    Box(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .size(50.dp)
                .alpha(alpha = alpha),
            imageVector = Icons.Rounded.Ballot,
            contentDescription = "Logo Icon",
            tint = Color.White
        )
    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    Splash(alpha = 1f)
}