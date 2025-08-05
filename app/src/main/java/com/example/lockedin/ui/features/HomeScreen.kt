package com.example.lockedin.ui.features

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun HomeScreen() {
    Card(
        modifier = Modifier
            .padding(30.dp)
            .height(72.dp)
            .width(57.dp),
        shape = RoundedCornerShape(30.dp),
        colors = CardDefaults.cardColors(Color.White)
    ){
        var currentDateText by remember{mutableStateOf("")}
        var currentDayText by remember{mutableStateOf("")}

        val currentDate = LocalDate.now()
        val dayFormatter = DateTimeFormatter.ofPattern("E", Locale.getDefault())
        val dateFormatter = DateTimeFormatter.ofPattern("d", Locale.getDefault())

        currentDateText = currentDate.format(dateFormatter)
        currentDayText = currentDate.format(dayFormatter)

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(currentDateText,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 16.sp,
                ))
            Spacer(Modifier.height(2.dp))

            Text(currentDayText,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 14.sp
                ))
        }


    }
}



@Preview
@Composable
fun ShapePreview() {
    HomeScreen()
}