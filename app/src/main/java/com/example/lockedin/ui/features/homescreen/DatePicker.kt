package com.example.lockedin.ui.features.homescreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun DatePicker() {
    var initialList by remember { mutableStateOf((0..30).toList<Int>()) }
    val newList = (1..30).map { initialList.last() + it}
    val state = rememberLazyListState()

    LaunchedEffect(state.firstVisibleItemIndex) {
        if (state.firstVisibleItemIndex == state.layoutInfo.totalItemsCount - 11) {
            initialList =  initialList + newList
        }
    }

    LazyRow(state = state) {
        items(initialList) { item ->
            Card(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 30.dp)
                    .size(30.dp)

            ) {
                Box(Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center) {
                    Text(text = item.toString())
                }
            }
        }
    }
}

@Preview
@Composable
fun DatePickerPreview() {
    DatePicker()
}