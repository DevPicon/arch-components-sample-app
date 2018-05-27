package com.devpicon.android.myarchcomponentssampleapplication.repository

import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.devpicon.android.myarchcomponentssampleapplication.database.AppDatabase
import com.devpicon.android.myarchcomponentssampleapplication.app.MyApplication
import com.devpicon.android.myarchcomponentssampleapplication.dao.TaskDao
import com.devpicon.android.myarchcomponentssampleapplication.entity.Task

class TaskRepository(val application: MyApplication) {

    private val taskDao: TaskDao
    private val allTasks: LiveData<List<Task>>

    init {
        val database: AppDatabase = MyApplication.database
        taskDao = database.taskDao()
        allTasks = taskDao.getAllTasks()
    }

    fun getAllTasks(): LiveData<List<Task>> = this.allTasks

    fun insertTask(task: Task) {
        InsertAsyncTask(taskDao).execute(task)
    }

    private class InsertAsyncTask(private val asyncTaskDao: TaskDao) : AsyncTask<Task, Void, Void>() {
        override fun doInBackground(vararg params: Task): Void? {
            asyncTaskDao.insertTask(params[0])
            return null
        }

    }
}
