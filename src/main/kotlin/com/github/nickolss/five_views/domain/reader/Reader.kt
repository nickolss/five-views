package com.github.nickolss.five_views.domain.reader

import com.github.nickolss.five_views.infrastructure.entities.reader.ReaderEntity
import java.time.LocalDateTime

data class Reader(
    val id: Long? = null,
    val username: String,
    val email: String,
    val password: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime
)