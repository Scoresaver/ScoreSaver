package com.example.scoresaver.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.*

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        StartGame()
    }
}

@Composable
fun StartGame() {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.primary,
        text = "Start Game"
    )
    Spacer(modifier = Modifier.size(10.dp))
    Button(
        modifier = Modifier
            .size(ButtonDefaults.LargeButtonSize)
            .fillMaxWidth(),
        onClick = { /* ... */ },
    ) {
        Icon(
            imageVector = Icons.Rounded.PlayArrow,
            contentDescription = "triggers phone action",
            modifier = Modifier
                .size(30.dp)
        )
    }
}

@Preview
@Composable
fun HomePreview(){
    StartGame()
}
