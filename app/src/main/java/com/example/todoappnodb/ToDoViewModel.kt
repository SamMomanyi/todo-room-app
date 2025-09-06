package com.example.todoappnodb

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.input.key.Key.Companion.D
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date
import java.time.Instant

class ToDoViewModel : ViewModel() {
    //we do not need _todoList for value change we only need the exposer
    val todoDao = MainApplication.todoDatabase.getTodoDao()
    val todoList : LiveData<List<Todo>> = todoDao.getAllTodo()



    @RequiresApi(Build.VERSION_CODES.O)
    fun addToDo(title : String){
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.addToDo(
                Todo(
                    title = title,
                    createdAt = Date.from(Instant.now())
                )
            )//id is automatically generated
        }
    }

    fun delToDo(id : Int){
        viewModelScope.launch(Dispatchers.IO) { //we do the database operations on a different thread
            todoDao.deleteTodo(id)
        }
    }

}