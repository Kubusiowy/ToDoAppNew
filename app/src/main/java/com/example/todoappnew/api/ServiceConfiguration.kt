package com.example.todoappnew.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ServiceConfiguration {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://todoappnew-d93c4-default-rtdb.europe-west1.firebasedatabase.app/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val taskService:TaskService = retrofit.create(TaskService::class.java)
}