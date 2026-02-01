package com.example.jit1.utils

import android.annotation.SuppressLint
import android.icu.util.Calendar
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

data class DayModel(
    val date: LocalDate,
    val dayName: String,
    val dayNumber: String,
    val isToday: Boolean
)
@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("ConstantLocale")
object DateUtils {
    val today = LocalDate.now()!!
    val currentMonth: String = today.month.getDisplayName(TextStyle.SHORT, Locale.getDefault())
    val currentDay= today.dayOfMonth.toString()
    val currentYear= today.year.toString()


    fun currentWeekDays(): List<DayModel> {
        val startDayOfWeek =
            today.minusDays(today.dayOfWeek.value.toLong() - 1)

        return (0..6).map { index ->
            val date = startDayOfWeek.plusDays(index.toLong())
            DayModel(
                date = date,
                dayName = date.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault()),
                dayNumber = date.dayOfMonth.toString(),
                isToday = date.isEqual(today)
            )
        }
    }
}