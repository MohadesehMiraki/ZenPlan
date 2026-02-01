package com.example.jit1.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun bitmapToCompose(context: Context, resource: Int): Bitmap {
    val myBitmap = remember(context)
    { BitmapFactory.decodeResource(context.resources, resource) }

    return myBitmap
}