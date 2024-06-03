package io.github.hirorocky.utasora.feature.signin

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SignInRoute(
    navigateToMain: () -> Unit,
    viewModel: SignInViewModel = hiltViewModel(),
) {
    SignInScreen(
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
fun SignInScreen(
    state: SignInState = SignInState(),
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
            if (state.isLoading) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.onPrimary,
                )
            } else {
                Text(text = "サインイン")
            }
        }
    }
}
