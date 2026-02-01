package com.example.jit1.composable

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.unit.dp
import com.example.jit1.utils.ColorTheme
import com.example.jit1.utils.DateUtils
import com.example.jit1.utils.DayModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeekDaysRow(dynamicColors: ColorTheme) {
    val weekDays = remember {
        DateUtils.currentWeekDays()
    }

    Row(modifier = Modifier
        .fillMaxWidth()
        .horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.Center){
        weekDays.forEach { day ->
            DayItem(day = day, dynamicColors = dynamicColors)
        }
    }
}

@Composable
fun DayItem(day: DayModel, dynamicColors: ColorTheme) {
    val dayNameColor = if (day.isToday) {
        Color.Black
    } else {
        Color.Gray
    }

    val dayNumberBackgroundColor = if (day.isToday) {
        dynamicColors.primaryColor
    } else {
        Color.White
    }

    val dayNumberTextColor = if (day.isToday) {
        dynamicColors.onPrimaryColor
    } else {
        Color.Black
    }

    Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp)){
        Box(contentAlignment = Alignment.Center) {
            Text(text = day.dayName, color = dayNameColor)
        }
        Box(
            Modifier
                .padding(4.dp)
                .clip(CircleShape)
                .background(dayNumberBackgroundColor)
                .width(50.dp)
                .height(50.dp), contentAlignment = Alignment.Center
        ) {
            Text(text = day.dayNumber, color = dayNumberTextColor)
        }
    }

}