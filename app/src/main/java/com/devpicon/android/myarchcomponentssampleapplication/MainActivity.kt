package com.devpicon.android.myarchcomponentssampleapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.devpicon.android.myarchcomponentssampleapplication.app.MyApplication
import com.devpicon.android.myarchcomponentssampleapplication.entity.Task
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName

    var txtTaskList: TextView? = null
    var edtTaskDescription: EditText? = null
    var btnAddTask: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtTaskList = findViewById(R.id.txt_task_list)
        edtTaskDescription = findViewById(R.id.edt_task_description)
        btnAddTask = findViewById(R.id.btn_add)

        btnAddTask?.setOnClickListener {
            insertTask()
            retrieveTasks()
        }


    }

    private fun retrieveTasks() {
        MyApplication.database?.taskDao()?.getAllTasks()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe { list ->
                    run {
                        var tasksString = ""
                        list.forEach { tasksString += it.description }
                        txtTaskList?.text = tasksString
                        Log.d(TAG, "Esto se generó ${tasksString}")
                    }
                }
    }

    private fun insertTask() {
        val task = Task(0, edtTaskDescription?.text.toString())
        Log.d(TAG, task.toString())
        Single.fromCallable {
            MyApplication.database?.taskDao()?.insertTask(task)
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()

        edtTaskDescription?.text?.clear()
    }

    fun showTasks(allTasks: MutableList<Task>) {

    }
}
