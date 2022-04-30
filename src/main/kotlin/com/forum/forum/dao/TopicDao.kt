package com.forum.forum.dao

import org.springframework.stereotype.Service
import javax.persistence.EntityManager

/**
 * This class is an example of a custom implementation of EntityManager.
 * In case the repositories of spring boot is not enough, use this class to manipulate the entities.
 */
@Service
class TopicDao(private val em: EntityManager) {
    // TODO: implement or delete this class
}