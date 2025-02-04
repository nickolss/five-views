package com.github.nickolss.five_views.application.reader

import com.github.nickolss.five_views.application.reader.request.ReaderRequest
import com.github.nickolss.five_views.application.reader.response.ReaderResponse
import com.github.nickolss.five_views.domain.reader.ReaderRepository
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/readers")
class ReaderResource(
    private val readerRepository: ReaderRepository
) {
    @GetMapping
    fun getAll() = readerRepository.findAll().map {
        ReaderResponse.from(it)
    }.let {
        ResponseEntity.ok().body(it)
    }

    @GetMapping("{id}")
    fun getById(@PathVariable id: Long) = readerRepository.findById(id)?.let {
        ResponseEntity.ok().body(ReaderResponse.from(it))
    } ?: ResponseEntity.notFound().build<Void>()

    @GetMapping("/search")
    fun getByUsername(@RequestParam("username") username: String) = readerRepository.findByUsername(username)?.let {
        ResponseEntity.ok().body(ReaderResponse.from(it))
    } ?: ResponseEntity.notFound().build<Void>()

    @PostMapping
    fun create(@Valid @RequestBody request: ReaderRequest) = request.toReader().run {
        readerRepository.create(this)
    }.let {
        ResponseEntity
            .created(URI("/readers/${it.id}"))
            .body(ReaderResponse.from(it))
    }

    @PutMapping("{id}")
    fun update(@Valid @RequestBody request: ReaderRequest, @PathVariable id: Long) =
        readerRepository.findById(id)?.let { existingReader ->
            val updatedReader = existingReader.copy(
                username = request.username,
                email = request.email,
                password = request.password,
                updatedAt = existingReader.updatedAt
            )
            readerRepository.update(updatedReader)?.let {
                ResponseEntity.ok(ReaderResponse.from(it))
            }
        } ?: ResponseEntity.notFound().build()

    @DeleteMapping("{id}")
    fun deleteById(@PathVariable id: Long) = readerRepository.deleteById(id)
}


