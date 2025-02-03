package com.github.nickolss.five_views.application.reader.request

import com.github.nickolss.five_views.domain.reader.Reader
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.time.LocalDateTime

data class ReaderRequest(
    @field:NotBlank
    @field:Size(min = 4, max = 20)
    val username: String,

    @field:NotBlank
    @field:Email
    val email: String,

    @field:NotBlank
    @field:Size(min = 8, max = 32)
    val password: String
) {
    fun toReader() = Reader(
        username = username,
        email = email,
        password = password,
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )
}