package com.example.scoresaver.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.OutlinedButton
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.ScalingLazyColumn
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.Vignette
import androidx.wear.compose.material.VignettePosition
import androidx.wear.compose.material.rememberScalingLazyListState
import com.example.scoresaver.R
import com.example.scoresaver.presentation.theme.ButtonDisabled
import com.example.scoresaver.presentation.theme.GreenLight
import com.example.scoresaver.presentation.theme.Orange
import com.example.scoresaver.presentation.theme.RedButton
import com.example.scoresaver.presentation.util.Constants
import com.example.scoresaver.presentation.util.SETTINGS_TYPE
import com.example.scoresaver.presentation.util.WidgetSharedPrefsUtil

@Composable
fun StartGameScreen() {

    val context = LocalContext.current

    val listService = WidgetSharedPrefsUtil.loadOrderServiceList(
        context = LocalContext.current,
        settingsType = SETTINGS_TYPE.ORDER_SERVICE_LIST.value
    )

    var advantagesType = WidgetSharedPrefsUtil.loadPreferences(
        context,
        settingsType = SETTINGS_TYPE.TYPE_ADVANTAGES.value
    )
    val listState = rememberScalingLazyListState()

    val loadTypeGame = WidgetSharedPrefsUtil.loadPreferences(
        context,
        settingsType = SETTINGS_TYPE.TYPE_GAME.value
    )

    var isKiller by remember {
        mutableStateOf(false)
    }

    if (advantagesType == Constants.KILLER)
        isKiller = true


    var pointsA by remember {
        mutableStateOf("0")
    }

    var pointsB by remember {
        mutableStateOf("0")
    }

    var gameA by remember {
        mutableStateOf(0)
    }

    var gameB by remember {
        mutableStateOf(0)
    }

    var setA by remember {
        mutableStateOf(0)
    }

    var setB by remember {
        mutableStateOf(0)
    }

    var isTieBreak = false
    var firstPointA = false
    var firstPointB = false

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
            state = listState
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement =
                    if (loadTypeGame == Constants.DOUBLE) Arrangement.SpaceAround else Arrangement.Center
                ) {
                    if (loadTypeGame == Constants.DOUBLE) {
                        OutlinedButton(
                            modifier = Modifier.size(30.dp),
                            onClick = { },
                            border = ButtonDefaults.outlinedButtonBorder(borderColor = Color.White),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(start = 4.dp),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .padding(top = 2.dp)
                                        .size(8.dp),
                                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_ball),
                                    contentDescription = null,
                                    tint = Color.White
                                )
                                Spacer(modifier = Modifier.padding(end = 2.dp))
                                Text(
                                    modifier = Modifier.size(12.dp),
                                    text = "2",
                                    color = Color.White,
                                    fontSize = 10.sp
                                )
                            }
                        }
                    }

                    Button(
                        modifier = Modifier.size(30.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = if (isKiller) Orange else ButtonDisabled
                        ),
                        onClick = {
                            isKiller = !isKiller
                        },
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(15.dp),
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_killer_icon),
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }


                }
            }
            item {
                Spacer(modifier = Modifier.padding(top = 2.dp))
            }
            item {
                Icon(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .fillMaxSize(),
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_stroke_white),
                    contentDescription = null,
                    tint = Color.White
                )
            }
            item {
                Row(
                    modifier =
                    Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        modifier = Modifier
                            .padding(start = 15.dp)
                            .size(20.dp),
                        text = pointsA,
                        color = Color.White,
                        fontSize = 15.sp
                    )

                    Text(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .size(20.dp),
                        text = "-",
                        color = Color.White,
                        fontSize = 15.sp
                    )

                    Text(
                        modifier = Modifier
                            .padding(end = 14.dp)
                            .size(20.dp),
                        text = pointsB,
                        color = Color.White,
                        fontSize = 15.sp
                    )
                }
            }
            item {
                Row(
                    modifier =
                    Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    val recapA = "$setA-$gameA"
                    Text(
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .size(12.dp),
                        text = recapA,
                        color = Color.White,
                        fontSize = 8.sp
                    )

                    val recapB = "$setB-$gameB"
                    Text(
                        modifier = Modifier
                            .padding(start = 6.dp)
                            .size(12.dp),
                        text = "$recapB",
                        color = Color.White,
                        fontSize = 8.sp
                    )
                }
            }
            item {
                Icon(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .fillMaxSize(),
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_stroke_white),
                    contentDescription = null,
                    tint = Color.White
                )
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Button(
                        modifier = Modifier.size(40.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Orange
                        ),
                        onClick = {
                            if (gameA == 6 && gameB == 6) {
                                isTieBreak = true
                            } else {
                                when (pointsA) {
                                    "0" -> {
                                        pointsA = "15"
                                    }

                                    "15" -> {
                                        pointsA = "30"
                                    }

                                    "30" -> {
                                        pointsA = "40"
                                    }

                                    "40" -> {
                                        when (pointsB) {
                                            "40" -> {
                                                if (isKiller) {
                                                    pointsA = "0"
                                                    pointsB = "0"
                                                    when (gameA) {
                                                        0, 1, 2, 3, 4 -> {
                                                            gameA++
                                                        }

                                                        5 -> {
                                                            when (gameB) {
                                                                5, 6 -> {
                                                                    gameA++
                                                                }

                                                                else -> {
                                                                    gameA = 0
                                                                    gameB = 0
                                                                    setA++
                                                                }
                                                            }
                                                        }

                                                        6 -> {
                                                            when (gameB) {
                                                                5 -> {
                                                                    gameA = 0
                                                                    gameB = 0
                                                                    setA++
                                                                }

                                                                6 -> {
                                                                    isTieBreak = true
                                                                    firstPointA = true
                                                                    firstPointB = false
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    pointsA = "A"
                                                }
                                            }

                                            "A" -> {
                                                pointsB = "40"
                                            }

                                            else -> {
                                                pointsA = "0"
                                                pointsB = "0"
                                                when (gameA) {
                                                    0, 1, 2, 3, 4 -> {
                                                        gameA++
                                                    }

                                                    5 -> {
                                                        when (gameB) {
                                                            5, 6 -> {
                                                                gameA++
                                                            }

                                                            else -> {
                                                                gameA = 0
                                                                gameB = 0
                                                                setA++
                                                            }
                                                        }
                                                    }

                                                    6 -> {
                                                        when (gameB) {
                                                            5 -> {
                                                                gameA = 0
                                                                gameB = 0
                                                                setA++
                                                            }

                                                            6 -> {
                                                                isTieBreak = true
                                                                firstPointA = true
                                                                firstPointB = false
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    "A" -> {
                                        pointsA = "0"
                                        pointsB = "0"
                                        when (gameA) {
                                            0, 1, 2, 3, 4 -> {
                                                gameA++
                                            }

                                            5 -> {
                                                when (gameB) {
                                                    5, 6 -> {
                                                        gameA++
                                                    }

                                                    else -> {
                                                        gameA = 0
                                                        gameB = 0
                                                        setA++
                                                    }
                                                }
                                            }

                                            6 -> {
                                                when (gameB) {
                                                    5 -> {
                                                        gameA = 0
                                                        gameB = 0
                                                        setA++
                                                    }

                                                    6 -> {
                                                        isTieBreak = true
                                                        firstPointA = true
                                                        firstPointB = false
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                            }
                            if (isTieBreak) {
                                pointsA = when (pointsA) {
                                    "0" -> {
                                        if (firstPointA) {
                                            firstPointA = false
                                            "0"
                                        } else {
                                            "1"
                                        }
                                    }

                                    "1" -> "2"
                                    "2" -> "3"
                                    "3" -> "4"
                                    "4" -> "5"
                                    "5" -> "6"
                                    "6" -> {
                                        gameA = 0
                                        gameB = 0
                                        setA++
                                        isTieBreak = false
                                        pointsB = "0"
                                        "0"
                                    }

                                    else -> {
                                        gameA = 0
                                        gameB = 0
                                        isTieBreak = false
                                        pointsB = "0"
                                        "0"
                                    }

                                }
                            }

                        },
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(13.dp),
                            text = stringResource(id = R.string.team_1),
                            color = Color.Black,
                            fontSize = 8.sp,
                            textAlign = TextAlign.Center
                        )
                    }

                    Button(
                        modifier = Modifier.size(40.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = GreenLight
                        ),
                        onClick = {
                            if (gameA == 6 && gameB == 6) {
                                isTieBreak = true
                            } else {
                                when (pointsB) {
                                    "0" -> {
                                        pointsB = "15"
                                    }

                                    "15" -> {
                                        pointsB = "30"
                                    }

                                    "30" -> {
                                        pointsB = "40"
                                    }

                                    "40" -> {
                                        when (pointsA) {
                                            "40" -> {
                                                if (isKiller) {
                                                    pointsA = "0"
                                                    pointsB = "0"
                                                    when (gameB) {
                                                        0, 1, 2, 3, 4 -> {
                                                            gameB++
                                                        }

                                                        5 -> {
                                                            when (gameA) {
                                                                5, 6 -> {
                                                                    gameB++
                                                                }

                                                                else -> {
                                                                    gameA = 0
                                                                    gameB = 0
                                                                    setB++
                                                                }
                                                            }
                                                        }

                                                        6 -> {
                                                            when (gameA) {
                                                                5 -> {
                                                                    gameA = 0
                                                                    gameB = 0
                                                                    setB++
                                                                }

                                                                6 -> {
                                                                    isTieBreak = true
                                                                    firstPointA = false
                                                                    firstPointB = true
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    pointsB = "A"
                                                }
                                            }

                                            "A" -> {
                                                pointsA = "40"
                                            }

                                            else -> {
                                                pointsA = "0"
                                                pointsB = "0"
                                                when (gameB) {
                                                    0, 1, 2, 3, 4 -> {
                                                        gameB++
                                                    }

                                                    5 -> {
                                                        when (gameA) {
                                                            5, 6 -> {
                                                                gameB++
                                                            }

                                                            else -> {
                                                                gameA = 0
                                                                gameB = 0
                                                                setB++
                                                            }
                                                        }
                                                    }

                                                    6 -> {
                                                        when (gameA) {
                                                            5 -> {
                                                                gameA = 0
                                                                gameB = 0
                                                                setB++
                                                            }

                                                            6 -> {
                                                                isTieBreak = true
                                                                firstPointA = false
                                                                firstPointB = true
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    "A" -> {
                                        pointsA = "0"
                                        pointsB = "0"
                                        when (gameB) {
                                            0, 1, 2, 3, 4 -> {
                                                gameB++
                                            }

                                            5 -> {
                                                when (gameA) {
                                                    5, 6 -> {
                                                        gameB++
                                                    }

                                                    else -> {
                                                        gameA = 0
                                                        gameB = 0
                                                        setB++
                                                    }
                                                }
                                            }

                                            6 -> {
                                                when (gameA) {
                                                    5 -> {
                                                        gameA = 0
                                                        gameB = 0
                                                        setB++
                                                    }

                                                    6 -> {
                                                        isTieBreak = true
                                                        firstPointA = false
                                                        firstPointB = true
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (isTieBreak) {
                                pointsB = when (pointsB) {
                                    "0" -> {
                                        if (firstPointB) {
                                            firstPointB = firstPointA
                                            "0"
                                        } else {
                                            "1"
                                        }
                                    }

                                    "1" -> "2"
                                    "2" -> "3"
                                    "3" -> "4"
                                    "4" -> "5"
                                    "5" -> "6"
                                    "6" -> {
                                        setB++
                                        gameA = 0
                                        gameB = 0
                                        isTieBreak = false
                                        pointsA = "0"
                                        "0"
                                    }

                                    else -> {
                                        gameA = 0
                                        gameB = 0
                                        isTieBreak = false
                                        pointsA = "0"
                                        "0"
                                    }

                                }
                            }
                        },
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(13.dp),
                            text = stringResource(id = R.string.team_2),
                            color = Color.Black,
                            fontSize = 8.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier.size(35.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = RedButton
                        ),
                        onClick = { /* ... */ },
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(15.dp)
                                .clickable {
                                },
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_go_back_point),
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                }
            }

        }
    }
}

