package io.github.hirorocky.utasora.screens.signup

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SignUpRoute(
    viewModel: SignUpViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    SignUpScreen(
        state = viewModel.state,
        onEmailChange = viewModel::onEmailChange,
        onPasswordChange = viewModel::onPasswordChange,
        onPasswordVisibilityToggle = viewModel::onPasswordVisibilityToggle,
        onSubmit = {
            viewModel.submit(
                onSuccess = {
                    Toast.makeText(context, "サインアップ成功", Toast.LENGTH_SHORT).show()
                },
            )
        },
    )
}

@Composable
fun SignUpScreen(
    state: SignUpState = SignUpState(),
    onEmailChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {},
    onPasswordVisibilityToggle: (Boolean) -> Unit = {},
    onSubmit: () -> Unit = {},
) {
    Column {
        TextField(
            value = state.email,
            onValueChange = onEmailChange,
            label = { Text("Email") },
        )
        TextField(
            value = state.password,
            onValueChange = onPasswordChange,
            label = { Text("Password") },
        )
        Button(onClick = onSubmit) {
            Text(text = "サインアップ")
        }
    }
}
