package com.example.scoresaver.presentation.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.scoresaver.R

@Composable
fun getImageFromVector(value: Int): ImageVector {
    return when(value) {
        1 -> ImageVector.vectorResource(id = R.drawable.ic_1)
        2 -> ImageVector.vectorResource(id = R.drawable.ic_2)
        3 -> ImageVector.vectorResource(id = R.drawable.ic_3)
        4 -> ImageVector.vectorResource(id = R.drawable.ic_4)
        else -> ImageVector.vectorResource(id = R.drawable.ic_1)
    }

}