package com.forum.forum.repository

import com.forum.forum.model.ForumUser
import org.springframework.data.jpa.repository.JpaRepository

interface ForumUserRepository: JpaRepository<ForumUser, Long> {

    fun findByEmail(username: String?): ForumUser?

}