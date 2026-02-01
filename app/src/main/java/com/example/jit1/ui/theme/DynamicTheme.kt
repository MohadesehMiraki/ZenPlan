package com.example.jit1.ui.theme

import android.graphics.Bitmap
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.jit1.R
import com.example.jit1.utils.ColorTheme
import com.example.jit1.utils.DateUtils
import com.example.jit1.utils.bitmapToCompose
import com.example.jit1.utils.extractThemeColors



lateinit var imageBitmap: Bitmap
private val defaultColorThemes = listOf<Color>(Purple80, PurpleGrey80)
private lateinit var dynamicColorThemes: ColorTheme


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun GetThemeColors():ColorTheme {
    val imageResource = arrayListOf(
        R.drawable.pic1,
        R.drawable.pic2,
        R.drawable.pic5,
        R.drawable.pic6,
        R.drawable.pic8,
        R.drawable.pic9,
        R.drawable.pic10,
        R.drawable.pic11,
        R.drawable.pic12,
        R.drawable.pic13,
        R.drawable.pic15,
        R.drawable.pic16,
    )
    val resource = remember(DateUtils.today.toString()) {
        imageResource[(0..11).random()]
    }
    imageBitmap = bitmapToCompose(context = LocalContext.current, resource = resource)
    dynamicColorThemes = imageBitmap.extractThemeColors(defaultColorThemes)

return dynamicColorThemes
}