@file:Suppress("CAST_NEVER_SUCCEEDS")

package com.example.jit1.composable

import android.content.res.Resources.Theme
import android.graphics.Bitmap
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jit1.R
import com.example.jit1.ui.theme.corner
import com.example.jit1.utils.ColorTheme



@Composable
private fun PressableBox(dynamicColors: ColorTheme):Float {

    //وضعیت فشار دادن باکس
    val interactionSource = remember {
        MutableInteractionSource()
    }
    //استخراج وضعیت فشرده شدن
    val isPressed by interactionSource.collectIsPressedAsState()

    val targetColor = if (isPressed) {
        dynamicColors.primaryColor
    } else {
        dynamicColors.secondaryColor
    }

    val onTargetColor = if (isPressed) {
        dynamicColors.onPrimaryColor
    } else {
        dynamicColors.onSecondaryColor
    }

    val photoScale = if (isPressed) {
        1.3f
    } else {
        1f
    }

    val animatedColor by animateColorAsState(targetValue = targetColor, tween(300))
    val animatedTextColor by animateColorAsState(targetValue = onTargetColor, tween(300))

     val animatedPhoto by animateFloatAsState(targetValue =photoScale, tween(300) )


    Box(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp, 0.dp, 0.dp, 0.dp)
            .clip(RoundedCornerShape(corner.dp))
            .background(animatedColor)
            .clickable(interactionSource = interactionSource, indication = null)
            {


            }, contentAlignment = Alignment.Center

    )
    {
        Text(
            text = stringResource(id = R.string.deep_focus),
            color = animatedTextColor,
            modifier = Modifier
                .rotate(90f)

                ,
            fontWeight = FontWeight.Bold,
             fontSize = 16.sp,
            softWrap = false
        )

    }

    return animatedPhoto

}

var scale=1f

@Composable
fun ImageCard(imageBitmap: Bitmap, dynamicColors: ColorTheme) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(corner.dp))
                .background(dynamicColors.primaryColor)
                .padding(2.dp)
                .weight(0.8f),
        ) {
            Image(
                bitmap = imageBitmap.asImageBitmap(),
                contentScale = ContentScale.Crop,
                contentDescription = "",
                modifier = Modifier
                    .clip(RoundedCornerShape(corner.dp))
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .graphicsLayer(scaleX = scale, scaleY = scale )
            )
        }

            scale=PressableBox(dynamicColors = dynamicColors)



    }

}