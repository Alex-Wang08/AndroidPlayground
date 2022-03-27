package com.example.androidplayground.activities.retrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidplayground.model.Todo
import com.example.androidplayground.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


@HiltViewModel
class TodoViewModel @Inject constructor(
    private val todoRepository: TodoRepository
): ViewModel() {
    private val TAG = TodoViewModel::class.java.simpleName

    var loadState = MutableLiveData<LoadState>()
    var todoList = MutableLiveData<List<Todo>>()

    init {
        loadTodoList()
    }

    private fun loadTodoList() {
        viewModelScope.launch {
            val response = try {
                loadState.value = LoadState.IsLoading
                todoRepository.getTodos()
            } catch (e: IOException) {
                Log.e(TAG, "IOException, you might not have internet connection")

                loadState.value = LoadState.Completed
                return@launch
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException, unexpected response")
                loadState.value = LoadState.Completed
                return@launch
            }

            if (response.isSuccessful && response.body() != null) {
                todoList.value = response.body()
            } else {
                Log.e(TAG, "Response not successful")
            }

            loadState.value = LoadState.Completed
        }
    }
}

enum class LoadState {
    IsLoading, Completed
}