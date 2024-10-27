package com.example.selectable

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 300.dp)
            )
             {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(40.dp)
                        .clip(shape = CircleShape)
                        .fillMaxWidth()
                        .background(color = Color.DarkGray)
                        .padding(6.dp)
                ) {
                    Text(
                        text = "Исторический тест",
                        fontSize = 24.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
                 
                 Spacer(modifier = Modifier.padding(top = 40.dp))
                 Row(horizontalArrangement = Arrangement.Center) {

                     Button(
                         onClick = {
                             val intent = Intent(baseContext, FirstQuestion::class.java)
                             startActivity(intent)

                         } ,
                         colors = ButtonDefaults.buttonColors(
                             contentColor = Color.Black,
                             containerColor = Color.LightGray
                         )
                     ) {
                         Text(
                             text = "Начать!",
                             fontSize = 24.sp,
                             fontWeight = FontWeight.Bold
                         )
                     }
                 }
            }

        }
    }
}

