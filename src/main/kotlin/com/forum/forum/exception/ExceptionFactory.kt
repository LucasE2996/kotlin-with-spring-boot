package com.forum.forum.exception

import org.springframework.orm.jpa.JpaObjectRetrievalFailureException
import org.springframework.stereotype.Component

@Component
class ExceptionFactory {

    fun of(e: Exception, id: String?): Exception {
        return if (e is JpaObjectRetrievalFailureException)
            NotFoundException("Not found: $id")
        else
            Exception(e.message)
    }
}