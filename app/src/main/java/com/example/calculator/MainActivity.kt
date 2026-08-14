package com.example.calculator

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.clickable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import com.example.calculator.ui.theme.CalculatorTheme
import androidx.compose.material3.Button
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.Alignment
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                Scaffold(
                    modifier =
                        Modifier.fillMaxSize()
                ) { innerPadding ->
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    var display by remember { mutableStateOf("0") }
    var firstNumber by remember { mutableStateOf("") }
    var operation by remember { mutableStateOf("") }
    var isNewNumber by remember { mutableStateOf(true) }
    var history by remember { mutableStateOf(listOf<String>())}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
Spacer(
        modifier = Modifier.height(180.dp)
    )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(
                    Color(0xFF1E1E1E),
                    RoundedCornerShape(24.dp)
                )
                .padding(20.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            Text(
                text = display,
                color = Color.White,
                fontSize = 52.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                softWrap = false
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(horizontal = 8.dp)
        ) {
            Text(
                text = "History",
                color = Color.LightGray,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )

            history.takeLast(2).forEach { item ->
                Text(
                    text = item,
                    color = Color.Gray,
                    fontSize = 13.sp,
                    maxLines = 1,
                    textAlign =
                        TextAlign.End,
                        modifier =
                            Modifier.fillMaxWidth()
                )
            }
            Text(
                text = "Clear",
                color = Color(0xFFFF9800),
                fontSize = 12.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        history = emptyList()
                    },
                textAlign = TextAlign.End
            )
        }
        Spacer(
                modifier = Modifier.height(20.dp)
                )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            CalculatorButton(
                text = "AC",
                buttonColor = Color(0xFF333333),
                modifier = Modifier.weight(1f),
                onClick = {
                    display = "0"
                    firstNumber = ""
                    operation = ""
                    isNewNumber = true
                }
            )
            CalculatorButton(
                text = "DEL",
                buttonColor = Color(0xFF333333),
                modifier = Modifier.weight(1f),
                onClick = {
                    display = if (display.length > 1) {
                        display.dropLast(1)
                    } else {
                        "0"
                    }
                }
            )

            CalculatorButton(
                text = "%",
                buttonColor = Color(0xFF333333),
                modifier = Modifier.weight(1f),
                onClick = {
                    val number = display.toDoubleOrNull() ?: 0.0
                    display = (number / 100).toString()
                }
            )

            CalculatorButton(
                text = "/",
                buttonColor = Color(0xFFFF9800),
                modifier = Modifier.weight(1f),
                onClick = {
                    firstNumber = display
                    operation = "/"
                    isNewNumber = true
                }
            )
        }
        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            CalculatorButton(
                text = "1",
                buttonColor = Color(0xFF333333),
                modifier = Modifier.weight(1f),
                onClick = {
                    if (isNewNumber) {
                        display = "1"
                        isNewNumber = false
                    } else {
                        display += "1"
                    }
                }
            )

            CalculatorButton(
                text = "2",
                buttonColor = Color(0xFF333333),
                modifier = Modifier.weight(1f),
                onClick = {
                    if (isNewNumber) {
                        display = "2"
                        isNewNumber = false
                    } else {
                        display += "2"
                    }
                }
            )
            CalculatorButton(
                text = "3",
                buttonColor = Color(0xFF333333),
                modifier = Modifier.weight(1f),
                onClick = {
                    if (isNewNumber) {
                        display = "3"
                        isNewNumber = false
                    } else {
                        display += "3"
                    }
                }
            )

            CalculatorButton(
                text = "×",
                buttonColor = Color(0xFFFF9800),
                modifier = Modifier.weight(1f),
                onClick = {
                    firstNumber = display
                    operation = "*"
                    isNewNumber = true
                }
            )
        }
        Spacer(
                modifier = Modifier.height(10.dp)
                )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            CalculatorButton(
                text = "4",
                buttonColor = Color(0xFF333333),
                modifier = Modifier.weight(1f),
                onClick = {
                    if (isNewNumber) {
                        display = "4"
                        isNewNumber = false
                    } else {
                        display += "4"
                    }
                }
            )

            CalculatorButton(
                text = "5",
                buttonColor = Color(0xFF333333),
                modifier = Modifier.weight(1f),
                onClick = {
                    if (isNewNumber) {
                        display = "5"
                        isNewNumber = false
                    } else {
                        display += "5"
                    }
                }
            )
            CalculatorButton(
                text = "6",
                buttonColor = Color(0xFF333333),
                modifier = Modifier.weight(1f),
                onClick = {
                    if (isNewNumber) {
                        display = "6"
                        isNewNumber = false
                    } else {
                        display += "6"
                    }
                }
            )

            CalculatorButton(
                text = "-",
                buttonColor = Color(0xFFFF9800),
                modifier = Modifier.weight(1f),
                onClick = {
                    firstNumber = display
                    operation = "-"
                    isNewNumber = true
                }
            )
        }
        Spacer(
            modifier = Modifier.height(10.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            CalculatorButton(
                text = "7",
                buttonColor = Color(0xFF333333),
                modifier = Modifier.weight(1f),
                onClick = {
                    if (isNewNumber) {
                        display = "7"
                        isNewNumber = false
                    } else {
                        display += "7"
                    }
                }
            )

            CalculatorButton(
                text = "8",
                buttonColor = Color(0xFF333333),
                modifier = Modifier.weight(1f),
                onClick = {
                    if (isNewNumber) {
                        display = "8"
                        isNewNumber = false
                    } else {
                        display += "8"
                    }
                }
            )
            CalculatorButton(
                text = "9",
                buttonColor = Color(0xFF333333),
                modifier = Modifier.weight(1f),
                onClick = {
                    if (isNewNumber) {
                        display = "9"
                        isNewNumber = false
                    } else {
                        display += "9"
                    }
                }
            )

            CalculatorButton(
                text = "+",
                buttonColor = Color(0xFFFF9800),
                modifier = Modifier.weight(1f),
                onClick = {
                    firstNumber = display
                    operation = "+"
                    isNewNumber = true
                }
            )
        }
        Spacer(
            modifier = Modifier.height(10.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            CalculatorButton(
                text = "+/-",
                buttonColor = Color(0xFF333333),
                modifier = Modifier.weight(1f),
                onClick = {
                    if (display != "0") {
                        display = if (display.startsWith("-")) {
                            display.removePrefix("-")
                        } else {
                            "-$display"
                        }
                    }
                }
            )

            CalculatorButton(
                text = "0",
                buttonColor = Color(0xFF333333),
                modifier = Modifier.weight(1f),
                onClick = {
                    if (isNewNumber) {
                        display = "0"
                        isNewNumber = false
                    } else if (display != "0") {
                        display += "0"
                    }
                }
            )
            CalculatorButton(
                text = ".",
                buttonColor = Color(0xFF333333),
                modifier = Modifier.weight(1f),
                onClick = {
                    if (isNewNumber) {
                        display = "0."
                        isNewNumber = false
                    } else if (!display.contains(".")) {
                        display += "."
                    }
                }
            )

            CalculatorButton(
                text = "=",
                buttonColor = Color(0xFFFF9800),
                modifier = Modifier.weight(1f),
                onClick = {
                    val first = firstNumber.toDoubleOrNull() ?: 0.0
                    val second = display.toDoubleOrNull() ?: 0.0

                    val result = when (operation) {
                        "+" -> first + second
                        "-" -> first - second
                        "*" -> first * second
                        "/" -> if (second != 0.0) first / second else 0.0
                        else -> second
                    }

                    display = if (result % 1 == 0.0) {
                        result.toInt().toString()
                    } else {
                        result.toString()
                    }
                    history = history + "$firstNumber" +
                      "$operation $second = $display"
                    isNewNumber = true
                }
            )
        }
        Spacer(
            modifier = Modifier.height(10.dp)
        )
    }
}


@Composable
fun CalculatorButton(
    text: String,
    buttonColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(70.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor
        ),
        contentPadding =
            PaddingValues(0.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium
        )
    }
}


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        CalculatorTheme {
            Greeting()
        }
    }
