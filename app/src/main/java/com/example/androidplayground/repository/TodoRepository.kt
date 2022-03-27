package com.example.androidplayground.repository

import com.example.androidplayground.model.Todo
import retrofit2.Response

interface TodoRepository {
    suspend fun getTodos(): Response<List<Todo>>
}