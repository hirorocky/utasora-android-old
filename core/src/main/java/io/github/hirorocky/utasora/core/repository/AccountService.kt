package io.github.hirorocky.utasora.core.repository

import com.google.firebase.auth.AuthResult
import io.github.hirorocky.utasora.core.model.User
import kotlinx.coroutines.flow.Flow

interface AccountService {
    val currentUser: Flow<User?>
    val currentUserId: String
    fun hasUser(): Boolean
    suspend fun signIn(email: String, password: String)
    suspend fun signUp(email: String, password: String): AuthResult
    suspend fun signOut()
    suspend fun deleteAccount()
}
