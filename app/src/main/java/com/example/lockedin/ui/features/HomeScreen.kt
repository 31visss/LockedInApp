package com.example.lockedin.ui.features

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    val bumpHeight = with(LocalDensity.current) {25.dp.toPx()}
    val cornerRadius = with(LocalDensity.current) {20.dp.toPx()}
    val bumpWidth = with(LocalDensity.current) {60.dp.toPx()}

    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)) {
        val path = Path().apply {
            moveTo(0f, size.height)
            lineTo(0f, bumpHeight + cornerRadius)
            arcTo(
                rect = Rect(
                    0f,
                    bumpHeight,
                    cornerRadius * 2,
                    bumpHeight + cornerRadius * 2
                ),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )

        }
//            addRoundRect(
//                RoundRect(
//                    left = 0f,
//                    top = bumpHeight,
//                    right = size.width,
//                    bottom = size.height,
//                    topLeftCornerRadius = CornerRadius(cornerRadius, cornerRadius),
//                    topRightCornerRadius = CornerRadius(cornerRadius, cornerRadius),
//                    bottomRightCornerRadius = CornerRadius.Zero, // Straight bottom-right
//                    bottomLeftCornerRadius = CornerRadius.Zero   // St
//                )
//            )
//            moveTo(
//                x = size.width/2 - bumpWidth/2,
//                y = bumpHeight
//            )
//
//            quadraticBezierTo(
//                x1 = size.width/2,
//                y1 = 0f,
//                x2 = size.width/2 + bumpWidth/2,
//                y2 = bumpHeight
//            )
//        }

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

@Preview
@Composable
fun ShapePreview() {
    HomeScreen()
}