package com.example.todoappnew.api

import android.util.Log
import com.example.todoappnew.model.Task
import com.example.todoappnew.taskList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TaskNetworkRepository(private val taskService: TaskService) {

    suspend fun addTask(task: Task)
    {
        taskService.add(task)
    }

    suspend fun getAllTasks():List<Task>{
        return withContext(Dispatchers.IO) {
            try {
                taskService.getAll().values.toList()
            } catch (e: Exception) {
                Log.e("getAllTasks", "Błąd pobierania zadań: ${e.message}")
                emptyList()
            }
        }
    }

}