package com.example.lockedin.ui.features.homescreen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lockedin.ui.theme.GreyishWhitish
import com.example.lockedin.ui.theme.TransparentGreyishWhitish13
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun Dates() {
    val currentDate = LocalDate.now()
    val startDate = currentDate.minusYears(2)
    val endDate = currentDate.plusYears(2)
    val daysRange = (-30..30).map { currentDate.plusDays(it.toLong()) }
    val listState = rememberLazyListState(initialFirstVisibleItemIndex = 30,
        initialFirstVisibleItemScrollOffset = 10)

    LazyRow(state = listState) {
        items(daysRange) { date ->
            Card(
                modifier = Modifier
                    .padding(horizontal = 6.dp)
                    .padding(top = 40.dp)
                    .height(if (currentDate == date) 85.dp else 65.dp)
                    .offset(y = if (currentDate == date) 0.dp else 10.dp)
                    .width(53.dp)
                    .border(0.8.dp, Color.DarkGray, RoundedCornerShape(30.dp)),
                shape = RoundedCornerShape(30.dp),
                colors = if (currentDate == date)
                    CardDefaults.cardColors() else CardDefaults.cardColors(
                    TransparentGreyishWhitish13
                )
            ) {
                var currentDateText by remember { mutableStateOf("") }
                var currentDayText by remember { mutableStateOf("") }

                val dayFormatter = DateTimeFormatter.ofPattern("E", Locale.getDefault())
                val dateFormatter = DateTimeFormatter.ofPattern("d", Locale.getDefault())

                currentDateText = currentDate.format(dateFormatter)
                currentDayText = currentDate.format(dayFormatter)

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        date.dayOfMonth.toString(),
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                    )
                    Spacer(Modifier.height(1.dp))

                    Text(
                        date.dayOfWeek.name.take(3).lowercase().replaceFirstChar { it.uppercase() },
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 12.sp,
                            color = GreyishWhitish
                        )
                    )
                }
            }
        }
    }

}