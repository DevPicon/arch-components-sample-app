package com.devpicon.android.myarchcomponentssampleapplication

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by devpicon on 10/13/17.
 */
@Database(entities = arrayOf(Task::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}