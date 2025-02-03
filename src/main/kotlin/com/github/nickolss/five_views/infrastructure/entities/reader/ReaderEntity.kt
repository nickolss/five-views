package com.github.nickolss.five_views.infrastructure.entities.reader

import com.github.nickolss.five_views.domain.reader.Reader
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "readers")
data class ReaderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @Column(nullable = false, unique = true)
    var username: String,

    @Column(nullable = false, unique = true)
    var email: String,

    @Column(nullable = false)
    var password: String,

    @Column(name = "created_at", nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime
) {
    @PreUpdate
    fun preUpdate() {
        updatedAt = LocalDateTime.now()
    }

    fun toReader() = Reader(
        id,
        username,
        email,
        password,
        createdAt,
        updatedAt,
    )

    companion object{
        fun from(reader: Reader) = ReaderEntity(
            id = reader.id,
            username = reader.username,
            email = reader.email,
            password = reader.password,
            createdAt = reader.createdAt,
            updatedAt = reader.updatedAt
        )
    }
}