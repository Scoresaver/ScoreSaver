package com.example.scoresaver.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.wear.compose.material.Switch
import androidx.wear.compose.material.SwitchDefaults
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.ToggleChip
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

    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.padding(top = 17.dp),
                text = stringResource(id = R.string.order_service),
                color = Orange,
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            )
        }

        ToggleChip(
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

        if (switchValue) {
            //TODO
        }
    }
}