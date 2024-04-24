package com.example.foodipe.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.foodipe.ui.helper.LocalSnackBarHost

/**
 * Created by Sanaz Ahang on 24,April,2024
 */
@Composable
fun FoodipeApp(
    windowSizeClass: WindowSizeClass,
    appState: AppState = rememberMarkAppState(windowSizeClass = windowSizeClass)
) {
    val snackbarHostState = remember {
        SnackbarHostState()
    }
    InitLocalSnackBarHost(snackbarHostState = snackbarHostState)

    Scaffold(
        modifier = Modifier,
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        snackbarHost = { SnackbarHost(snackbarHostState) },
        bottomBar = {}
    ) { paddingValues ->
        CompositionLocalProvider(LocalSnackBarHost provides snackbarHostState) {
            AppNavHost(
                appState = appState,
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}

@Composable
private fun InitLocalSnackBarHost(snackbarHostState: SnackbarHostState) {
    LocalSnackBarHost = staticCompositionLocalOf {
        snackbarHostState
    }
}