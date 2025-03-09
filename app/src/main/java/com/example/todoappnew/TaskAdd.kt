package com.example.todoappnew

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoappnew.model.ColorEnum
import com.example.todoappnew.model.Task
import com.example.todoappnew.ui.theme.ToDoAppNewTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class TaskAdd : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val systemUiController = rememberSystemUiController()
            systemUiController.setSystemBarsColor(color = Black)

            TaskAddScreen()
        }
    }
}

@Composable
fun TaskAddScreen()
{
    var TextTitle by remember { mutableStateOf("") }
    var TextDescription by remember { mutableStateOf("") }
    var CardColor by remember { mutableStateOf(ColorEnum.CYAN)}
    val context = LocalContext.current

    Column(modifier = Modifier.padding(WindowInsets.systemBars.asPaddingValues()))
    {
        Text(text = "Task Add", fontSize =  26.sp ,modifier = Modifier.padding(10.dp))
        Column()
        {
            Card(modifier = Modifier.padding(10.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                colors = CardDefaults.cardColors(containerColor = CardColor.color)
                )
            {
                OutlinedTextField(
                    value = TextTitle,
                    onValueChange = { TextTitle = it },
                    label = { Text("Title") },
                    textStyle = TextStyle(color = if(CardColor == ColorEnum.BLACK|| CardColor  == ColorEnum.BLUE  || CardColor == ColorEnum.GRAY) Color.White else Color.Black),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )

                OutlinedTextField(
                    value = TextDescription,
                    onValueChange = { TextDescription = it },
                    label = { Text("Description") },
                    textStyle = TextStyle(color = if(CardColor == ColorEnum.BLACK|| CardColor  == ColorEnum.BLUE  || CardColor == ColorEnum.GRAY) Color.White else Color.Black),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )

            }

            LazyRow(modifier = Modifier.fillMaxWidth())
            {
                items(ColorEnum.values()) { colorEnum ->
                    androidx.compose.material3.Button(onClick = { CardColor = colorEnum},
                        modifier = Modifier.padding(8.dp).size(50.dp).border(1.dp, color = Color.Black, shape = CircleShape), shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(containerColor = colorEnum.color)
                            ){


                    }

                }

            }

            Button(onClick = {
                if(TextTitle.isNotEmpty() && TextDescription.isNotEmpty())
                {
                    val task = Task(title = TextTitle, description = TextDescription, colorType = CardColor)
                    var intent = Intent(context, MainActivity::class.java).apply{
                        putExtra("Task", task)

                    }
                    context.startActivity(intent)
                    (context as? ComponentActivity)?.finish()
                }
                else{
                    Toast.makeText(context, "uzupełnij dane", Toast.LENGTH_SHORT).show()
                }

            }, modifier = Modifier.padding(10.dp).fillMaxWidth()) {
                Text(text = "submit", fontSize = 16.sp)
            }
        }
    }

}



