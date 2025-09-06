package com.example.todoappnodb

import android.app.Application
import androidx.room.Room
import com.example.todoappnodb.db.TodoDatabase

//it will be called everytime we run the app
//we also declare in in manifests to show it is started when app is started
class MainApplication : Application() {

    companion object{
        lateinit var todoDatabase : TodoDatabase
    }

    override fun onCreate() {
        super.onCreate()
        todoDatabase = Room.databaseBuilder( //we provide the app context database name and class
            applicationContext,
            TodoDatabase::class.java,
            TodoDatabase.NAME
        ).build()
    }
}