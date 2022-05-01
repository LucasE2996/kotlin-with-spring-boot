package com.forum.forum.service

import com.forum.forum.dto.NewTopicDto
import com.forum.forum.dto.TopicByCategoryDto
import com.forum.forum.dto.TopicDto
import com.forum.forum.dto.UpdateTopicDto
import com.forum.forum.exception.ExceptionFactory
import com.forum.forum.exception.ExceptionHandler
import com.forum.forum.exception.NotFoundException
import com.forum.forum.mapper.NewTopicDtoMapper
import com.forum.forum.mapper.TopicDtoMapper
import com.forum.forum.model.Topic
import com.forum.forum.repository.TopicRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.persistence.EntityNotFoundException

@Service
class TopicService(
    private val topicDtoMapper: TopicDtoMapper,
    private val newTopicDtoMapper: NewTopicDtoMapper,
    private val repository: TopicRepository,
    private val exceptionFactory: ExceptionFactory
) {

    fun getAllTopics(courseName: String?, pagination: Pageable): Page<TopicDto> {
        val allTopics: Page<Topic> = if (courseName == null)
            repository.findAll(pagination)
        else
            repository.findByCourseName(courseName, pagination)
        return allTopics.map { topicDtoMapper.map(it) }
    }

    fun getTopicById(id: Long): TopicDto {
        return try {
            topicDtoMapper.map(
                repository.getById(id)
            )
        } catch (e: Exception) {
            throw exceptionFactory.of(e, id.toString())
        }
    }

    fun register(dto: NewTopicDto): TopicDto {
        val newTopic = newTopicDtoMapper.map(dto)
        repository.save(newTopic)
        return topicDtoMapper.map(newTopic)
    }

    fun update(dto: UpdateTopicDto): TopicDto {
        return try {
            val topic = repository.getById(dto.id)
            topic.title = dto.title
            topic.message = dto.message
            topicDtoMapper.map(topic)
        } catch (e: Exception) {
            throw exceptionFactory.of(e, dto.id.toString())
        }
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }

    fun report(): List<TopicByCategoryDto> {
        return repository.report()
    }
}