package com.example.selectable

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ThirdQuestion : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val images = listOf(
                painterResource(id = R.drawable.shapka1),
                painterResource(id = R.drawable.shapka2),
                painterResource(id = R.drawable.shapka3)
            )

            val selectedOption = remember {
                mutableStateOf(images[0])
            }

            var count = intent.extras?.getInt("count")
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 250.dp)
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
                        text = "Какие из этих изображений является изображением шапки Мономаха",
                        fontSize = 24.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.padding(top = 40.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                ) {
                    images.forEach { image ->
                        val selected = selectedOption.value == image
                        Box(
                            modifier = Modifier
                                .padding(6.dp)
                                .size(100.dp)
                                .selectable(
                                    selected = selected,
                                    onClick = { selectedOption.value = image }
                                )
                                .clip(shape = RoundedCornerShape(20.dp))
                                .border(
                                    width = 2.dp,
                                    color = if (selected) Color.Black else Color.Transparent,
                                    shape = RoundedCornerShape(20.dp)
                                )
                        ) {
                            Image(
                                painter = image,
                                contentDescription = "option",
                                modifier = Modifier.padding(8.dp)
                            )
                        }

                    }


                }
                if (count != null) {
                    if (selectedOption.value == images[2]) count += 1
                    else count += 0
                }

                Row(horizontalArrangement = Arrangement.Center) {

                    Button(
                        onClick = {
                            val intent = Intent(baseContext, ResultView::class.java)
                            intent.putExtra("count", count)
                            startActivity(intent)
                        },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.Black,
                            containerColor = Color.LightGray
                        )
                    ) {
                        Text(
                            text = "Ответить!",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

