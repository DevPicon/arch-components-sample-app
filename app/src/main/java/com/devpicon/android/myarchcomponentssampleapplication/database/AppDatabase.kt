package com.devpicon.android.myarchcomponentssampleapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devpicon.android.myarchcomponentssampleapplication.dao.TaskDao
import com.devpicon.android.myarchcomponentssampleapplication.entity.Task

/**
 * Created by devpicon on 10/13/17.
 */
@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}
