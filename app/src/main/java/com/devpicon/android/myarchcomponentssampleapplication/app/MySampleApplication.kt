package com.devpicon.android.myarchcomponentssampleapplication.app

import android.app.Application
import android.arch.persistence.room.Room
import com.devpicon.android.myarchcomponentssampleapplication.AppDatabase

/**
 * Created by devpicon on 10/13/17.
 */
class MyApplication : Application() {
    companion object {
        var database: AppDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        MyApplication.database = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "sample-db").build()
    }
}