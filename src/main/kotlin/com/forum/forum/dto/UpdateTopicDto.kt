package com.forum.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class UpdateTopicDto(
    @field:NotNull val id: Long,
    @field:NotEmpty @field:Size(min = 5, max = 20)  val title: String,
    @field:NotEmpty @field:Size(min = 10, max = 40)val message: String
)
