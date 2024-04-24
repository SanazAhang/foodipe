package com.example.login.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

/**
 * Created by Sanaz Ahang on 24,April,2024
 */

@Composable
fun LoginScreen(name: String) {
    Text(
        text = "This is Login Screen!  ${name}",
    )
}