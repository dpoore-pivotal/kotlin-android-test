package com.example.recyclerviewtest

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(Todo::class), version = 1)
abstract class TodoRoomDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object {
        private var INSTANCE: TodoRoomDatabase? = null

        fun getDatabase(context: Context): TodoRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(TodoRoomDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), TodoRoomDatabase::class.java, "todo.db").build()
                }
            }
            return INSTANCE
        }
    }
}