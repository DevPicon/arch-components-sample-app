package com.devpicon.android.myarchcomponentssampleapplication.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by devpicon on 10/13/17.
 * Updated by devpicon on 04/23/19.
 */
@Entity
data class Task(@PrimaryKey(autoGenerate = true) val id: Long, val description: String)