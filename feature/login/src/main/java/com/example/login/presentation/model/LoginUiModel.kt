package com.example.login.presentation.model

/**
 * Created by Sanaz Ahang on 29,April,2024
 */
data class LoginUiModel(
    val firstName: UserData = UserData(),
    val lastName: UserData = UserData(),
    val userName: UserData = UserData(),
    val email: UserData = UserData()
)

data class UserData(
    val value: String = "",
    val isError: Boolean = false,
    val errorMessage: String = ""
)

