package com.devpicon.android.myarchcomponentssampleapplication.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.devpicon.android.myarchcomponentssampleapplication.dao.TaskDao
import com.devpicon.android.myarchcomponentssampleapplication.entity.Task

/**
 * Created by devpicon on 10/13/17.
 */
@Database(entities = arrayOf(Task::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}