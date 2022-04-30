package com.forum.forum.service

import com.forum.forum.model.ForumUser
import com.forum.forum.repository.ForumUserRepository
import org.springframework.stereotype.Service

@Service
class ForumUserService(
    private val repository: ForumUserRepository
) {

    fun getById(id: Long): ForumUser {
        return repository.getById(id)
    }

}
