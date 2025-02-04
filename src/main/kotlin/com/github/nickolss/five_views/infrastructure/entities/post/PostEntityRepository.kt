package com.github.nickolss.five_views.infrastructure.entities.post

import com.github.nickolss.five_views.domain.post.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostEntityRepository : JpaRepository<PostEntity, Long> {
    fun findByTitle(title: String): Post?
    fun existsByTitle(title: String): Boolean
}