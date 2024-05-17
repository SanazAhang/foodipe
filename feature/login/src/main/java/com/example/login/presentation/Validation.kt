package com.example.login.presentation

import com.example.login.presentation.model.LoginUiModel

/**
 * Created by Sanaz Ahang on 05,May,2024
 */

fun userInputValidation(userInput: LoginUiModel) {
    require(userInput.firstName.value.isEmpty()) {
        return@require "FirstName shouldn't be empty"
    }
    require(userInput.lastName.value.isEmpty()) {
        return@require "LastName shouldn't be empty"
    }
    require(userInput.userName.value.isEmpty()) {
        return@require "Username shouldn't be empty"
    }
    require(userInput.email.value.isEmpty()) {
        return@require "Email shouldn't be empty"
    }

    require(userInput.firstName.value.contains("[0-9]".toRegex())) {
        return@require "FirstName shouldn't contains number "
    }
    require(userInput.firstName.value.contains("[0-9]".toRegex())) {
        return@require "LastName shouldn't contains number "
    }
    require(!android.util.Patterns.EMAIL_ADDRESS.matcher(userInput.email.value).matches()) {
        return@require "Email address is invalid"
    }

}


