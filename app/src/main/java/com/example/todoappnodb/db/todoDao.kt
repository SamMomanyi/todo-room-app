package com.example.todoappnodb.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.todoappnodb.Todo

@Dao  //a prefix to show it is a dao class
interface todoDao {

    @Query("SELECT * FROM todos") //add a query ontop of the function to make room database understand
    fun getAllTodo() : LiveData<List<Todo>> //will get the list from database Tod which remeber is an entity)

    @Insert //the query is  understood by room
    fun addToDo(todo : Todo)
    @Query("Delete FROM todos where id = :id") //colon then id states get from parameter
    fun deleteTodo(id : Int)
}