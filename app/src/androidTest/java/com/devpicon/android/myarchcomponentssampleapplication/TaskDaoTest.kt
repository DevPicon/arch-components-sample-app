package com.devpicon.android.myarchcomponentssampleapplication

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.devpicon.android.myarchcomponentssampleapplication.database.AppDatabase
import com.devpicon.android.myarchcomponentssampleapplication.entity.Task
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Created by devpicon on 11/2/17.
 */
@RunWith(AndroidJUnit4::class)
class TaskDaoTest {

    private lateinit var database: AppDatabase

    private val DESCRIPTION = "Tarea 1"

    @Before
    fun initDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context,
                AppDatabase::class.java)
                .allowMainThreadQueries()
                .build()
    }

    @Test
    fun insertAndGetTask() {
        database.taskDao().insertTask(Task(0, DESCRIPTION))
        val foundTask = database.taskDao().getTask(DESCRIPTION)
        assertNotNull(foundTask)
        assertEquals(DESCRIPTION, foundTask.description)
    }


    @After
    fun closeDb() {
        database.close()
    }

}