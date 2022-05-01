package com.forum.forum.service

import com.forum.forum.model.ForumUser
import com.forum.forum.repository.ForumUserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class ForumUserService(
    private val repository: ForumUserRepository
): UserDetailsService {

    fun getById(id: Long): ForumUser {
        return repository.getById(id)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = repository.findByEmail(username) ?: throw RuntimeException()
        return MyUserDetails(user)
    }

}
