package com.example.scoresaver.presentation.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.OutlinedButton
import androidx.wear.compose.material.Text

@Composable
fun ButtonCustom(
    iconModifier: Modifier? = null,
    text: String,
    borderColor: Color = Color.White,
    backgroundColor: Color? = null,
    tintColor: Color = Color.White,
    imageVector: ImageVector? = null,
    onClickButton: (() -> Unit?)? = null,
    positionText: TextAlign = TextAlign.Left,
    textColor: Color = Color.White,
) {
    OutlinedButton(
        onClick = {
            if (onClickButton != null) {
                onClickButton()
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(33.dp)
            .padding(horizontal = 10.dp),
        shape = RoundedCornerShape(15.dp),
        border = ButtonDefaults.outlinedButtonBorder(borderColor = borderColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor ?: Color.Black),
            contentAlignment = Alignment.CenterEnd
        )
        {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                text = text,
                color = textColor,
                textAlign = positionText,
                style = TextStyle(
                    fontSize = 12.sp
                )
            )
            imageVector?.let {
                iconModifier?.let {
                    Icon(
                        imageVector = imageVector,
                        modifier = iconModifier,
                        tint = tintColor,
                        contentDescription = "icon button"
                    )

                }
            }
        }
    }
}