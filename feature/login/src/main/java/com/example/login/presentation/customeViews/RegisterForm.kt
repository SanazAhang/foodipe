package com.example.login.presentation.customeViews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.login.R

@Composable
fun RegisterForm(
    firstName: String,
    lastName: String,
    userName: String,
    email: String,
    firstNameIsError: Boolean,
    lastNameIsError: Boolean,
    userNameIsError: Boolean,
    emailIsError: Boolean,
    firstNameErrorMessage: String,
    lastNameErrorMessage: String,
    userNameErrorMessage: String,
    emailErrorMessage: String,
    onEmailChange: (String) -> Unit,
    onFirstNameChange: (String) -> Unit,
    onLastNameChange: (String) -> Unit,
    onUserNameChange: (String) -> Unit,
    onRegisterClick: () -> Unit,
    emailValidation: (String) -> Unit,
    firstNameValidation: (String) -> Unit,
    lastNameValidation: (String) -> Unit,
    userNameValidation: (String) -> Unit,
    focusManager: FocusManager

) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
    ) {
        CustomTextFiled(
            label = stringResource(id = R.string.first_name),
            onValueChange = onFirstNameChange,
            value = firstName,
            iconId = R.drawable.user_light,
            validation = firstNameValidation,
            isError = firstNameIsError,
            errorMessage = firstNameErrorMessage,
        )
        CustomTextFiled(
            label = stringResource(id = R.string.last_name),
            onValueChange = onLastNameChange,
            value = lastName,
            iconId = R.drawable.user_light,
            validation = lastNameValidation,
            isError = lastNameIsError,
            errorMessage = lastNameErrorMessage

        )
        CustomTextFiled(
            label = stringResource(id = R.string.user_name),
            onValueChange = onUserNameChange,
            value = userName,
            iconId = R.drawable.user_light,
            validation = userNameValidation,
            isError = userNameIsError,
            errorMessage = userNameErrorMessage

        )
        CustomTextFiled(
            label = stringResource(id = R.string.email),
            onValueChange = onEmailChange,
            value = email,
            iconId = R.drawable.envelope_light,
            validation = emailValidation,
            isError = emailIsError,
            errorMessage = emailErrorMessage

        )
        Spacer(modifier = Modifier.height(40.dp))
        CustomLoginElevatedButton(
            onClick = onRegisterClick,
            name = stringResource(id = R.string.register)
        )
    }
}

