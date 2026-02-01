package com.example.jit1.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(
    @PrimaryKey(autoGenerate = true)
    val id: Int?=null,
    val parentId: Int? = null, // اگر null باشد، یعنی خودش یک دسته اصلی است
    val fa: String,
    val en: String,
    val de: String,
    val icon: Int = 0
)
