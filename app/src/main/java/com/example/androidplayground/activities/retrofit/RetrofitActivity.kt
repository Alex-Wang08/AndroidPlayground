package com.example.androidplayground.activities.retrofit

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidplayground.databinding.ActivityRetrofitBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RetrofitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRetrofitBinding
    private lateinit var todoAdapter: TodoAdapter
    private val viewModel: TodoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetrofitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()

        viewModel.todoList.observe(this) {
            todoAdapter.todos = it
        }

        viewModel.loadState.observe(this) {
            binding.progressBar.isVisible = it == LoadState.IsLoading
        }
    }

    private fun setupRecyclerView() = binding.rvTodos.apply {
        todoAdapter = TodoAdapter()
        adapter = todoAdapter
        layoutManager = LinearLayoutManager(this@RetrofitActivity)
    }
}