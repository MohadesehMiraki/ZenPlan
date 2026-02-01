package com.example.jit1.animation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.jit1.utils.ColorTheme

@Composable
fun ImageChange(
    isSelected: Boolean,
    activeIcon: Int,
    inactiveIcon: Int,
    changeTint: Boolean, dynamicColorThemes: ColorTheme
) {
    AnimatedContent(targetState = isSelected, transitionSpec = {
        scaleIn(animationSpec = tween(500)).togetherWith(scaleOut(animationSpec = tween(500)))
    }, label = "icon_scale") { targetSelected ->
        Icon(
            painter = if (targetSelected) {
                painterResource(activeIcon)
            } else {
                painterResource(inactiveIcon)
            }, null, tint = if (changeTint) {
                if (targetSelected) {
                    dynamicColorThemes.primaryColor
                } else {
                    Color.Gray
                }
            } else {
                Color.Unspecified
            }
        )
    }
}