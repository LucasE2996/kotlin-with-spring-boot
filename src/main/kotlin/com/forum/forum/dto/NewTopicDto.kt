package com.forum.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NewTopicDto(
    @field:NotEmpty @field:Size(min = 5, max = 20) val title: String,
    @field:NotEmpty @field:Size(min = 10, max = 40) val message: String,
    @field:NotNull val idCourse: Long,
    @field:NotNull val idAuthor: Long
)
