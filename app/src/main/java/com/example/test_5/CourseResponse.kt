package com.example.test_5

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CourseResponse(
    val new_courses: List<Course>,
    val active_courses: List<Course>
)