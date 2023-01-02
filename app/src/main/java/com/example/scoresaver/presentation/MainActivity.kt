/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.scoresaver.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.example.scoresaver.presentation.navigation.SetupNavGraph
import com.example.scoresaver.presentation.theme.ScoreSaverTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScoreSaverTheme {
                val navController = rememberSwipeDismissableNavController()
                SetupNavGraph(navController = navController)
            }
        }

    }
}


