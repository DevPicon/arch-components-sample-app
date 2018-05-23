package com.devpicon.android.myarchcomponentssampleapplication.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by devpicon on 10/13/17.
 */
@Entity
data class Task(@PrimaryKey(autoGenerate = true) val id: Long, val description: String)