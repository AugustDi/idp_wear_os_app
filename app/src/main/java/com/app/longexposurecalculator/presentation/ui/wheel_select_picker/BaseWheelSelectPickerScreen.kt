package com.app.longexposurecalculator.presentation.ui.wheel_select_picker

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Picker
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.rememberPickerState
import org.koin.androidx.compose.koinViewModel

@Composable
fun BaseWheelSelectPickerScreen(
    viewModel: BaseWheelSelectPickerViewModel = koinViewModel(),
) {

    BaseWheelSelectPickerContent()
}

@Composable
private fun BaseWheelSelectPickerContent(

) {
    Scaffold {
        val items = listOf("One", "Two", "Three", "Four", "Five")
        val state = rememberPickerState(items.size)
        val contentDescription by remember { derivedStateOf { "${state.selectedOption + 1}" } }
        Box(
            modifier = Modifier.fillMaxSize().safeDrawingPadding(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.align(Alignment.TopCenter).padding(top = 16.dp),
                text = "Selected: ${items[state.selectedOption]}"
            )
            Picker(
                modifier = Modifier.size(100.dp, 100.dp),
                state = state,
                contentDescription = contentDescription,
            ) {
                Text(items[it])
            }
        }
    }
}