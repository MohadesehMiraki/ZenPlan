package com.example.jit1.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.jit1.room.model.Task

@Dao
interface TaskDao {

    @Insert
    fun insertTask(task: Task)

    @Query("SELECT * FROM task")
    fun getAllTasks():List<Task>

    @Update
    fun updateTask(task:Task)

    @Delete
    fun deleteTask(task: Task)

    @Query("SELECT * FROM Task WHERE title LIKE '%'|| :searching ||'%'")
    fun searchTask(searching:String):List<Task>

    @Query("SELECT * FROM Task WHERE categoryId == :categoryId ")
    fun category(categoryId:Int):List<Task>
}