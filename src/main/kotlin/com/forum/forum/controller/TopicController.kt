package com.forum.forum.controller

import com.forum.forum.dto.NewTopicDto
import com.forum.forum.dto.TopicByCategoryDto
import com.forum.forum.dto.TopicDto
import com.forum.forum.dto.UpdateTopicDto
import com.forum.forum.service.TopicService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(
    private val topicService: TopicService
) {

    /**
     * Cache in this method is just as an example. Use cache only for resources that does not change often in prod to avoid
     * many cache invalidation's, this can lead to a performance issue.
     */
    @GetMapping
    @Cacheable("topics")
    fun getAll(
        @RequestParam(required = false) courseName: String?,
        @PageableDefault(size = 5, sort = ["creationDate"], direction = Sort.Direction.DESC) pagination: Pageable
    ): Page<TopicDto> {
        return topicService.getAllTopics(courseName, pagination)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): TopicDto {
        return topicService.getTopicById(id)
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    fun register(
        @RequestBody @Valid dto: NewTopicDto,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicDto> {
        val topic = topicService.register(dto)
        val uri = uriBuilder.path("/topic/${topic.id}").build().toUri()
        return ResponseEntity.created(uri).body(topic)
    }

    @PutMapping
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    fun update(@RequestBody @Valid dto: UpdateTopicDto): ResponseEntity<TopicDto> {
        val topic = topicService.update(dto)
        return ResponseEntity.ok(topic)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        topicService.delete(id)
    }

    @GetMapping("/report")
    fun report(): List<TopicByCategoryDto> {
        return topicService.report()
    }
}