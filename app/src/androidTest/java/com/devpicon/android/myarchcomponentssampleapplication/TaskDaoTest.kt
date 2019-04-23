package com.devpicon.android.myarchcomponentssampleapplication

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.devpicon.android.myarchcomponentssampleapplication.database.AppDatabase
import com.devpicon.android.myarchcomponentssampleapplication.entity.Task
import org.hamcrest.MatcherAssert
import org.hamcrest.core.Is
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Created by devpicon on 11/2/17.
 * Updated by devpicon on 04/23/19.
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

        val allTasks = database.taskDao().getAllTasks()
        allTasks.subscribe { tasks ->
            run {
                tasks.size
                MatcherAssert.assertThat(tasks.size, Is.`is`(1))
                val task: Task = tasks[0]
                assertEquals(DESCRIPTION, task.description)
            }
        }


    }


    @After
    fun closeDb() {
        database.close()
    }

}