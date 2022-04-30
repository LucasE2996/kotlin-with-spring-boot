package com.forum.forum.controller

import com.forum.forum.dto.CourseDto
import com.forum.forum.service.CourseService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/courses")
class CourseController(
    private val courseService: CourseService
) {

    @GetMapping
    fun getAll(): List<CourseDto> {
        return courseService.getAllCourses()
    }

}