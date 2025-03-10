package com.example.todoappnew.api

import com.example.todoappnew.model.Task

class TaskNetworkRepository(private val taskService: TaskService) {

    suspend fun addTask(task: Task)
    {
        taskService.add(task)
    }

}