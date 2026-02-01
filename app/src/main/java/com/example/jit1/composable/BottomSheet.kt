package com.example.jit1.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jit1.R
import com.example.jit1.ui.theme.corner


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(bottomSheetState: Boolean, onDismiss: () -> Unit) {
    if (bottomSheetState) {
        ModalBottomSheet(
            onDismissRequest = { onDismiss() },
            containerColor = Color.White,
            shape = RoundedCornerShape(topStart = corner.dp, topEnd = corner.dp),
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp, start = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.add_new),
                    modifier = Modifier.padding(4.dp), fontSize = 14.sp
                )

                Items(
                    text = stringResource(id = R.string.task),
                    iconResource = R.drawable.ic_task,
                    onClick = {

                    })

                Items(
                    text = stringResource(id = R.string.habit),
                    iconResource = R.drawable.ic_habit,
                    onClick = {

                    })

                Items(
                    text = stringResource(id = R.string.micro_challenge),
                    iconResource = R.drawable.ic_chalange,
                    onClick = {

                    })

                Items(
                    text = stringResource(id = R.string.gratitude),
                    iconResource = R.drawable.ic_gratitute,
                    onClick = {

                    })
            }


        }
    }
}

@Composable
private fun Items(text: String, iconResource: Int, onClick: () -> Unit) {
    ListItem(modifier = Modifier
        .clip(RoundedCornerShape(corner))
        .padding(2.dp)
        .clickable {
            onClick()
        }, headlineContent = {
        Text(text = text)
    }, leadingContent = {
        Icon(painter = painterResource(iconResource), contentDescription = "")
    }
    )
}





