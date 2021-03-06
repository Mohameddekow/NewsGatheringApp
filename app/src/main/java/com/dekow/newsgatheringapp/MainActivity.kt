package com.dekow.newsgatheringapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import com.dekow.newsgatheringapp.presentation.nav.SetUpHomeNavigation
import com.dekow.newsgatheringapp.ui.theme.NewsGatheringAppTheme
import com.dekow.newsgatheringapp.ui.theme.StatusBarLightModeColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsGatheringAppTheme {
                // A surface container using the 'background' color from the theme
                // A surface container using the 'background' color from the theme

                val darkTheme: Boolean = isSystemInDarkTheme()

                window?.statusBarColor =
                    if (!darkTheme) StatusBarLightModeColor.toArgb() else Color.Black.toArgb()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    //setup app navigation
                    SetUpHomeNavigation()

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewsGatheringAppTheme {

    }
}