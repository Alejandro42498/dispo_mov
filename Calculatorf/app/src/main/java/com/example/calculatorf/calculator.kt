package com.example.calculatorf

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val buttonList = listOf(
    "C", "(", ")", "/",
    "7", "8", "9", "*",
    "4", "5", "6", "+",
    "1", "2", "3", "-",
    "AC", "0", ".", "="
)

@Composable
fun Calculator(modifier: Modifier = Modifier) {
    Box(modifier = modifier.padding(16.dp)) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "987+654",
                style = TextStyle(
                    fontSize = 30.sp,
                    textAlign = TextAlign.End
                ),
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
            )

            Text(
                text = "1641",
                style = TextStyle(
                    fontSize = 50.sp,
                    textAlign = TextAlign.End
                ),
                maxLines = 2,
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(buttonList) {
                    CalculatorButton(btn = it)
                }
            }
        }
    }
}

@Composable
fun CalculatorButton(btn: String) {
    val backgroundColor = when (btn) {
        "C", "AC" -> MaterialTheme.colorScheme.error
        "(", ")", "/", "*", "+", "-", "=" -> MaterialTheme.colorScheme.secondary
        else -> MaterialTheme.colorScheme.primary
    }

    Box(modifier = Modifier.padding(8.dp)) {
        FloatingActionButton(
            onClick = { },
            modifier = Modifier.size(80.dp),
            containerColor = backgroundColor
        ) {
            Text(text = btn, fontSize = 24.sp)
        }
    }
}
