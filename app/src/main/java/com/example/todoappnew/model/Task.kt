package com.example.todoappnew.model

import androidx.compose.ui.graphics.Color
import java.util.UUID

data class Task(
    val title:String,
    val description:String,
    val colorType:ColorEnum
)

enum class ColorEnum(color:Color){
    RED(Color.Red),
    GREEN(Color.Green),
    BLUE(Color.Blue),
    YELLOW(Color.Yellow),
    BLACK(Color.Black),
    WHITE(Color.White),
    CYAN(Color.Cyan),
    MAGENTA(Color.Magenta),
    GRAY(Color.Gray),
    TRANSPARENT(Color.Transparent),

}