package com.example.foodipe.ui.helper

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController

/**
 * Created by Sanaz Ahang on 24,April,2024
 */

var LocalNavigationController = staticCompositionLocalOf<NavHostController> {
    error("Local Navigation Controller Not Provided!")
}