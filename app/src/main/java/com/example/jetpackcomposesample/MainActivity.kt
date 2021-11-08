package com.example.jetpackcomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreviewMessageText()
        }
    }
    
    @Composable
    fun MessageText(message: String) {
        Text(text = "Message text: $message")
    }
    
    @Preview
    @Composable
    fun PreviewMessageText() {
        MessageText(message = "Hello World")
    }
}
