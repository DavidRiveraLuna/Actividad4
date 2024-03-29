package com.example.aritmetica

import android.os.Bundle
import android.text.TextUtils
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aritmetica.ui.theme.AritmeticaTheme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AritmeticaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtimeticScreen()
                }
            }
        }
    }
}

fun checkWroteNumber(text: String): Int {
    if (text.toIntOrNull() != null) {
        return text.toInt()
    } else if (TextUtils.isEmpty(text)) {
        return 0
    }
    return 1
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtimeticScreen() {
    var numberOne: Int by remember { mutableStateOf(0) }
    var numberTwo: Int by remember { mutableStateOf(0) }
    var result: String by remember { mutableStateOf("") }

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = numberOne.toString(),
            onValueChange = {
                numberOne = checkWroteNumber(it)
            },
            label = {
                Text(text = "Escribe un número")
            },
            placeholder = {
                Text(text = "Por favor, escribe un número")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Star, contentDescription = "Icon")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            value = numberTwo.toString(),
            onValueChange = {
                numberTwo = checkWroteNumber(it)
            },
            label = {
                Text(text = "Escribe un número")
            },
            placeholder = {
                Text(text = "Por favor, escribe un número")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Star, contentDescription = "Icon")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

    Spacer(modifier = Modifier.height(16.dp))

    Button(onClick={
        result = (numberOne + numberTwo).toString()
    }){
        Text(text= "Sumar" )
    }


        Button(onClick={
            result = (numberOne - numberTwo).toString()
        }){
            Text(text= "Restar" )
        }

        Button(onClick={
            result = (numberOne * numberTwo).toString()
        }){
            Text(text= "Multiplicar" )
        }

        Button(onClick={
            result = (numberOne / numberTwo).toString()
        }){
            Text(text= "Dividir" )
        }
        Text(text= result )
}
}

@Preview(showBackground = true)
@Composable
fun ArtimeticPreview() {
    AritmeticaTheme {
        ArtimeticScreen()
    }
}