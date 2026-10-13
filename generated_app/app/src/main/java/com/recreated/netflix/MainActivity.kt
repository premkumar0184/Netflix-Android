package com.recreated.netflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.recreated.netflix.navigation.AppNavigation
import com.recreated.netflix.theme.NetflixAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NetflixAppTheme {
                AppNavigation()
            }
        }
    }
}
