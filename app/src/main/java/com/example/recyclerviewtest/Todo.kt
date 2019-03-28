package com.example.recyclerviewtest

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "todo")
data class Todo(@PrimaryKey @ColumnInfo(name = "value") val value: String)