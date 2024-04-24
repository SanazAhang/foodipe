package com.example.foodipe.ui.helper

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.staticCompositionLocalOf

/**
 * Created by Sanaz Ahang on 24,April,2024
 */


var LocalSnackBarHost = staticCompositionLocalOf<SnackbarHostState> {
    error("Local SnackBarHost Not Provided!")
}