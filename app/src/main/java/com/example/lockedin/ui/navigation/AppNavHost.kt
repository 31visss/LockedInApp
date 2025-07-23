package com.example.lockedin.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lockedin.ui.features.CreateEditScreen
import com.example.lockedin.ui.features.HomeScreen
import com.example.lockedin.ui.features.UserProfile

@Composable
fun AppNavHost(navHostController: NavHostController, innerPadding: PaddingValues) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(Screen.Home.route) { HomeScreen() }
        composable(Screen.CreateEdit.route) { CreateEditScreen() }
        composable(Screen.UserProfile.route) { UserProfile() }

    }
}