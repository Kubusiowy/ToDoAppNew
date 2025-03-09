package com.example.todoappnew

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.todoappnew.model.Task
import com.example.todoappnew.ui.theme.ToDoAppNewTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

var taskList = mutableListOf<Task>()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val systemUiController = rememberSystemUiController()
            systemUiController.setSystemBarsColor(color = Black)



            ScreenView()
        }
    }

}

@Composable
fun ScreenView()
{
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize().padding(WindowInsets.systemBars.asPaddingValues()))
    {
        if (taskList.isEmpty()){
            Text(text = "No Tasks", fontSize = 26.sp, modifier = Modifier.align(Alignment.Center))
        }else{
            TasksShow()
        }

        FloatingActionButton(onClick = {
            val intent = Intent(context, TaskAdd::class.java)
            context.startActivity(intent)
        },
            modifier = Modifier.align(Alignment.BottomEnd).padding(5.dp)) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
        }

    }

}

@Composable
fun TasksShow()
{
    Column()
    {

    }
}

@Composable
fun TaskCard()
{

}

