package com.example.jit1.room

import androidx.compose.ui.text.style.LineBreak
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.jit1.room.model.Category
import com.example.jit1.room.model.Habit
import com.example.jit1.room.model.Task

@Dao
interface CategoryDao {

    @Insert
    fun insertCategory(category: Category)

    @Query("SELECT * FROM Category")
    fun getAllCategories():List<Category>

    @Query("SELECT COUNT(*) FROM Category")
    fun countCategories():Int

    @Update
    fun updateCategory(category: Category)

    @Delete
    fun deleteCategory(category: Category)

    @Query("SELECT * FROM Category WHERE id == :categoryId ")
    fun categoryFind(categoryId:Int):Category
}