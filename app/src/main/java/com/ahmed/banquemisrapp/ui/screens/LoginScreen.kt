package com.ahmed.banquemisrapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmed.banquemisrapp.ui.components.ContactUSText
import com.ahmed.banquemisrapp.ui.components.Footer
import com.ahmed.banquemisrapp.ui.components.ForgotPasswordText
import com.ahmed.banquemisrapp.ui.components.Header
import com.ahmed.banquemisrapp.ui.components.LoginButton
import com.ahmed.banquemisrapp.ui.components.PasswordTextField
import com.ahmed.banquemisrapp.ui.components.UsernameTextField


@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    val usernameField = rememberTextFieldState()
    val passwordField = rememberTextFieldState()
    val context = LocalContext.current
    Content(
        usernameField = usernameField,
        passwordField = passwordField,
        onForgotPasswordClick = {
            Toast.makeText(context, "Go to Forgot Password", Toast.LENGTH_SHORT).show()
        },
        onLoginClick = {
            Toast.makeText(context, "Login Clicked", Toast.LENGTH_SHORT).show()
        },
        modifier = modifier
    )
}

@Composable
fun Content(
    modifier: Modifier = Modifier,
    usernameField: TextFieldState,
    passwordField: TextFieldState,
    onForgotPasswordClick: () -> Unit,
    onLoginClick: () -> Unit,
) {
    val isButtonEnabled = usernameField.text.isNotEmpty() && passwordField.text.isNotEmpty()
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
    ) {
        Header(
            Modifier
                .fillMaxWidth()
                .padding(top = 72.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 58.dp)
                .padding(horizontal = 8.dp),
        ) {
            UsernameTextField(
                state = usernameField,
                modifier = Modifier
                    .fillMaxWidth()
            )
            PasswordTextField(
                state = passwordField,
                modifier
                    .fillMaxWidth()
            )
            ForgotPasswordText() {
                onForgotPasswordClick()
            }
            LoginButton(
                isEnabled = isButtonEnabled,
                onClick = onLoginClick
            )
            ContactUSText()
        }
        Footer()
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ContentPreview() {
    Content(
        usernameField = TextFieldState(),
        passwordField = TextFieldState(),
        onForgotPasswordClick = {},
        onLoginClick = {}
    )
}

