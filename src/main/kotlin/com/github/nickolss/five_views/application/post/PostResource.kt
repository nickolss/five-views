package com.github.nickolss.five_views.application.post

import com.github.nickolss.five_views.application.post.request.PostRequest
import com.github.nickolss.five_views.application.post.response.PostResponse
import com.github.nickolss.five_views.domain.post.PostRepository
import jakarta.validation.Valid
import org.hibernate.validator.constraints.UUID
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.time.LocalDateTime

@RestController
@RequestMapping("/posts")
class PostResource(
    private val postRepository: PostRepository
) {

    @GetMapping
    fun getAll() = postRepository.findAll().map {
        PostResponse.from(it)
    }.let {
        ResponseEntity.ok().body(it)
    }

    @GetMapping("/search")
    fun getByTitle(title: String) = postRepository.findByTitle(title)?.let {
        ResponseEntity.ok().body(PostResponse.from(it))
    } ?: ResponseEntity.notFound().build<Void>()

    @PostMapping
    fun create(@Valid @RequestBody request: PostRequest) = request.toPost().run {
        postRepository.create(this)
    }.let {
        ResponseEntity
            .created(URI("/posts/${it.id}"))
            .body(PostResponse.from(it))
    }

    @PutMapping("{id}")
    fun update(@Valid @RequestBody request: PostRequest, @PathVariable id: Long) =
        postRepository.findById(id)?.let { existingPost ->
            val updatedPost = existingPost.copy(
                title = request.title,
                content = request.content,
                categoryId = request.categoryId,
                status = request.status,
                updatedAt = LocalDateTime.now()
            )
            postRepository.update(updatedPost)?.let {
                ResponseEntity.ok().body(it)
            }
        } ?: ResponseEntity.notFound().build()

    @DeleteMapping("{id}")
    fun deleteById(@PathVariable id: Long) = postRepository.deleteById(id)
}
