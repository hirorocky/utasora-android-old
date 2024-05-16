package io.github.hirorocky.utasora.screens.settings

import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.hirorocky.utasora.model.User
import io.github.hirorocky.utasora.model.service.AccountService
import io.github.hirorocky.utasora.screens.BaseViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val accountService: AccountService,
) : BaseViewModel() {
    val user: Flow<User?> = accountService.currentUser

    fun onLogout(onSuccess: () -> Unit) {
        launchCatching {
            accountService.signOut()
            onSuccess()
        }
    }
}
