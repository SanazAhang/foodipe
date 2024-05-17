package com.example.login.presentation

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login.presentation.model.LoginEvent
import com.example.login.presentation.model.LoginState
import com.example.login.presentation.model.LoginUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Sanaz Ahang on 05,May,2024
 */


@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _uiState: MutableStateFlow<LoginState> = MutableStateFlow(LoginState.Idle)
    val uiState: StateFlow<LoginState>
        get() = _uiState

    private val _viewEvents: MutableSharedFlow<LoginEvent> = MutableSharedFlow()

    init {
        viewModelScope.launch {
            _viewEvents.emit(LoginEvent.Idle)
        }

    }

    @VisibleForTesting
    fun updateState(mutation: (currentState: LoginUiModel) -> LoginUiModel) {
//        _uiState.update {
//            mutation.invoke(it)
//        }
    }


    private fun registerUser() {

    }

    fun sendEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.Idle -> {
                _uiState.value = LoginState.Idle
            }

            is LoginEvent.Register -> {
                _uiState.value = LoginState.Loading
                registerUser()
            }
        }
    }

}