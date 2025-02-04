package com.github.nickolss.five_views.domain.post

interface PostRepository {
    fun findAll(): List<Post>
    fun findById(id: Long): Post?
    fun findByTitle(title: String): Post?
    fun create(post: Post): Post
    fun update(post: Post): Post?
    fun deleteById(id: Long)
    fun existsByTitle(title: String): Boolean
}