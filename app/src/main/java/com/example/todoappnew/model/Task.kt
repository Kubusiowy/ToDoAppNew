package com.example.todoappnew.model

import androidx.compose.ui.graphics.Color
import com.squareup.moshi.JsonClass
import java.io.Serializable
import java.util.UUID

@JsonClass(generateAdapter = true)
data class Task(
    val title:String,
    val description:String,
    val colorType:ColorEnum
): Serializable

enum class ColorEnum(val color:Color){
    RED(Color.Red),
    GREEN(Color.Green),
    BLUE(Color.Blue),
    YELLOW(Color.Yellow),
    BLACK(Color.Black),
    WHITE(Color.White),
    CYAN(Color.Cyan),
    MAGENTA(Color.Magenta),
    GRAY(Color.Gray),

}