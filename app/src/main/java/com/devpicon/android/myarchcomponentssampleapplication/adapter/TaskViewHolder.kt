package com.devpicon.android.myarchcomponentssampleapplication.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.devpicon.android.myarchcomponentssampleapplication.R

class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textViewTaskDescription: TextView = itemView.findViewById(R.id.textView_task_description)

    fun bind(description: String) {
        textViewTaskDescription.text = description
    }

}