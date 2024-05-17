package com.example.login.presentation.model

/**
 * Created by Sanaz Ahang on 06,May,2024
 */
data class LoginState(
    val loginModel: LoginUiModel = LoginUiModel(),
    val loading: Boolean = false,
    val errorMessage: String? = null
)


