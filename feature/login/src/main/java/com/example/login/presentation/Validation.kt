package com.example.login.presentation

import com.example.login.presentation.model.LoginUiModel

/**
 * Created by Sanaz Ahang on 05,May,2024
 */

fun userInputValidation(userInput: LoginUiModel):Boolean {
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

    return true
}
fun validation(userInput: LoginUiModel):String{
    if(userInput.firstName.value.isEmpty()) {
        return "FirstName shouldn't be empty"
    }
    if(userInput.lastName.value.isEmpty()) {
        return "LastName shouldn't be empty"
    }
    if(userInput.userName.value.isEmpty()) {
        return "Username shouldn't be empty"
    }
    if(userInput.email.value.isEmpty()) {
        return "Email shouldn't be empty"
    }

    if(userInput.firstName.value.contains("[0-9]".toRegex())) {
        return "FirstName shouldn't contains number "
    }
    if(userInput.firstName.value.contains("[0-9]".toRegex())) {
        return "LastName shouldn't contains number "
    }
    if(!android.util.Patterns.EMAIL_ADDRESS.matcher(userInput.email.value).matches()) {
        return "Email address is invalid"
    }
    else
        return "Everything is true"

}


