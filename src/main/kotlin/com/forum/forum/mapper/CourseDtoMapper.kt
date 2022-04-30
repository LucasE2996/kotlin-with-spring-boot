package com.forum.forum.mapper

import com.forum.forum.dto.CourseDto
import com.forum.forum.model.Course
import org.springframework.stereotype.Component

@Component
class CourseDtoMapper: Mapper<Course, CourseDto> {

    override fun map(t: Course): CourseDto {
        return CourseDto(
            name = t.name,
            category = t.category
        )
    }
}