package io.github.hirorocky.utasora.screens.splash

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.hirorocky.utasora.model.service.AccountService
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
