package com.devpicon.android.myarchcomponentssampleapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devpicon.android.myarchcomponentssampleapplication.adapter.TaskListAdapter
import com.devpicon.android.myarchcomponentssampleapplication.entity.Task
import com.devpicon.android.myarchcomponentssampleapplication.viewmodel.TaskViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TaskListActivity : AppCompatActivity() {

    private lateinit var taskViewModel: TaskViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_tasks)
        val adapter = TaskListAdapter(this)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        taskViewModel = ViewModelProviders.of(this).get(TaskViewModel::class.java)
        taskViewModel.getAllTasks().observe(this, Observer<List<Task>> { list ->
            list?.let { adapter.setTasks(it.toMutableList()) }
        })

        val fab = findViewById<FloatingActionButton>(R.id.fab)

        fab.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivityForResult(intent, NEW_TASK_ACTIVITY_REQUEST_CODE)
        }
    }

    companion object {
        const val NEW_TASK_ACTIVITY_REQUEST_CODE = 1
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == NEW_TASK_ACTIVITY_REQUEST_CODE
                && resultCode == Activity.RESULT_OK) {
            data?.let {
                val task = Task(0, data.getStringExtra(MainActivity.EXTRA_TASK_DESCRIPTION))
                taskViewModel.insert(task)
            }
        } else {
            Toast.makeText(applicationContext, "La tarea estaba vacía y no fue guardada", Toast.LENGTH_SHORT).show()
        }
    }
}
