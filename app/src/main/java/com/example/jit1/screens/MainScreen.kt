package com.example.jit1.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.jit1.R
import com.example.jit1.animation.ImageChange
import com.example.jit1.composable.BottomSheet
import com.example.jit1.composable.DateText
import com.example.jit1.composable.ImageCard
import com.example.jit1.composable.WeekDaysRow
import com.example.jit1.ui.theme.GetThemeColors
import com.example.jit1.ui.theme.MyPlannerTheme
import com.example.jit1.ui.theme.corner
import com.example.jit1.ui.theme.imageBitmap
import com.example.jit1.utils.ColorTheme
import com.example.jit1.utils.DateUtils


@Composable
private fun BottomNavigationIconButtons() {
    val navController = rememberNavController()
    var selectedTab by remember {
        mutableIntStateOf(0)
    }

    BottomAppBar(
        modifier = Modifier
            .height(100.dp)
            .padding(24.dp, 0.dp)
            .graphicsLayer {
                shape = RoundedCornerShape(corner)
                clip = true
                shadowElevation = 20f
            }
    ) {
        IconButton(onClick = { selectedTab = 0 }) {
            ImageChange(
                isSelected = selectedTab == 0,
                R.drawable.ic_home_filled,
                R.drawable.ic_home_outline, true, dynamicColorThemes
            )
        }
        Spacer(modifier = Modifier.weight(0.5f))
        IconButton(onClick = { selectedTab = 1 }) {
            ImageChange(
                isSelected = selectedTab == 1, R.drawable.ic_calendar_filled,
                R.drawable.ic_calendar_outline, true, dynamicColorThemes
            )
        }
        Spacer(modifier = Modifier.weight(3f))

        IconButton(onClick = { selectedTab = 2 }) {
            ImageChange(
                isSelected = selectedTab == 2, R.drawable.ic_chart_filled,
                R.drawable.ic_chart_outline, true, dynamicColorThemes
            )
        }
        Spacer(modifier = Modifier.weight(0.5f))
        IconButton(onClick = { selectedTab = 3 }) {
            ImageChange(
                isSelected = selectedTab == 3, R.drawable.ic_setting_filled,
                R.drawable.ic_setting_outline, true, dynamicColorThemes
            )
        }
    }

}


@Composable
fun AddFab(onFabClick: () -> Unit) {

    FloatingActionButton(
        onClick = {
            onFabClick()
        },
        modifier = Modifier
            .padding(0.dp, 0.dp, 0.dp, 16.dp)
            .offset(y = 70.dp),
        shape = CircleShape,
        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(),
        containerColor = dynamicColorThemes.secondaryColor
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = null,
            tint = dynamicColorThemes.onSecondaryColor
        )
    }
}

lateinit var dynamicColorThemes: ColorTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreenUI() {

    var isVisible by remember {
        mutableStateOf(false)
    }



    dynamicColorThemes = GetThemeColors()
    MyPlannerTheme(dynamicColorThemes) {
        Scaffold(
            floatingActionButton = {
                AddFab(onFabClick = {
                    isVisible = true
                })
            },
            floatingActionButtonPosition = FabPosition.Center,
            bottomBar = {
                BottomNavigationIconButtons()
            })
        { padding ->

            Column(
                Modifier
                    .fillMaxSize()
                    .background(dynamicColorThemes.primaryColor.copy(alpha = 0.15f))
                    .systemBarsPadding()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                DateText(
                    day = DateUtils.currentDay,
                    month = DateUtils.currentMonth,
                    year = DateUtils.currentYear
                )
                WeekDaysRow(dynamicColors = dynamicColorThemes)
                ImageCard(imageBitmap = imageBitmap, dynamicColorThemes)
            }
            BottomSheet(bottomSheetState = isVisible, onDismiss = {
                isVisible=false
            })
        }


    }
}

