package com.devpicon.android.myarchcomponentssampleapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.devpicon.android.myarchcomponentssampleapplication.app.MyApplication
import com.devpicon.android.myarchcomponentssampleapplication.entity.Task
import com.devpicon.android.myarchcomponentssampleapplication.repository.TaskRepository

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TaskRepository = TaskRepository(application as MyApplication)

    private val allTasks: LiveData<List<Task>>

    init {
        allTasks = repository.getAllTasks()
    }

    fun insert(task: Task) {
        repository.insertTask(task)
    }

    fun getAllTasks(): LiveData<List<Task>> {
        return allTasks
    }

}