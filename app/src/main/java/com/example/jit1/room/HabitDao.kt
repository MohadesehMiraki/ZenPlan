package com.example.jit1.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.jit1.room.model.Habit
import com.example.jit1.room.model.Task

@Dao
interface HabitDao {

    @Insert
    fun insertHabit(habit: Habit)

    @Query("SELECT * FROM Habit")
    fun getAllHabit():List<Habit>

    @Update
    fun updateHabit(habit: Habit)

    @Delete
    fun deleteHabit(habit: Habit)

    @Query("SELECT * FROM Habit WHERE title LIKE '%'|| :searching ||'%'")
    fun searchHabit(searching:String):List<Habit>

    @Query("SELECT * FROM Habit WHERE categoryId == :categoryId ")
    fun category(categoryId:Int):List<Habit>
}