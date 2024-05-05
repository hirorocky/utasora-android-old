package io.github.hirorocky.utasora.screens.title

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TitleRoute(
    navigateToSignUp: () -> Unit,
) {
    TitleScreen(
        onClickSignUp = navigateToSignUp,
    )
}

@Composable
fun TitleScreen(
    onClickSignUp: () -> Unit = {},
) {
    Column {
        Text(text = "TitleScreen")
        Button(onClick = onClickSignUp) {
            Text(text = "新規登録")
        }
    }

}
