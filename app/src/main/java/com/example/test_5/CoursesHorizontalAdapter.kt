package com.example.test_5

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test_5.databinding.ItemHorizontalCourseBinding

class CoursesHorizontalAdapter : ListAdapter<Course, CoursesHorizontalAdapter.ViewHolder>(CourseDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHorizontalCourseBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val course = getItem(position)
        holder.bind(course)
    }

    inner class ViewHolder(private val binding: ItemHorizontalCourseBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(course: Course) {
            binding.courseTitle.text = course.title
            binding.courseDuration.text = "Duration: ${course.duration}"
            binding.courseQuestion.text = "Question: ${course.question}"
            when (course.icon_type) {
                "settings" -> binding.courseIcon.setImageResource(R.drawable.ic_settings)
                "card" -> binding.courseIcon.setImageResource(R.drawable.ic_card)
            }
            val mainColor = Color.parseColor("#${course.main_color}")
            val shapeDrawable = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = 50f
                setColor(mainColor)
            }
            binding.horizontalContainer.background = shapeDrawable
            binding.coursePlay.setBackgroundColor(mainColor)

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