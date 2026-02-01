package com.example.jit1.utils

import android.graphics.Bitmap
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.palette.graphics.Palette

data class ColorTheme(
    val primaryColor:Color,
    val onPrimaryColor:Color,
    val secondaryColor: Color,
    val onSecondaryColor:Color
)


fun Bitmap.extractThemeColors(defaultColors: List<Color>):ColorTheme{

    val palette=Palette.from(this).generate()

    val defaultColorInt1=defaultColors[0].toArgb()
    val defaultColorInt2=defaultColors[1].toArgb()

    val primaryColor=palette.getDominantColor(defaultColorInt1)
    val secondaryColor=palette.getVibrantColor(defaultColorInt2)

    var onPrimaryColor=Color.Black
    if(isDark(primaryColor)){
        onPrimaryColor=Color.White
    }

    var onSecondaryColor=Color.Black
    if(isDark(secondaryColor)){
        onSecondaryColor=Color.White
    }

    return ColorTheme(Color(primaryColor),onPrimaryColor,Color(secondaryColor),onSecondaryColor)
}

fun isDark(intColor:Int):Boolean{
    return androidx.core.graphics.ColorUtils.calculateLuminance(intColor)<0.5
}