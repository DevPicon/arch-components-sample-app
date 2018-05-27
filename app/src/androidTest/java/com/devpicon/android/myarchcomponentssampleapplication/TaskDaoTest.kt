package com.devpicon.android.myarchcomponentssampleapplication

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.arch.core.executor.testing.InstantTaskExecutorRule;

import android.support.test.runner.AndroidJUnit4
import com.devpicon.android.myarchcomponentssampleapplication.database.AppDatabase
import com.devpicon.android.myarchcomponentssampleapplication.entity.Task
import io.reactivex.Flowable
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule


/**
 * Created by devpicon on 11/2/17.
 */
@RunWith(AndroidJUnit4::class)
class TaskDaoTest {

    private lateinit var database: AppDatabase

    private val DESCRIPTION = "Tarea 1"

    @JvmField
    @Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun initDb() {
        database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                AppDatabase::class.java)
                .allowMainThreadQueries()
                .build()
    }

    @Test
    fun insertAndGetTask() {
        database.taskDao().insertTask(Task(0, DESCRIPTION))

        val allTasks: Flowable<List<Task>> = database.taskDao().getAllTasks()

        allTasks.subscribe { tasks ->
            run {
                tasks.size
                assertThat(tasks.size, `is`(1))
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