package com.example.login.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.login.R
import com.example.login.presentation.customeViews.RegisterForm
import com.example.login.presentation.model.LoginEvent
import com.example.login.presentation.model.LoginState
import com.example.login.presentation.model.LoginUiModel
import com.example.login.presentation.model.UserData
import com.example.login.presentation.model.UserInputFiled

/**
 * Created by Sanaz Ahang on 24,April,2024
 */

@Composable
internal fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    LoginLayout(state = state, modifier = modifier, viewModel)
}


@Composable
fun LoginLayout(
    state: LoginState,
    modifier: Modifier,
    viewModel: LoginViewModel
) {
    val focusManager = LocalFocusManager.current


    if (state.loading)
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()

        ) {
            Image(
                painter = painterResource(id = R.drawable.recipebook),
                contentDescription = stringResource(id = R.string.recipe_content)
            )
            RegisterForm(
                email = state.loginModel.email.value,
                firstName = state.loginModel.firstName.value,
                lastName = state.loginModel.lastName.value,
                userName = state.loginModel.userName.value,
                onEmailChange = {
                    if (it.length >= 5)
                        viewModel.sendEvent(LoginEvent.UiError("******", UserInputFiled.EMAIL))
                },
                onFirstNameChange = {
                    if (it.length >= 5)
                        viewModel.sendEvent(LoginEvent.UiError("******", UserInputFiled.FIRSTNAME))
                },
                onLastNameChange = {
                    if (it.length >= 5)
                        viewModel.sendEvent(LoginEvent.UiError("******", UserInputFiled.LASTNAME))
                },
                onUserNameChange = {

                    if (it.length >= 5)
                        viewModel.sendEvent(LoginEvent.UiError("******", UserInputFiled.USERNAME))
                },
                firstNameValidation = {
                    if (!it.contains("[0-9]".toRegex())) {
//                         if (it.length >= 5)
                        viewModel.sendEvent(LoginEvent.UiError("******", UserInputFiled.USERNAME))
                    }
                },
                lastNameValidation = {
                    if (it.length < 10) {
                        viewModel.sendEvent(LoginEvent.UiError("******", UserInputFiled.USERNAME))
                    }
                },
                userNameValidation = {
                    if (it.length < 10) {
                        viewModel.sendEvent(LoginEvent.UiError("******", UserInputFiled.USERNAME))
                        viewModel.sendEvent(LoginEvent.UiError("******", UserInputFiled.USERNAME))
                    }
                },
                emailValidation = {
                    if (it.length < 10) {
                        viewModel.sendEvent(LoginEvent.UiError("******", UserInputFiled.USERNAME))
                    }
                },

                firstNameIsError = state.loginModel.firstName.isError,
                lastNameIsError = state.loginModel.lastName.isError,
                userNameIsError = state.loginModel.userName.isError,
                emailIsError = state.loginModel.email.isError,
                firstNameErrorMessage = state.loginModel.firstName.errorMessage,
                lastNameErrorMessage = state.loginModel.lastName.errorMessage,
                userNameErrorMessage = state.loginModel.userName.errorMessage,
                emailErrorMessage = state.loginModel.email.errorMessage,
                focusManager = focusManager,
                onRegisterClick = {
                    viewModel.sendEvent(
                        LoginEvent.Register(
                            LoginUiModel(
                                email = UserData(state.loginModel.email.value),
                                firstName = UserData(state.loginModel.firstName.value),
                                lastName = UserData(state.loginModel.lastName.value),
                                userName = UserData(state.loginModel.userName.value)
                            )
                        )
                    )
                }

            )
        }


}


@Preview(showBackground = true)
@Composable
fun PreView() {
//    LoginLayout()
}

