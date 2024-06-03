package io.github.hirorocky.utasora.feature.settings

import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.hirorocky.utasora.core.model.User
import io.github.hirorocky.utasora.core.repository.AccountService
import io.github.hirorocky.utasora.core.ui.BaseViewModel
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
