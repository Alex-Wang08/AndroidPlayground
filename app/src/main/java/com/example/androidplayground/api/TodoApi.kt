package com.example.androidplayground.api

import com.example.androidplayground.retrofit.Todo
import retrofit2.Response
import retrofit2.http.GET

interface TodoApi {
    @GET("/todos")
    suspend fun getTodos(): Response<List<Todo>>



//    @POST("/createTodo")
//    fun createTodo(@Body todo: Todo): Response<CreateTodoResponse>
}