package com.example.todoappnew

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.todoappnew.model.ColorEnum
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

            val taskFromIntent = intent.getSerializableExtra("Task") as? Task
            taskFromIntent?.let{
                taskList.add(it)
            }

            ScreenView()
        }
    }

}

@Composable
fun ScreenView()
{
    val context = LocalContext.current
    Column(modifier = Modifier.padding(WindowInsets.systemBars.asPaddingValues()))
    {
        Row(verticalAlignment = Alignment.CenterVertically)
        {
            Text(text = "Tasks list", fontSize = 26.sp, modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 10.dp).weight(1f))
            Icon(imageVector = Icons.Default.Menu, contentDescription = "menu", modifier = Modifier.padding(end = 10.dp).size(32.dp))
        }

        Box(modifier = Modifier.fillMaxSize())
        {
            if (taskList.isEmpty()) {
                Text(
                    text = "No Tasks",
                    fontSize = 26.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                TasksShow()
            }

            FloatingActionButton(
                onClick = {
                    val intent = Intent(context, TaskAdd::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier.align(Alignment.BottomEnd).padding(5.dp)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }
    }
}

@Composable
fun TasksShow()
{
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(0.dp)
        )
        {
            items(taskList) { task ->
                TaskCard(task)

            }
        }
}

@Composable
fun TaskCard(TaskItem:Task)
{
    Card(modifier = Modifier.fillMaxWidth().padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(containerColor = TaskItem.colorType.color)
        )
    {
        Column(modifier = Modifier.padding(16.dp))
        {
            Text(text = TaskItem.title, fontSize = 26.sp, color = if(TaskItem.colorType.color == Color.Black || TaskItem.colorType.color == Color.Blue || TaskItem.colorType.color == Color.Gray) Color.White else Color.Black)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = TaskItem.description, fontSize = 20.sp, color = if(TaskItem.colorType.color == Color.Black || TaskItem.colorType.color == Color.Blue || TaskItem.colorType.color == Color.Gray) Color.White else Color.Black)
        }
    }
}

