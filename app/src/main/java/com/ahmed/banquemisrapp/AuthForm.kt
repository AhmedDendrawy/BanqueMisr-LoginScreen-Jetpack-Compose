package com.ahmed.banquemisrapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedSecureTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmed.banquemisrapp.ui.theme.BanqueMisrRed

@Composable
fun UsernameTextField(state: TextFieldState, modifier: Modifier) {
    OutlinedTextField(
        state = state,
        modifier = modifier
            .fillMaxWidth(),
        label = { Text(stringResource(R.string.username)) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = BanqueMisrRed
        )
    )
}

@Composable
fun PasswordTextField(
    state: TextFieldState,
    modifier: Modifier = Modifier
) {
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedSecureTextField(
        state = state,
        modifier = modifier,
        label = { Text(stringResource(R.string.password)) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = BanqueMisrRed
        ),
        textObfuscationMode = if (passwordVisible) {
            TextObfuscationMode.Visible
        } else {
            TextObfuscationMode.RevealLastTyped
        },
        trailingIcon = {
            val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = image, contentDescription = "Toggle Password Visibility")
            }
        }
    )
}

@Composable
fun ForgotPasswordText(modifier: Modifier = Modifier, onMyClick: () -> Unit) {
    Text(
        text = stringResource(R.string.forgot_access),
        textDecoration = TextDecoration.Underline,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp,
        modifier =
            modifier
                .padding(top = 16.dp)
                .clickable(onClick = onMyClick)
    )
}

@Composable
fun LoginButton(isEnabled: Boolean, modifier: Modifier = Modifier,onClick: () -> Unit) {
    Button(
        onClick = onClick,
        enabled = isEnabled,
        modifier = Modifier
            .padding(top = 32.dp)
            .fillMaxWidth()
            .height(60.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = BanqueMisrRed,
            contentColor = Color.White,
            disabledContainerColor = BanqueMisrRed.copy(alpha = 0.3f),
            disabledContentColor = Color.White

        )
    ) {
        Text(
            text = stringResource(R.string.login),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

    }
}

@Composable
fun ContactUSText(modifier: Modifier = Modifier) {
    Text(
        text = buildAnnotatedString {
            append(stringResource(R.string.need_help))
            withLink(
                LinkAnnotation.Url(
                    url = "https://www.banquemisr.com/ar",
                    styles = TextLinkStyles(
                        style = SpanStyle(
                            color = BanqueMisrRed,
                            fontWeight = FontWeight.SemiBold,
                            textDecoration = TextDecoration.Underline
                        )
                    )
                )
            ) {

                append(stringResource(R.string.contact_us))
            }
        },
        fontSize = 16.sp,
        modifier = modifier.padding(top = 24.dp)
    )
}