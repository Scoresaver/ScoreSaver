package com.example.scoresaver.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.wear.compose.material.*
import com.example.scoresaver.R
import com.example.scoresaver.presentation.MenuViewModel
import com.example.scoresaver.presentation.theme.BackgroundGrey
import com.example.scoresaver.presentation.theme.Orange
import com.example.scoresaver.presentation.theme.UncheckedThumb
import com.example.scoresaver.presentation.theme.UncheckedTrackColor
import com.example.scoresaver.presentation.ui.widget.ButtonCustom

@Composable
fun OrderServiceScreen(
    menuViewModel: MenuViewModel = viewModel()
) {

    val switchValue by menuViewModel.switchOrderService.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp)) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.icon_back),
                modifier = Modifier
                    .padding(start = 16.dp, top = 18.dp)
                    .clickable {
                    },
                contentDescription = "icon button",
                tint = Orange
            )
            Text(
                modifier = Modifier.padding(start = 7.dp, top = 17.dp),
                text = stringResource(id = R.string.order_service),
                color = Orange,
                fontSize = 12.sp
            )
        }
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(33.dp)
                .padding(horizontal = 10.dp),
            shape = RoundedCornerShape(5.dp),
            border = ButtonDefaults.outlinedButtonBorder(BackgroundGrey),
            onClick = {  },
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(BackgroundGrey),
                contentAlignment = Alignment.Center
            )
            {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    text = stringResource(id = com.example.scoresaver.R.string.order_service),
                    color = Color.White,
                    textAlign = TextAlign.Left,
                    style = TextStyle(
                        fontSize = 12.sp
                    )
                )
            }
            Switch(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 10.dp),
                checked = switchValue,
                onCheckedChange = {
                    menuViewModel.setSwitchValue(it)
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Orange,
                    uncheckedThumbColor = UncheckedThumb,
                    checkedTrackColor = UncheckedThumb,
                    uncheckedTrackColor = UncheckedTrackColor
                ),

                )
        }

        if(switchValue) {
            //TODO
        }
    }
}

@Preview
@Composable
fun ButtonPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ButtonCustom("Nuova Partita")
    }
}