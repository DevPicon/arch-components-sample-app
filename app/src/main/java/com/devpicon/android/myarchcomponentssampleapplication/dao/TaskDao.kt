package com.devpicon.android.myarchcomponentssampleapplication.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.devpicon.android.myarchcomponentssampleapplication.entity.Task
import io.reactivex.Flowable

/**
 * Created by devpicon on 10/13/17.
 */
@Dao
interface TaskDao {
    @Query("SELECT * FROM Task")
    fun getAllTasks(): LiveData<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(task: Task)

    @Update
    fun updateTask(tasks: Array<Task>)

    @Delete
    fun deleteTask(tasks: Array<Task>)

}