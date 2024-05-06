package io.github.hirorocky.utasora.model

import java.util.Date

data class Inspiration(
    val id: String = "",
    val text: String = "",
    val createdAt: Date = Date(),
)
