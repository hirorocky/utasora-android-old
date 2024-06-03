package io.github.hirorocky.utasora.feature.settings

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SettingsRoute(
    navigateToTitle: () -> Unit,
    viewModel: SettingsViewModel = hiltViewModel(),
) {
    SettingsScreen(
        userId = viewModel.user.collectAsState(initial = null).value?.id.orEmpty(),
        onClickLogout = {
            viewModel.onLogout(
                onSuccess = navigateToTitle,
            )
        },
    )
}

@Composable
fun SettingsScreen(
    userId: String = "",
    onClickLogout: () -> Unit = {},
) {
    Text(text = "Settings")
    Text(text = "userId: $userId")
    Button(onClick = onClickLogout) {
        Text(text = "ログアウト")
    }
}
