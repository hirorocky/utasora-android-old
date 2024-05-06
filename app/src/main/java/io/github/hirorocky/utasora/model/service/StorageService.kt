package io.github.hirorocky.utasora.model.service

interface StorageService {
    //    val inspirations: Flow<List<Inspiration>>
    suspend fun createUser(userId: String)
    suspend fun createInspiration(userId: String, text: String)
}
