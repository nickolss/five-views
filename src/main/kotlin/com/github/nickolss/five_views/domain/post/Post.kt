package com.github.nickolss.five_views.domain.post

import com.github.nickolss.five_views.infrastructure.entities.post.PostStatus
import org.hibernate.validator.constraints.UUID
import java.time.LocalDateTime

data class Post(
    val id: Long? = null,
    val title: String,
    val content: String,
    val categoryId: Long,
    val authorId: Long,
    val status: PostStatus,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime = LocalDateTime.now()
)