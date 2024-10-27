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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.selectable.ui.theme.SelectableTheme

class SecondQuestion : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val checked1 = remember {
                mutableStateOf(false)
            }

            val checked2 = remember {
                mutableStateOf(false)
            }

            val checked3 = remember {
                mutableStateOf(false)
            }

            val checked4 = remember {
                mutableStateOf(false)
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
                        text = "Какие из этих Русско-Турецких войн были при Екатерине Второй",
                        fontSize = 24.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.padding(top = 40.dp))

                Column {
                    Row(
                        modifier = Modifier.padding(start = 20.dp)
                    ) {
                        Checkbox(
                            checked = checked1.value,
                            onCheckedChange = {checked1.value = it},
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color.Gray, checkmarkColor = Color.Black
                            )
                        )
                        Text(
                            text = "Русско-Турецкая война 1735-1739",
                            fontSize = 24.sp
                        )
                    }

                    Row(
                        modifier = Modifier.padding(start = 20.dp)
                    ) {
                        Checkbox(
                            checked = checked2.value,
                            onCheckedChange = {checked2.value = it},
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color.Gray, checkmarkColor = Color.Black
                            )
                        )
                        Text(
                            text = "Русско-Турецкая война 1787-1791",
                            fontSize = 24.sp
                        )
                    }

                    Row(
                        modifier = Modifier.padding(start = 20.dp)
                    ) {
                        Checkbox(
                            checked = checked3.value,
                            onCheckedChange = {checked3.value = it},
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color.Gray, checkmarkColor = Color.Black
                            )
                        )
                        Text(
                            text = "Русско-Турецкая война 1806-1812",
                            fontSize = 24.sp
                        )
                    }

                    Row(
                        modifier = Modifier.padding(start = 20.dp)
                    ) {
                        Checkbox(
                            checked = checked4.value,
                            onCheckedChange = {checked4.value = it},
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color.Gray, checkmarkColor = Color.Black
                            )
                        )
                        Text(
                            text = "Русско-Турецкая война 1768-1774",
                            fontSize = 24.sp
                        )
                    }
                }

                if (count != null) {
                    if (checked1.value || checked3.value) count += 0
                    else if (checked2.value && checked4.value) count += 1

                }

                Row(horizontalArrangement = Arrangement.Center) {

                    Button(
                        onClick = {
                            val intent = Intent(baseContext, ThirdQuestion::class.java)
                            intent.putExtra("count", count)
                            startActivity(intent)
                        } ,
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

