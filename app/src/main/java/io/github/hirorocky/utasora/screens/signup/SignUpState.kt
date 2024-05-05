package io.github.hirorocky.utasora.screens.signup

data class SignUpState(
    val email: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,
    val error: String = "",
)
