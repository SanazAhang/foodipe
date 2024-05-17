package com.example.login.presentation

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


/**
 * Created by Sanaz Ahang on 05,May,2024
 */
@RunWith(JUnit4::class)
class LoginViewModelTest {

    private fun createViewModel() = LoginViewModel()

    @Test
    fun `when view model created then all of inputs must be empty`() {

        //given
        val viewModel = createViewModel()

        //when

        //then
        assert("" == viewModel.uiState.value.email.value)
        assert("" == viewModel.uiState.value.firstName.value)
        assert("" == viewModel.uiState.value.lastName.value)
        assert("" == viewModel.uiState.value.userName.value)

    }

    @Test
    fun `when Register button click then all of inputs must not be empty`() {

        //given

        val viewModel = createViewModel()
        val invalidEmail = ""

        viewModel.updateState {
            it.copy(
                email = it.email.copy(
                    value = invalidEmail
                )
            )
        }

        //when
        viewModel.registerUser()

        //then
        coVerifiy(exact = 0) {
            usecase.invoke(any())
        }

    }

}