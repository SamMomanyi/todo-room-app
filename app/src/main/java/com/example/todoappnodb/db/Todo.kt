package com.example.todoappnodb.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "todos") //room provides an annotation processor to declare entities
data class Todo(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title : String,
    var createdAt: Date

)
