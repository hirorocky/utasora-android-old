package io.github.hirorocky.utasora.screens.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.hirorocky.utasora.model.User
import io.github.hirorocky.utasora.model.service.AccountService
import io.github.hirorocky.utasora.model.service.StorageService
import io.github.hirorocky.utasora.screens.BaseViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val accountService: AccountService,
    private val storageService: StorageService,
) : BaseViewModel() {
    val user: Flow<User?> = accountService.currentUser
    var state by mutableStateOf(MainState())
        private set

    fun onLogout(onSuccess: () -> Unit) {
        launchCatching {
            accountService.signOut()
            onSuccess()
        }
    }

    fun onChangeText(text: String) {
        state = state.copy(text = text)
    }

    fun onClickSubmit() {
        state = state.copy(submitting = true)
        launchCatching {
            storageService.createInspiration(
                userId = accountService.currentUserId,
                text = state.text,
            )
            state = state.copy(submitting = false, text = "")
        }
    }
}
