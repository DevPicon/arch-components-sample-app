package com.devpicon.android.myarchcomponentssampleapplication.app

import android.app.Application
import androidx.room.Room
import com.devpicon.android.myarchcomponentssampleapplication.database.AppDatabase

/**
 * Created by devpicon on 10/13/17.
 * Updated by devpicon on 04/23/19.
 */
class MyApplication : Application() {
    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "sample-db").build()
    }
}