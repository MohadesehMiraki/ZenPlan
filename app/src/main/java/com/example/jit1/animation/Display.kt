package com.example.jit1.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jit1.screens.dynamicColorThemes
import com.example.jit1.ui.theme.corner


@Composable
fun DisplayDismiss(isVisible: Boolean, onDissmissClick:()->Unit) {
    AnimatedVisibility(
        visible = isVisible,
        enter = fadeIn (animationSpec = tween(500))
    , exit = fadeOut (animationSpec = tween(500))
    ) {

            Box(modifier = Modifier.fillMaxSize()
                .background(dynamicColorThemes.primaryColor.copy(alpha = 0.8f)).clickable { onDissmissClick() }.offset(y=-105.dp), contentAlignment = Alignment.BottomCenter) {
                AnimatedVisibility(
                    visible = isVisible,
                    enter = fadeIn(animationSpec = tween(500)) + scaleIn(animationSpec = tween(300)),
                    exit = fadeOut(animationSpec = tween(500)) + scaleOut(animationSpec = tween(300))
                ) {
                    Box(modifier = Modifier
                        .clip(shape = RoundedCornerShape(corner))
                        .background(Color.White).clickable(enabled = false) {}) {
                        Text(text = "YOU DID IT Mohadeseh!", Modifier.padding(24.dp))
                    }
                }
            }

    }
}