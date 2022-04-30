package com.forum.forum.mapper

import com.forum.forum.dto.TopicDto
import com.forum.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicDtoMapper: Mapper<Topic, TopicDto> {

    override fun map(t: Topic): TopicDto {
        return TopicDto(
            id = t.id,
            title = t.title,
            message = t.message,
            status = t.status,
            creationDate = t.creationDate
        )
    }

}