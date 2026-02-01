package com.example.jit1.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jit1.room.model.Category
import com.example.jit1.room.model.Habit
import com.example.jit1.room.model.Task


@Database(version = 1, exportSchema = false, entities = [Category::class,Habit::class,Task::class])
abstract class MyDB :RoomDatabase(){

    abstract val habitDao:HabitDao
    abstract val taskDao:TaskDao
    abstract val categoryDao:CategoryDao

}