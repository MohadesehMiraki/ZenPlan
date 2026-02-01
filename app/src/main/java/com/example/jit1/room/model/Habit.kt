package com.example.jit1.room.model

import androidx.compose.foundation.MutatePriority
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Habit(
    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
    val title:String,
    val description:String?=null,
    val frequency:Int,
    val createdAt:Long=System.currentTimeMillis(),
    val currentStreak:Int,
    val bestStreak:Int,
    val lastCompletedDate:Long,
    val remindTime:Long,
    val priority: Int,
    val categoryId:Int,

)