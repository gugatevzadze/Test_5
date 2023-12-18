package com.example.test_5

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_5.databinding.FragmentMainBinding
import kotlinx.coroutines.launch

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val viewModel: CoursesViewModel by viewModels()
    private lateinit var verticalAdapter: CoursesVerticalAdapter
    private lateinit var horizontalAdapter: CoursesHorizontalAdapter

    override fun setUp() {
        initAdapters()
        viewModel.fetchCourses()
    }

    override fun onClickListeners() {
    }

    override fun bindObservers() {
        observeViewModel()
    }

    private fun initAdapters() {
        verticalAdapter = CoursesVerticalAdapter()
        horizontalAdapter = CoursesHorizontalAdapter()

        binding.verticalRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = verticalAdapter
        }

        binding.horizontalRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = horizontalAdapter
        }
    }
    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.courses.collect { courses ->
                    courses?.let {
                        verticalAdapter.submitList(it.active_courses)
                        horizontalAdapter.submitList(it.new_courses)
                    }
                }
            }
        }
    }
}