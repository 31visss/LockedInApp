package com.example.lockedin.ui.navigation

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.lockedin.R
import com.example.lockedin.ui.theme.LockedInTheme

@Composable
fun NavigationItems(
    icon: Int,
    iconSize: Dp,
    label: String,
    selected: Boolean,
    isEdited: Boolean,
    onClick: () -> Unit,
    colors: NavigationBarItemColors = NavigationBarItemDefaults.colors(),
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .padding(top = 30.dp)
            .clickable(onClick = onClick,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }),
        horizontalAlignment = Alignment.CenterHorizontally, // << This centers the Icon and Text
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier
                .size(iconSize)
                .offset(y = if (isEdited) -10.dp else 0.dp),
            painter = painterResource(id = icon),
            contentDescription = label,
            tint = if (selected) colors.selectedIconColor else colors.unselectedIconColor
        )
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = label,
            color = if (selected) colors.selectedTextColor else colors.unselectedTextColor,
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
            iconSize = 20.dp,
            icon = if (!selected.value) R.drawable.house else R.drawable.house_fill,
            label = "Home",
            selected = true,
            isEdited = true,
            onClick = { selected.value = !selected.value },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.Black,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.Black,
                indicatorColor = Color.Transparent,
            )
        )
    }
}