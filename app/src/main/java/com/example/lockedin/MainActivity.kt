package com.example.lockedin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.compose.rememberNavController
import com.example.lockedin.ui.navigation.AppNavHost
import com.example.lockedin.ui.navigation.AppNavigationBar
import com.example.lockedin.ui.theme.LockedInTheme
import android.os.Build
import android.view.View
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.WindowInsets
//import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        hideSystemBars()
        setContent {
            LockedInTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainApp()
                }

            }
        }
    }
//    private fun hideSystemBars() {
//        val windowInsetsController =
//            WindowCompat.getInsetsController(window, window.decorView)
//        // Configure the behavior of the hidden system bars
//        windowInsetsController.systemBarsBehavior =
//            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
//
//        // Hide both the status bar and the navigation bar
//        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
//    }
//
//    // Optional: If you want to reshow them based on some condition or user action later
//    private fun showSystemBars() {
//        val windowInsetsController =
//            WindowCompat.getInsetsController(window, window.decorView)
//        windowInsetsController.show(WindowInsetsCompat.Type.systemBars())
//    }

}

@Composable
fun MainApp() {
    val navController = rememberNavController()
    val systemBarHeight = WindowInsets.navigationBars.asPaddingValues()
    val bottomPadding = systemBarHeight.calculateBottomPadding()

    Scaffold(
        containerColor = Color.Transparent,
        bottomBar = { AppNavigationBar(navController, bottomPadding) }
    ){ innerPadding ->
        AppNavHost(navController, innerPadding)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LockedInTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainApp()
        }

    }
}



