package com.devpicon.android.myarchcomponentssampleapplication

import android.arch.persistence.room.*
import com.devpicon.android.myarchcomponentssampleapplication.entity.Task
import io.reactivex.Flowable

/**
 * Created by devpicon on 10/13/17.
 */
@Dao
interface TaskDao {
    @Query("SELECT * FROM Task")
    fun getAllTasks(): Flowable<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(task: Task)

    @Update
    fun updateTask(tasks: Array<Task>)

    @Delete
    fun deleteTask(tasks: Array<Task>)

}