package io.github.hirorocky.utasora.core.repository

interface StorageService {
    //    val inspirations: Flow<List<Inspiration>>
    suspend fun createUser(userId: String)
    suspend fun createPhrase(userId: String, text: String)
}
