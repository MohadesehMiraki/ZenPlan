package com.example.jit1.room

import android.content.Context
import androidx.room.Room
import com.example.jit1.MainActivity.Companion.database
import com.example.jit1.room.model.Category

class InsertCategory() {

   private val categoryDao = database.categoryDao

    private val categories = arrayListOf(
        // --- دسته‌های اصلی (ParentId = null) ---
        Category(100, null, "سلامتی", "Health", "Gesundheit"),
        Category(200, null, "کار و یادگیری", "Work & Learning", "Arbeit & Lernen"),
        Category(300, null, "روح و ذهن", "Mind & Soul", "Geist & Seele"),
        Category(400, null, "سبک زندگی", "Lifestyle", "Lebensstil"),

        // --- زیردسته‌های سلامتی (ParentId = 100) ---
        Category(1, 100, "ورزش", "Exercise", "Sport"),
        Category(2, 100, "تغذیه", "Nutrition", "Ernährung"),
        Category(3, 100, "خواب", "Sleep", "Schlaf"),

        // --- زیردسته‌های کار و یادگیری (ParentId = 200) ---
        Category(4, 200, "مطالعه", "Reading", "Lesen"),
        Category(5, 200, "پروژه", "Project", "Projekt"),
        Category(6, 200, "زبان", "Language", "Sprache"),

        // --- زیردسته‌های روح و ذهن (ParentId = 300) ---
        Category(7, 300, "مدیتیشن", "Meditation", "Meditation"),
        Category(8, 300, "شکرگزاری", "Gratitude", "Dankbarkeit"),
        Category(9, 300, "تفکر", "Reflection", "Reflexion"),

        // --- زیردسته‌های سبک زندگی (ParentId = 400) ---
        Category(10, 400, "نظافت", "Cleaning", "Putzen"),
        Category(11, 400, "خرید", "Shopping", "Einkaufen"),
        Category(12, 400, "روابط", "Social", "Soziales")
    )

    fun insertCategories() {
        if (categoryDao.countCategories() == 0) {
            categories.forEach { it ->
                categoryDao.insertCategory(it)
            }
        }
    }
}