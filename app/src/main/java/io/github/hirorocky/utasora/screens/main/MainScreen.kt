package io.github.hirorocky.utasora.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainRoute(
    navigateToTitle: () -> Unit,
    viewModel: MainViewModel = hiltViewModel(),
) {
    MainScreen(
        userId = viewModel.user.collectAsState(initial = null).value?.id.orEmpty(),
        onClickLogout = {
            viewModel.onLogout(
                onSuccess = navigateToTitle,
            )
        },
    )
}

@Composable
fun MainScreen(
    userId: String = "",
    onClickLogout: () -> Unit = {},
) {
    Column {
        Text(text = "userId: $userId")
        Button(onClick = onClickLogout) {
            Text(text = "ログアウト")
        }
    }
}
