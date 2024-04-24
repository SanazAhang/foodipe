package com.example.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.login.presentation.LoginScreen

/**
 * Created by Sanaz Ahang on 24,April,2024
 */
const val LOGIN_ROUTE = "login"
fun NavHostController.navigateToLogin(name: String) = navigate("${LOGIN_ROUTE}/${name}")
fun NavGraphBuilder.loginScreen() {
    composable(route = "${LOGIN_ROUTE}/{name}", arguments = listOf(navArgument("name") {
        type = NavType.StringType
    })) {
        LoginScreen(it.arguments?.getString("name")!!)
    }
}