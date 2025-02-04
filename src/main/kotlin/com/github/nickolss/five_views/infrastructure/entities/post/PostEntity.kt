package com.github.nickolss.five_views.infrastructure.entities.post

import com.github.nickolss.five_views.domain.post.Post
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table
data class PostEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @Column(nullable = false, length = 150)
    var title: String,

    @Column(nullable = false)
    var content: String,

    @Column(name = "category_id")
    var categoryId: Long,

    // TODO: Fazer ref com entity reader
    @Column(name = "author_id", nullable = false)
    val authorId: Long,

    @Column(nullable = false)
    var status: PostStatus = PostStatus.EM_DESENVOLVIMENTO,

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    val createdAt: LocalDateTime,

    @Column(name = "updated_at")
    @UpdateTimestamp
    var updatedAt: LocalDateTime
) {
    fun toPost() = Post(
        id = id,
        title = title,
        content = content,
        categoryId = categoryId,
        authorId = authorId,
        status = status,
        createdAt = createdAt,
        updatedAt = updatedAt
    )

    companion object {
        fun from(post: Post) = PostEntity(
            id = post.id,
            title = post.title,
            content = post.content,
            categoryId = post.categoryId,
            authorId = post.authorId,
            status = post.status,
            createdAt = post.createdAt,
            updatedAt = post.updatedAt
        )
    }
}