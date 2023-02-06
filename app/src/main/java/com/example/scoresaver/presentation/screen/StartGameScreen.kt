package com.example.scoresaver.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
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
import androidx.wear.compose.material.*
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

    val advantagesType = WidgetSharedPrefsUtil.loadPreferences(
        context,
        settingsType = SETTINGS_TYPE.TYPE_ADVANTAGES.value
    )
    val listState = rememberScalingLazyListState()

    val loadTypeGame = WidgetSharedPrefsUtil.loadPreferences(
        context,
        settingsType = SETTINGS_TYPE.TYPE_GAME.value
    )

    /* Column(Modifier.fillMaxSize(),
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center
     ) {
         Text(text = listService.toString())
     } */

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
                                backgroundColor =  if(advantagesType == Constants.KILLER) Orange else ButtonDisabled
                            ),
                            onClick = {
                            },
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(15.dp)
                                    .clickable {},
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
                    modifier = Modifier.padding(horizontal = 10.dp).fillMaxSize(),
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
                        text = "40",
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
                        text = "40",
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
                    Text(
                        modifier = Modifier.padding(start = 4.dp).
                        size(13.dp),
                        text = "6",
                        color = Color.White,
                        fontSize = 8.sp
                    )

                    Text(
                        modifier = Modifier.padding(start = 6.dp).
                        size(13.dp),
                        text = "4",
                        color = Color.White,
                        fontSize = 8.sp
                    )
                }
            }
            item {
                Icon(
                    modifier = Modifier.padding(horizontal = 10.dp).fillMaxSize(),
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
                        onClick = { /* ... */ },
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
                        onClick = { /* ... */ },
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