package com.example.s411203356

import android.app.Activity
import android.content.pm.ActivityInfo
import android.content.pm.ActivityInfo.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.s411203356.ui.theme.S411203356Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S411203356Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                   )
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val activity = (LocalContext.current as? Activity)
    Box (
        Modifier.fillMaxSize()
            .background(Color(0xff95fe95))

    )
        Column (horizontalAlignment = Alignment.CenterHorizontally){


            Text(
              text = "2024期末上機考(資管二B李宥萱)\n",
              modifier = modifier
          )

          Image(
              painter = painterResource(id = R.drawable.class_b),
              contentDescription = "圖片",
              modifier = Modifier
                  .background(Color.Black)
          )
          Text(
              text = "遊戲持續時間 0 秒\n",
              modifier = modifier
          )
          Text(
              text = "您的成績 0 分\n",
              modifier = modifier
          )
            Button(
                  onClick = {
                      activity?.finish()
                  }
                  ) {
              Text("結束App")
          }



        }

}

