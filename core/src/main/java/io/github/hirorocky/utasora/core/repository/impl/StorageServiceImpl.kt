package io.github.hirorocky.utasora.core.repository.impl

import com.google.firebase.Firebase
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.firestore
import io.github.hirorocky.utasora.core.model.User
import io.github.hirorocky.utasora.core.repository.StorageService
import javax.inject.Inject

class StorageServiceImpl @Inject constructor() : StorageService {
    private val db = Firebase.firestore

    override suspend fun createUser(userId: String) {
        db.collection("users").document(userId)
            .set(User(id = userId))
    }

    override suspend fun createPhrase(userId: String, text: String) {
        db.collection("users").document(userId)
            .collection("phrases")
            .add(
                hashMapOf(
                    "text" to text,
                    "createdAt" to FieldValue.serverTimestamp(),
                ),
            )
    }
}
