package com.example.jit1.room.model

import androidx.compose.foundation.MutatePriority
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
    val title:String,
    val description:String?=null,
    val howMuchIsCompleted:Int,
    val createdAt:Long=System.currentTimeMillis(),
    var dueDate:Long=0,
    val dueTime:Long=0,
    val isRemindSet:Boolean,
    val priority: Int,
    val categoryId:Int,
    val isImportant:Boolean
)