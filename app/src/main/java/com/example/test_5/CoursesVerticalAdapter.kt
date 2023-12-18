package com.example.test_5

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test_5.databinding.ItemVerticalCourseBinding

class CoursesVerticalAdapter :
    ListAdapter<Course, CoursesVerticalAdapter.ViewHolder>(CourseDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemVerticalCourseBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val course = getItem(position)
        holder.bind(course)
    }

    inner class ViewHolder(private val binding: ItemVerticalCourseBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(course: Course) {
            binding.courseTitle.text = course.title
            binding.courseBookingTime.text = "Booking Time: ${course.booking_time}"
            binding.courseProgress.text = "Progress: ${course.progress}%"
            Glide.with(binding.courseImage.context)
                .load(course.image)
                .into(binding.courseImage)
            val mainColor = Color.parseColor("#${course.main_color}")
            val shapeDrawable = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = 50f
                setColor(mainColor)
            }
            binding.verticalContainer.background = shapeDrawable
        }
    }

    class CourseDiffCallback : DiffUtil.ItemCallback<Course>() {
        override fun areItemsTheSame(oldItem: Course, newItem: Course): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Course, newItem: Course): Boolean {
            return oldItem == newItem
        }
    }
}
