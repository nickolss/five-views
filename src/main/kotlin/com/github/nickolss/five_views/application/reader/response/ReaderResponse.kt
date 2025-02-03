package com.github.nickolss.five_views.application.reader.response

import com.github.nickolss.five_views.domain.reader.Reader
import java.time.LocalDateTime

data class ReaderResponse(
    val id: Long?,
    val username: String,
    val email: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
){
    companion object{
        fun from(reader: Reader) = ReaderResponse(
            id = reader.id,
            username = reader.username,
            email = reader.email,
            createdAt = reader.createdAt,
            updatedAt = reader.updatedAt
        )
    }
}