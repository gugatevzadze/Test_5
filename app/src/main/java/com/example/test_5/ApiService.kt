package com.example.test_5

import retrofit2.http.GET

interface ApiService {

    @GET("83160a49-fe85-46ba-bcf8-3cf5aa09f92b")
    suspend fun getCourses(): CourseResponse
}
