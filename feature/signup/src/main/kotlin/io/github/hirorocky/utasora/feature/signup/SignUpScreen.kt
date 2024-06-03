package io.github.hirorocky.utasora.feature.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SignUpRoute(
    navigateToMain: () -> Unit,
    viewModel: SignUpViewModel = hiltViewModel(),
) {
    SignUpScreen(
        state = viewModel.state,
        onEmailChange = viewModel::onEmailChange,
        onPasswordChange = viewModel::onPasswordChange,
        onPasswordVisibilityToggle = viewModel::onPasswordVisibilityToggle,
        onSubmit = {
            viewModel.submit(
                onSuccess = navigateToMain,
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
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
            ),
        )
        TextField(
            value = state.password,
            onValueChange = onPasswordChange,
            label = { Text("Password") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
            ),
        )
        Button(onClick = onSubmit) {
            if (state.isLoading) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.onPrimary,
                )
            } else {
                Text(text = "登録する")
            }
        }
    }
}
