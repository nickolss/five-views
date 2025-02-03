package com.github.nickolss.five_views.infrastructure.entities.reader

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ReaderEntityRepository : JpaRepository<ReaderEntity, Long> {
    fun findByUsername(username: String): ReaderEntity?
    fun findByEmail(email: String): ReaderEntity?
    fun existsByUsername(username: String): Boolean
    fun existsByEmail(email: String): Boolean
}