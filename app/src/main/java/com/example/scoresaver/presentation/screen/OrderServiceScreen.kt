package com.example.scoresaver.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.wear.compose.material.*
import com.example.scoresaver.R
import com.example.scoresaver.presentation.MenuViewModel
import com.example.scoresaver.presentation.theme.Orange
import com.example.scoresaver.presentation.theme.UncheckedThumb
import com.example.scoresaver.presentation.theme.UncheckedTrackColor

@Composable
fun OrderServiceScreen(
    menuViewModel: MenuViewModel = viewModel()
) {

    val switchValue by menuViewModel.switchOrderService.collectAsState()
    val listState = rememberScalingLazyListState()


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
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.order_service),
                        color = Orange,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
            item {
                ToggleChip(
                    enabled = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(33.dp)
                        .padding(horizontal = 10.dp),
                    checked = switchValue,
                    toggleControl = {
                        Switch(
                            checked = switchValue,
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Orange,
                                uncheckedThumbColor = UncheckedThumb,
                                checkedTrackColor = UncheckedThumb,
                                uncheckedTrackColor = UncheckedTrackColor
                            ),
                        )
                    },
                    onCheckedChange = {
                        menuViewModel.setSwitchValue(it)
                    },
                    label = {
                        Text(
                            text = stringResource(id = com.example.scoresaver.R.string.order_service),
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = TextStyle(
                                fontSize = 12.sp
                            )
                        )
                    }
                )
            }
            if (switchValue) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = stringResource(id = R.string.team_1),
                            color = Color.White,
                            fontSize = 12.sp
                        )
                        Text(
                            text = stringResource(id = R.string.team_2),
                            color = Color.White,
                            fontSize = 12.sp,
                        )
                    }
                }
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()

                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(start = 30.dp)
                                .size(15.dp),
                            tint = Color.White,
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_icon),
                            contentDescription = null
                        )
                        Icon(
                            modifier = Modifier
                                .padding(start = 5.dp)
                                .size(15.dp),
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_1),
                            contentDescription = null
                        )
                        Icon(
                            modifier = Modifier
                                .padding(start = 45.dp)
                                .size(15.dp),
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_2),
                            contentDescription = null
                        )
                        Icon(
                            modifier = Modifier
                                .padding(start = 5.dp, end = 30.dp)
                                .size(15.dp),
                            tint = Color.White,
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_icon_not_selected),
                            contentDescription = null
                        )
                    }
                }
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            modifier = Modifier.size(20.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Orange
                            ),
                            onClick = { /* ... */ },
                        ) {
                            Icon(
                                modifier = Modifier.size(10.dp),
                                imageVector = ImageVector.vectorResource(id = R.drawable.ic_left),
                                contentDescription = null,
                                tint = Color.Black
                            )
                        }

                        Button(
                            modifier = Modifier.size(20.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Orange
                            ),
                            onClick = { /* ... */ },
                        ) {
                            Icon(
                                modifier = Modifier.size(10.dp),
                                imageVector = ImageVector.vectorResource(id = R.drawable.ic_right),
                                contentDescription = null,
                                tint = Color.Black
                            )
                        }
                    }
                }
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()

                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(start = 30.dp)
                                .size(15.dp),
                            tint = Color.White,
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_icon_not_selected),
                            contentDescription = null
                        )
                        Icon(
                            modifier = Modifier
                                .padding(start = 5.dp)
                                .size(15.dp),
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_3),
                            contentDescription = null
                        )
                        Icon(
                            modifier = Modifier
                                .padding(start = 45.dp)
                                .size(15.dp),
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_4),
                            contentDescription = null
                        )
                        Icon(
                            modifier = Modifier
                                .padding(start = 5.dp, end = 30.dp)
                                .size(15.dp),
                            tint = Color.White,
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_icon_not_selected),
                            contentDescription = null
                        )
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
                                backgroundColor = Orange
                            ),
                            onClick = { /* ... */ },
                        ) {
                            Icon(
                                modifier = Modifier.size(15.dp),
                                imageVector = ImageVector.vectorResource(id = R.drawable.ic_change_turn),
                                contentDescription = null,
                                tint = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}