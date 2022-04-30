package com.forum.forum.service

import com.forum.forum.dto.CourseDto
import com.forum.forum.mapper.CourseDtoMapper
import com.forum.forum.model.Course
import com.forum.forum.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(
    private val repository: CourseRepository,
    private val courseDtoMapper: CourseDtoMapper
) {

    fun getById(id: Long): Course {
        return repository.getById(id)
    }

    fun getAllCourses(): List<CourseDto> {
        return repository
            .findAll()
            .map { courseDtoMapper.map(it) }
    }

}
