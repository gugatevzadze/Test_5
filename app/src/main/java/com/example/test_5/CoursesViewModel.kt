package com.example.test_5

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CoursesViewModel : ViewModel() {

    private val _courses = MutableStateFlow<CourseResponse?>(null)
    val courses: StateFlow<CourseResponse?> get() = _courses

    private val apiService = Network.createService()

    fun fetchCourses() {
        viewModelScope.launch {
            try {
                _courses.value = apiService.getCourses()
            } catch (e: Exception) {
                Log.e("CoursesViewModel", "Error loading data", e)
            }
        }
    }
}




