package com.example.lockedin.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.lockedin.R
import com.example.lockedin.ui.theme.LockedInTheme

@Composable
fun NavigationItems(
    icon: Int,
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
    colors: NavigationBarItemColors = NavigationBarItemDefaults.colors()
) {
    Column(
        modifier = Modifier
            .clickable(onClick = onClick,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }),
        horizontalAlignment = Alignment.CenterHorizontally, // << This centers the Icon and Text
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = label,
        )
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = (-0.03).em
            ))

    }

}

@Preview(showBackground = true)
@Composable
fun NavigationItemsPreview() {
    val selected = remember { mutableStateOf(false) }
    LockedInTheme {
        NavigationItems(
            icon = if (!selected.value) R.drawable.house else R.drawable.house_fill,
            label = "Home",
            selected = true,
            onClick = { selected.value = !selected.value },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.DarkGray,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.DarkGray,
                indicatorColor = Color.Transparent,
            )
        )
    }
}