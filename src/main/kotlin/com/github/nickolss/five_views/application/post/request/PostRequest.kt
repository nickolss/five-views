package com.github.nickolss.five_views.application.post.request

import com.github.nickolss.five_views.domain.post.Post
import com.github.nickolss.five_views.infrastructure.entities.post.PostStatus
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size

data class PostRequest(
    @field:NotBlank
    @field:Size(min = 5, max = 150)
    val title: String,

    @field:NotBlank
    val content: String,

    @field:NotNull
    val categoryId: Long,

    @field:NotNull
    @Positive
    val authorId: Long,

    val status: PostStatus = PostStatus.EM_DESENVOLVIMENTO
) {
    fun toPost() = Post(
        title = title,
        content = content,
        categoryId = categoryId,
        authorId = authorId,
        status = status
    )
}