package com.example.jit1.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.Month

@Composable
fun DateText(day:String,month: String,year:String){
    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)){
        Text(text = day, fontSize = 22.sp, fontWeight = FontWeight.ExtraBold)
        Text(text = month, fontSize = 22.sp, fontWeight = FontWeight.ExtraBold)
        Text(text = year, fontSize = 22.sp, fontWeight = FontWeight.ExtraBold)
    }
}
