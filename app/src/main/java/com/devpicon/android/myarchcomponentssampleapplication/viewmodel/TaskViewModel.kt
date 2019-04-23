package com.devpicon.android.myarchcomponentssampleapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.devpicon.android.myarchcomponentssampleapplication.entity.Task
import com.devpicon.android.myarchcomponentssampleapplication.repository.TaskRepository
import io.reactivex.Flowable

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TaskRepository = TaskRepository()

    private val allTasks: Flowable<List<Task>>

    init {
        allTasks = repository.getAllTasks()
    }

    fun insert(task: Task) {
        repository.insertTask(task)
    }

    fun getAllTasks(): Flowable<List<Task>> {
        return allTasks
    }

}