package com.github.nickolss.five_views.infrastructure.entities.post

import com.github.nickolss.five_views.domain.post.Post
import com.github.nickolss.five_views.domain.post.PostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class PostRepositoryImpl(
    private val repository: PostEntityRepository
) : PostRepository {

    override fun findAll(): List<Post> = repository.findAll().map {
        it.toPost()
    }

    override fun findById(id: Long): Post? = repository.findByIdOrNull(id)?.toPost()

    override fun findByTitle(title: String): Post? = repository.findByTitle(title)

    override fun create(post: Post): Post = repository.save(PostEntity.from(post)).toPost()

    override fun update(post: Post): Post? = post.id?.let { id ->
        repository.findById(id).orElse(null)?.let { existingEntity ->
            existingEntity.apply {
                title = post.title
                content = post.content
                categoryId = post.categoryId
                status = post.status
                updatedAt = LocalDateTime.now()
            }
            repository.save(existingEntity).toPost()
        }
    }

    override fun deleteById(id: Long) = repository.deleteById(id)

    override fun existsByTitle(title: String): Boolean = repository.existsByTitle(title)

}