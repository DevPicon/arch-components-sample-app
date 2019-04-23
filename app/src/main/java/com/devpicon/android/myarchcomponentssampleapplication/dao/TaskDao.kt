package com.devpicon.android.myarchcomponentssampleapplication.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.devpicon.android.myarchcomponentssampleapplication.entity.Task

/**
 * Created by devpicon on 10/13/17.
 */
@Dao
interface TaskDao {
    @Query("SELECT * FROM Task")
    fun getAllTasks(): LiveData<List<Task>>

    @Query("SELECT * FROM Task WHERE description = :description")
    fun getTask(description:String): Task

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(task: Task)

    @Update
    fun updateTask(tasks: Array<Task>)

    @Delete
    fun deleteTask(tasks: Array<Task>)

}