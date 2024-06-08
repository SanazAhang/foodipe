package com.example.login.presentation

import android.util.Log
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login.presentation.model.LoginEvent
import com.example.login.presentation.model.LoginState
import com.example.login.presentation.model.LoginUiModel
import com.example.login.presentation.model.UserInputFiled
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Sanaz Ahang on 05,May,2024
 */


@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _uiState: MutableStateFlow<LoginState> = MutableStateFlow(LoginState())
    val uiState: StateFlow<LoginState>
        get() = _uiState

    private val _viewEvents: MutableSharedFlow<LoginEvent> = MutableSharedFlow()
    
    @VisibleForTesting
    fun updateState(mutation: (currentState: LoginUiModel) -> LoginUiModel) {
//        _uiState.update {
//            mutation.invoke(it)
//        }
    }


    private fun registerUser(data:LoginUiModel) {
//        if (userInputValidation(data))
            Log.d("LOGIN", validation(data))
//        _uiState.update {
//        }
    }

    private fun handleUiError(errorData: LoginEvent.UiError) {
        when (errorData.inputFiled) {
            UserInputFiled.FIRSTNAME -> {
                _uiState.update {
                    it.copy(
                        loginModel = it.loginModel.copy(
                            firstName = it.loginModel.firstName.copy(
                                isError = true,
                                errorMessage = errorData.errorMessage
                            )
                        )
                    )
                }
            }

            UserInputFiled.LASTNAME -> {
                _uiState.update {
                    it.copy(
                        loginModel = it.loginModel.copy(
                            lastName = it.loginModel.lastName.copy(
                                isError = true,
                                errorMessage = errorData.errorMessage
                            )
                        )
                    )
                }

            }

            UserInputFiled.EMAIL -> {
                _uiState.update {
                    it.copy(
                        loginModel = it.loginModel.copy(
                            email = it.loginModel.email.copy(
                                isError = true,
                                errorMessage = errorData.errorMessage
                            )
                        )
                    )
                }
            }

            UserInputFiled.USERNAME -> {
                _uiState.update {
                    it.copy(
                        loginModel = it.loginModel.copy(
                            userName = it.loginModel.userName.copy(
                                isError = true,
                                errorMessage = errorData.errorMessage
                            )
                        )
                    )
                }
            }
        }

    }

    fun sendEvent(event: LoginEvent) {
        when (event) {

            is LoginEvent.Register -> {
                _uiState.update {
                    it.copy(
                        loading = true
                    )
                }
                registerUser(event.data)
            }

            is LoginEvent.UiError -> {
                handleUiError(event)
            }

            is LoginEvent.TextFieldUpdate -> {
                _uiState.update {
                    it.copy(loginModel = event.model)
                }
            }
        }
    }

}