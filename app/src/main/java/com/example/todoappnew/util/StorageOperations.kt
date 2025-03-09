package com.example.todoappnew.util

import android.content.Context
import android.util.Log
import com.example.todoappnew.model.Task

object StorageOperations {

    fun writeTaskList(context: Context, taskList:List<Task>){
        val json = JsonConverter.taskListToJson(taskList)
        val sharedPrefs = context.getSharedPreferences(SHARED_PREFES_KEY, Context.MODE_PRIVATE).edit()
        sharedPrefs.putString(TASK_LIST_KEY,json)
        sharedPrefs.apply()
    }

    fun readTaskList(context:Context):List<Task> {
        val sharedPrefs = context.getSharedPreferences(SHARED_PREFES_KEY, Context.MODE_PRIVATE)
        val json = sharedPrefs.getString(TASK_LIST_KEY,null)?: return emptyList()
       return try {
           JsonConverter.taskListFromJson(json) ?: emptyList()
       }catch (e:Exception) {
           Log.e("StorageOperations", "Error reading task list", e)
           emptyList()
       }

    }

    private const val SHARED_PREFES_KEY = "TASK_SHARED_PREFES"
    private const val TASK_LIST_KEY = "TASK_LIST_KEY"

}