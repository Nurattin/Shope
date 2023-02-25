package com.example.onlineshowp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.onlineshowp.ui.theme.OnlineShowpTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnlineShowpTheme() {
                val systemUiController = rememberSystemUiController()
                LaunchedEffect(systemUiController) {
                    systemUiController.setSystemBarsColor(
                        color = Color(0xFFCDCBC7),
                        darkIcons = true
                    )
                    systemUiController.setNavigationBarColor(Color.Black)
                }
                AppScreen()
            }
        }
    }
}