package com.example.androidplayground.repository

import com.example.androidplayground.api.TodoApi
import com.example.androidplayground.model.Todo
import retrofit2.Response

class TodoRepositoryImpl(
    private val todoApi: TodoApi
) : TodoRepository {

    override suspend fun getTodos(): Response<List<Todo>> {
        return todoApi.getTodos()
    }
}