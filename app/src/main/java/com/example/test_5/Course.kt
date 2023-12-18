package com.example.test_5

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Course(
    val id: String,
    val icon_type: String? = null,
    val duration: String? = null,
    val title: String? = null,
    val question: String? = null,
    val main_color: String? = null,
    val booking_time: String? = null,
    val progress: String? = null,
    val background_color_present: String? = null,
    val play_button_color_present: String? = null,
    val image: String? = null
)
