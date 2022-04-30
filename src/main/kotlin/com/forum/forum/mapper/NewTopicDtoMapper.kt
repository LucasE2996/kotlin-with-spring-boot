package com.forum.forum.mapper

import com.forum.forum.dto.NewTopicDto
import com.forum.forum.model.Topic
import com.forum.forum.service.CourseService
import com.forum.forum.service.ForumUserService
import org.springframework.stereotype.Component

@Component
class NewTopicDtoMapper(
    private val forumUserService: ForumUserService,
    private val courseService: CourseService,
): Mapper<NewTopicDto, Topic> {

    override fun map(t: NewTopicDto): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.getById(t.idCourse),
            author = forumUserService.getById(t.idAuthor)
        )
    }

}