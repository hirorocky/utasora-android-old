package io.github.hirorocky.utasora.feature.splash

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.hirorocky.utasora.core.repository.AccountService
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val accountService: AccountService,
) : ViewModel() {
    fun onAppStart(
        navigateToTitle: () -> Unit,
        navigateToMain: () -> Unit,
    ) {
        if (accountService.hasUser()) {
            navigateToMain()
        } else {
            navigateToTitle()
        }
    }
}
