package com.example.lockedin.ui.navigation

import android.health.connect.datatypes.HeightRecord
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import kotlin.io.path.Path

class BumpShape(
    private val bumpHeight: Dp,
    private val bumpWidth: Dp,
    private val cornerRadius: Dp
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val bumpHeight = with(density) {bumpHeight.toPx()}
        val bumpWidth = with(density) {bumpWidth.toPx()}
        val cornerRadius = with(density) {cornerRadius.toPx()}

        val path = Path().apply {
            moveTo(-8f, size.height)
            lineTo(0f, bumpHeight + cornerRadius)

            arcTo(
                rect = Rect(
                    -8f,
                    bumpHeight,
                    (cornerRadius * 2) - 8f,
                    bumpHeight + cornerRadius * 2
                ),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )

            lineTo(size.width / 2 - (bumpWidth / 2 + 10), bumpHeight)

            quadraticBezierTo(
                x1 = size.width / 2,
                y1 = 0f,
                x2 = size.width / 2 + (bumpWidth / 2 + 10),
                y2 = bumpHeight
            )

            lineTo(size.width - cornerRadius, bumpHeight)

            arcTo(
                rect = Rect(
                    (size.width - cornerRadius * 2) + 8f,
                    bumpHeight,
                    size.width + 8f,
                    bumpHeight + cornerRadius * 2
                ),
                startAngleDegrees = 270f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )

            lineTo(size.width, size.height)
            lineTo(0f, size.height)
        }

        return Outline.Generic(path)
    }
}

class BorderShape(
    private val bumpHeight: Dp,
    private val bumpWidth: Dp,
    private val cornerRadius: Dp
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val bumpHeight = with(density) {bumpHeight.toPx()}
        val bumpWidth = with(density) {bumpWidth.toPx()}
        val cornerRadius = with(density) {cornerRadius.toPx()}

        val path = Path().apply {
            moveTo(-8f, bumpHeight + cornerRadius)

            arcTo(
                rect = Rect(
                    -8f,
                    bumpHeight,
                    (cornerRadius * 2) - 8f,
                    bumpHeight + cornerRadius * 2
                ),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )

            lineTo(size.width / 2 - (bumpWidth / 2 + 10), bumpHeight)

            quadraticBezierTo(
                x1 = size.width / 2,
                y1 = 0f,
                x2 = size.width / 2 + (bumpWidth / 2 + 10),
                y2 = bumpHeight
            )

            lineTo(size.width - cornerRadius, bumpHeight)

            arcTo(
                rect = Rect(
                    (size.width - cornerRadius * 2) + 8f,
                    bumpHeight,
                    size.width + 8f,
                    bumpHeight + cornerRadius * 2
                ),
                startAngleDegrees = 270f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )

        }

        return Outline.Generic(path)
    }
}