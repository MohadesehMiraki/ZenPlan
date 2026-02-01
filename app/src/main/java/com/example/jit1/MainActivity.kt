package com.example.jit1

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.Contacts.Intents.UI
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.jit1.room.InsertCategory
import com.example.jit1.room.MyDB
import com.example.jit1.screens.MainScreenUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
 companion object{
     lateinit var database: MyDB
 }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = Room.databaseBuilder(
            this, MyDB::class.java, "zen_plan_db"
        ).build()

        lifecycleScope.launch(Dispatchers.IO){
            val catClass=InsertCategory()
            catClass.insertCategories()
        }

        enableEdgeToEdge()
        setContent {
            MainScreenUI()

        }
    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
    }
}