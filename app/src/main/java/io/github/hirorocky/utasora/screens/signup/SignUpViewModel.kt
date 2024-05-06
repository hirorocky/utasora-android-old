package io.github.hirorocky.utasora.screens.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.hirorocky.utasora.model.service.AccountService
import io.github.hirorocky.utasora.model.service.StorageService
import io.github.hirorocky.utasora.screens.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val accountService: AccountService,
    private val storageService: StorageService,
) : BaseViewModel() {
    var state by mutableStateOf(SignUpState())
        private set

    fun onEmailChange(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordChange(password: String) {
        state = state.copy(password = password)
    }

    fun onPasswordVisibilityToggle(toggleTo: Boolean) {
        state = state.copy(isPasswordVisible = !state.isPasswordVisible)
    }

    fun submit(onSuccess: () -> Unit) {
        state = state.copy(isLoading = true)
        launchCatching {
            val userId = accountService.signUp(
                email = state.email,
                password = state.password,
            ).user?.uid.orEmpty()
            // FIXME: エラー処理
            if (userId.isNotEmpty()) {
                storageService.createUser(userId = userId)
                // FIXME: エラー処理
            }
            onSuccess()
        }
    }
}
