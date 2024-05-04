package io.github.hirorocky.utasora.screens.splash

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {
    fun onAppStart(
        navigateToTitle: () -> Unit,
        navigateToMain: () -> Unit,
    ) {
        navigateToTitle()
        // FIXME: ログインしてたらメイン画面へ
    }
}
