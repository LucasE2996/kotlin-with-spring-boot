package com.forum.forum.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Answer (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val message: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val author: ForumUser,
    @ManyToOne
    val topic: Topic,
    val solution: Boolean
)
