package io.github.hirorocky.utasora.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainRoute(
    navigateToTitle: () -> Unit,
    viewModel: MainViewModel = hiltViewModel(),
) {
    MainScreen(
        state = viewModel.state,
        userId = viewModel.user.collectAsState(initial = null).value?.id.orEmpty(),
        onClickLogout = {
            viewModel.onLogout(
                onSuccess = navigateToTitle,
            )
        },
        onChangeText = viewModel::onChangeText,
        onClickSubmit = viewModel::onClickSubmit,
    )
}

@Composable
fun MainScreen(
    state: MainState = MainState(),
    userId: String = "",
    onClickLogout: () -> Unit = {},
    onChangeText: (String) -> Unit = {},
    onClickSubmit: () -> Unit = {},
) {
    Column {
        Text(text = "userId: $userId")
        Button(onClick = onClickLogout) {
            Text(text = "ログアウト")
        }
        TextField(
            value = state.text,
            onValueChange = onChangeText,
        )

        Button(
            onClick = onClickSubmit,
            enabled = state.submitting.not(),
        ) {
            if (state.submitting) {
                Text(text = "送信中")
            } else {
                Text(text = "インスピレーションを追加")
            }
        }
    }
}
