package com.example.todoappnew.util
import android.content.Context
import com.example.todoappnew.model.Task

object StorageOperations {

    fun writeTaskList(context: Context,taskList: List<Task>) {
        val json = JsonConverter.taskListToJson(taskList)
        val sharedPreferences = context.getSharedPreferences(SHARED_PREFES_NAME,Context.MODE_PRIVATE).edit()
        sharedPreferences.putString(TASK_LIST_KEY,json)
        sharedPreferences.apply()
    }

    fun readTaskList(context: Context): List<Task> {
        val sharedPreferences = context.getSharedPreferences(SHARED_PREFES_NAME,Context.MODE_PRIVATE)
        val json = sharedPreferences.getString(TASK_LIST_KEY,null)

        return if(json != null){
            JsonConverter.taskListFromJson(json)
        }else{
            emptyList()
        }
    }


    private const val SHARED_PREFES_NAME = "TASK_SHARED_PREFS"
    private const val TASK_LIST_KEY = "TASK_LIST_KEY"
}