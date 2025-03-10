package com.example.todoappnew.api

import com.example.todoappnew.model.Task
import retrofit2.http.Body
import retrofit2.http.POST

interface TaskService {

    @POST("tasks.json")
    suspend fun add(@Body task:Task)



}