package io.github.hirorocky.utasora.core.model

import java.util.Date

data class Phrase(
    val id: String = "",
    val text: String = "",
    val createdAt: Date = Date(),
)
