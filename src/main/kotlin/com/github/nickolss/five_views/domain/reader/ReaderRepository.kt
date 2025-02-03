package com.github.nickolss.five_views.domain.reader

interface ReaderRepository {
    fun findAll(): List<Reader>
    fun findById(id: Long): Reader?
    fun findByUsername(username: String): Reader?
    fun findByEmail(email: String): Reader?
    fun create(reader: Reader): Reader
    fun deleteById(id: Long)
    fun update(reader: Reader): Reader?
    fun existsByUsername(username: String): Boolean
    fun existsByEmail(email: String): Boolean
}