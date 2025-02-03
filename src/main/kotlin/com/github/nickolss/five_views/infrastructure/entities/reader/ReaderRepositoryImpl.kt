package com.github.nickolss.five_views.infrastructure.entities.reader

import com.github.nickolss.five_views.domain.reader.Reader
import com.github.nickolss.five_views.domain.reader.ReaderRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class ReaderRepositoryImpl(
    private val repository: ReaderEntityRepository
) : ReaderRepository {

    override fun findAll(): List<Reader> = repository.findAll().map {
        it.toReader()
    }

    override fun findById(id: Long): Reader? = repository.findByIdOrNull(id)?.toReader()

    override fun findByUsername(username: String): Reader? = repository.findByUsername(username)?.toReader()

    override fun findByEmail(email: String): Reader? = repository.findByEmail(email)?.toReader()

    override fun create(reader: Reader): Reader = repository.save(ReaderEntity.from(reader)).toReader()

    override fun deleteById(id: Long) = repository.deleteById(id)

    override fun update(reader: Reader): Reader? = reader.id?.let { id ->
        repository.findById(id).orElse(null)?.let { existingEntity ->
            existingEntity.apply {
                // Atualiza os campos
                username = reader.username
                email = reader.email
                password = reader.password
                updatedAt = LocalDateTime.now()
            }
            repository.save(existingEntity).toReader()
        }
    }


    override fun existsByUsername(username: String): Boolean = repository.existsByUsername(username)

    override fun existsByEmail(email: String): Boolean = repository.existsByEmail(email)

}