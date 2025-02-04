package com.github.nickolss.five_views.application.post.response

import com.github.nickolss.five_views.domain.post.Post
import com.github.nickolss.five_views.infrastructure.entities.post.PostStatus
import org.hibernate.validator.constraints.UUID
import java.time.LocalDateTime

data class PostResponse(
    val id: Long?,
    val title: String,
    val content: String,
    val categoryId: Long,
    val authorId: Long,
    val status: PostStatus,
    val createdAt: LocalDateTime
) {
    companion object {
        fun from(post: Post) = PostResponse(
            id = post.id,
            title = post.title,
            content = post.content,
            categoryId = post.categoryId,
            authorId = post.authorId,
            status = post.status,
            createdAt = post.createdAt
        )
    }
}