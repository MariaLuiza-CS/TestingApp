package com.example.testingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import com.example.testingapp.ui.theme.TestingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestingAppTheme {
                ButtonAdd(Color.Magenta)
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ButtonAdd(color: Color) {
    Button(
        onClick = { /*TODO*/ },
        content = { ContentButton() },
        modifier = Modifier
            .semantics { testTagsAsResourceId = true }
            .testTag("ButtonAdd"),
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        )
    )
}

@Composable
fun ContentButton() {
    Text(
        modifier = Modifier.testTag("TextAdd"),
        text = "Add"
    )
    Icon(
        modifier = Modifier.testTag("AddIcon"),
        imageVector = Icons.Default.Add,
        contentDescription = "Add Icon"
    )
}
