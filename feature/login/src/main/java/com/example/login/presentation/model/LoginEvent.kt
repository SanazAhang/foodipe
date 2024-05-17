package com.example.login.presentation.model

/**
 * Created by Sanaz Ahang on 06,May,2024
 */
sealed class LoginEvent {
    data object Idle : LoginEvent()
    data class Register(val data: LoginUiModel) : LoginEvent()
}