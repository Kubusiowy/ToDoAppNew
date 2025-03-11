package com.example.todoappnew.InternetManager

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NoInternetScreenEssa() {
    Box(modifier = Modifier.fillMaxSize())
    {
        Column(modifier = Modifier.align(Alignment.Center)
            , verticalArrangement = Arrangement.Center
            , horizontalAlignment = Alignment.CenterHorizontally

            )
        {
            Text(text = "No Internet Connection", fontSize = 26.sp)
            Spacer(Modifier.height(16.dp))
            CircularProgressIndicator()


        }
    }
}