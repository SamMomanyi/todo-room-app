package com.example.todoappnodb.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.todoappnodb.Todo

@Database(
    entities = [Todo::class]
    ,version = 1,
    exportSchema  = false
) //we define the class by providing the annotation, then the entity
@TypeConverters(Converters::class) //where are the converters , converters class
abstract  class TodoDatabase :RoomDatabase() {
    companion object{
        const val NAME = "Todo_DB"
    }
    abstract fun getTodoDao() : todoDao
}