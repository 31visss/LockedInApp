package com.example.lockedin.ui.features

import android.R.attr.contentDescription
import android.graphics.Canvas
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.lockedin.R

@Composable
fun HomeScreen() {
    Canvas(modifier = Modifier.fillMaxWidth().height(80.dp)) {
        val path = Path().apply {
            // Start from the far left of the canvas, horizontally centered vertically
            moveTo(0f, 60f)

            // Draw straight line from left to the start of the bump
            lineTo(150f, 60f)

            // First curve: going upward
            cubicTo(
                180f, 60f,     // Control point 1
                180f, 40f,     // Control point 2
                210f, 40f      // End point of first curve
            )

            // Second curve: going downward
            cubicTo(
                240f, 40f,     // Control point 1
                240f, 60f,     // Control point 2
                270f, 60f      // End point of second curve
            )

            // Continue the rest of the line to the end
            lineTo(size.width, 60f)
        }

        drawPath(
            path = path,
            color = Color.White,
            style = Stroke(
                width = 1f,
                cap = StrokeCap.Butt,
                join = StrokeJoin.Round
            )
        )
    }


}
