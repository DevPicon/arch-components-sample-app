package com.devpicon.android.myarchcomponentssampleapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TASK_DESCRIPTION = "pe.devpicon.android.tasks.DESCRIPTION"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtTaskDescription = findViewById<EditText>(R.id.edt_task_description)
        val btnAddTask = findViewById<Button>(R.id.btn_add)

        btnAddTask?.setOnClickListener {

            val intent = Intent()
            if (TextUtils.isEmpty(edtTaskDescription.text)) {
                setResult(Activity.RESULT_CANCELED, intent)
            } else {
                val taskDescription: String = edtTaskDescription.text.toString()
                intent.putExtra(EXTRA_TASK_DESCRIPTION, taskDescription)
                setResult(Activity.RESULT_OK, intent)
            }
            finish()
        }


    }

}
