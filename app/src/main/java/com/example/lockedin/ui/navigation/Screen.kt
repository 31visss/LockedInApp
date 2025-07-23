package com.example.lockedin.ui.navigation

import androidx.annotation.Size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.lockedin.R

sealed class Screen(
    val title: String,
    val route: String,
    val iconSize: Dp,
    val isPrecolored: Boolean,
    val unselectedIcon: Int,
    val selectedIcon: Int){
    object Home: Screen(
        "Home",
        "home",
        20.dp,
        false,
        R.drawable.house,
        R.drawable.house_fill)
    object CreateEdit: Screen(
        "Create Edit",
        "create_edit",
        100.dp,
        true,
        R.drawable.house,
        R.drawable.house_fill)
    object UserProfile: Screen("Profile",
        "user_profile",
        20.dp,
        false,
        R.drawable.user,
        R.drawable.user_fill)
}
