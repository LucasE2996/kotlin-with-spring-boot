package com.forum.forum.dto

import com.forum.forum.model.TopicStatus
import java.time.LocalDateTime

data class TopicDto(
    val id: Long?,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val creationDate: LocalDateTime
)