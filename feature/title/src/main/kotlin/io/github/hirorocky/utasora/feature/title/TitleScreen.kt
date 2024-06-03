package io.github.hirorocky.utasora.feature.title

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TitleRoute(
    navigateToSignUp: () -> Unit,
    navigateToSignIn: () -> Unit,
) {
    TitleScreen(
        onClickSignUp = navigateToSignUp,
        onClickSignIn = navigateToSignIn,
    )
}

@Composable
fun TitleScreen(
    onClickSignUp: () -> Unit = {},
    onClickSignIn: () -> Unit = {},
) {
    Column {
        Text(text = "TitleScreen")
        Button(onClick = onClickSignUp) {
            Text(text = "新規登録")
        }
        Button(onClick = onClickSignIn) {
            Text(text = "ログイン")
        }
    }

}
