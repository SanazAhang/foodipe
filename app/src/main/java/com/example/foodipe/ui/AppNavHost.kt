package com.example.foodipe.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.foodipe.Greeting
import com.example.foodipe.ui.helper.LocalNavigationController
import com.example.login.navigation.loginScreen
import com.example.login.navigation.navigateToLogin

/**
 * Created by Sanaz Ahang on 24,April,2024
 */

@Composable
fun AppNavHost(
    appState: AppState,
    modifier: Modifier = Modifier,
    startDestination: String = "greeting"
) {
    val navController = appState.navController

    CompositionLocalProvider(LocalNavigationController provides navController) {

        NavHost(navController = navController, startDestination = startDestination) {
            greetingScreen {
                navController.navigateToLogin(it)
            }
            loginScreen()

        }
    }
}

fun NavGraphBuilder.greetingScreen(onClick: (name: String) -> Unit) {
    composable("greeting") {
        Greeting("sanaz & Atieh", onClick = {
            onClick(it)
        })
    }
}

