package com.example.login.presentation

import android.view.KeyEvent
import android.view.KeyEvent.ACTION_DOWN
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.login.R
import com.example.login.presentation.model.LoginState

/**
 * Created by Sanaz Ahang on 24,April,2024
 */

@Composable
internal fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    LoginLayout(state = state, modifier = modifier)
}

@Composable
fun LoginLayout(state: LoginState, modifier: Modifier) {
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
//        Spacer(modifier = Modifier.width(12.dp))
            RegisterForm(
                email = state.loginModel.email.value,
                firstName = state.firstName.value,
                lastName = state.lastName.value,
                userName = state.userName.value,
                onEmailChange = {
                    if (it.length <= 10)
                        state = state.copy(
                            email = state.email.copy(
                                value = it
                            )
                        )
                },
                onFirstNameChange = {
                    if (it.length <= 10)
                        state = state.copy(
                            firstName = state.firstName.copy(
                                value = it
                            )
                        )
                },
                onLastNameChange = {
                    if (it.length <= 10)
                        state = state.copy(
                            lastName = state.lastName.copy(
                                value = it
                            )
                        )
                },
                onUserNameChange = {
                    if (it.length <= 10)
                        state = state.copy(
                            userName = state.userName.copy(
                                value = it
                            )
                        )
                },
                firstNameValidation = {
                    if (it.contains("[0-9]".toRegex())) {
                        state = state.copy(
                            firstName = state.firstName.copy(
                                errorMessage = "EROOOOOORRR",
                                isError = true
                            )
                        )
                    } else {
                        state = state.copy(
                            firstName = state.firstName.copy(
                                errorMessage = "",
                                isError = false
                            )
                        )
                    }
                },
                lastNameValidation = {
                    if (it.length > 10) {
                        state = state.copy(
                            lastName = state.lastName.copy(
                                errorMessage = "EROOOOOORRR",
                                isError = true
                            )
                        )
                    } else {
                        state = state.copy(
                            lastName = state.lastName.copy(
                                errorMessage = "",
                                isError = false
                            )
                        )
                    }
                },
                userNameValidation = {
                    if (it.length > 10) {
                        state = state.copy(
                            userName = state.userName.copy(
                                errorMessage = "EROOOOOORRR",
                                isError = true
                            )
                        )
                    } else {
                        state = state.copy(
                            userName = state.userName.copy(
                                errorMessage = "",
                                isError = false
                            )
                        )
                    }
                },
                emailValidation = {
                    if (it.length > 10) {
                        state = state.copy(
                            email = state.email.copy(
                                errorMessage = "EROOOOOORRR",
                                isError = true
                            )
                        )
                    } else {
                        state = state.copy(
                            email = state.email.copy(
                                errorMessage = "",
                                isError = false
                            )
                        )
                    }
                },
                onRegisterClick = {},
                firstNameIsError = state.firstName.isError,
                lastNameIsError = state.lastName.isError,
                userNameIsError = state.userName.isError,
                emailIsError = state.email.isError,
                firstNameErrorMessage = state.firstName.errorMessage,
                lastNameErrorMessage = state.lastName.errorMessage,
                userNameErrorMessage = state.userName.errorMessage,
                emailErrorMessage = state.email.errorMessage,
                focusManager = focusManager
            )
        }


}

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
//            focusManager = focusManager.moveFocus(FocusDirection.Next)
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
        CustomElevatedButton(
            onClick = onRegisterClick,
            name = stringResource(id = R.string.register)
        )
    }
}

@Composable
fun CustomTextFiled(
    label: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    value: String,
    iconId: Int,
    isError: Boolean = false,
    errorMessage: String = "",
    validation: (String) -> Unit,
) {
    val focusManager = LocalFocusManager.current


    val rainbowColors: List<Color> = listOf(
        Color.Black,
        Color.Blue,
        Color.Cyan,
        Color.DarkGray,
        Color.Gray,
        Color.Green,
        Color.LightGray,
        Color.Magenta,
        Color.Red
    )
    val brush = remember {
        Brush.linearGradient(
            colors = rainbowColors
        )
    }
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp)
            .onPreviewKeyEvent {
                if (it.nativeKeyEvent.keyCode == KeyEvent.KEYCODE_TAB && it.nativeKeyEvent.action == ACTION_DOWN) {
                    focusManager.moveFocus(FocusDirection.Down)
                    true
                } else {
                    false
                }
            },
        shape = RoundedCornerShape(24.dp),
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        maxLines = 1,
        textStyle = TextStyle(brush = brush),
        label = { Text(label) },
        leadingIcon = {
            Icon(painter = painterResource(id = iconId), contentDescription = "")
        },
        trailingIcon = {
            if (isError)
                Icon(Icons.Filled.Info, "error", tint = MaterialTheme.colorScheme.error)
        },
        isError = isError,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        ) {
            validation(value)
//            focusManager.moveFocus(FocusDirection.Next)
        }


    )
    if (isError) {
        Text(
            text = errorMessage,
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
fun CustomElevatedButton(onClick: () -> Unit, name: String) {
    ElevatedButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp), onClick = onClick,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 2.dp,
            pressedElevation = 2.dp,
            focusedElevation = 2.dp,
            hoveredElevation = 2.dp,
            disabledElevation = 0.dp
        ),
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = Color.Black
        )

    ) {
        Text(
            text = name,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge
        )

    }
}

@Preview(showBackground = true)
@Composable
fun PreView() {
    LoginLayout()
}

@Composable
fun CallTextFiledPreview(onValueChange: (value: String) -> Unit) {
//    CustomTextFiled(
//        label = "First Name",
//        modifier = Modifier
//            .padding(20.dp)
//            .border(6.dp, Brush.horizontalGradient(), RectangleShape),
//        onValueChange = onValueChange
//    )
}