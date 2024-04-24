package com.example.foodipe.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.foodipe.Greeting
import com.example.foodipe.LoginScreen
import com.example.foodipe.ui.helper.LocalNavigationController

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
                navController.navigate("login/sanaz")
            }

            loginScreen()

        }
    }
}

fun NavGraphBuilder.greetingScreen(onClick: () -> Unit) {
    composable("greeting") {
        Greeting("sanaz", onClick = {
            onClick()
        })
    }
}

fun NavGraphBuilder.loginScreen() {
    composable(route = "login/{name}", arguments = listOf(navArgument("name") {
        type = NavType.StringType
    })) {
        LoginScreen(it.arguments?.getString("name")!!)
    }
}