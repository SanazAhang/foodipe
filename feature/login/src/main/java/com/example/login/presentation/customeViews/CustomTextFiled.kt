package com.example.login.presentation.customeViews

import android.view.KeyEvent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
                if (it.nativeKeyEvent.keyCode == KeyEvent.KEYCODE_TAB && it.nativeKeyEvent.action == KeyEvent.ACTION_DOWN) {
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
