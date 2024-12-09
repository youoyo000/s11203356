package com.example.s411203356

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
//import androidx.compose.runtime.LaunchedEffec
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.delay
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

    // 記錄當前背景顏色的狀態
    val backgroundColor: MutableState<Color> = remember { mutableStateOf(Color(0xff95fe95)) }

    // 顏色列表
    val colors = listOf(
        Color(0xff95fe95), // 顏色1
        Color(0xfffdca0f), // 顏色2
        Color(0xfffea4a4), // 顏色3
        Color(0xffa5dfed)  // 顏色4
    )

    var currentColorIndex = remember { mutableStateOf(0) }

    // 用來追蹤遊戲時間的狀態
    val gameTime = remember { mutableStateOf(0) }

    // 使用 Coroutine 每秒更新遊戲時間
    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)  // 每秒更新一次
            gameTime.value += 1  // 遊戲時間增加
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor.value)
            .pointerInput(Unit) {
                detectTapGestures { tapOffset ->
                    // 判斷點擊位置：如果點擊左邊，切換到前一個顏色，點擊右邊切換到下一個顏色
                    if (tapOffset.x < size.width / 2) {
                        // 點擊左邊，切換到上一個顏色
                        currentColorIndex.value = (currentColorIndex.value - 1 + colors.size) % colors.size
                    } else {
                        // 點擊右邊，切換到下一個顏色
                        currentColorIndex.value = (currentColorIndex.value + 1) % colors.size
                    }
                    // 更新背景顏色
                    backgroundColor.value = colors[currentColorIndex.value]
                }
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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

            // 顯示遊戲持續時間
            Text(
                text = "遊戲持續時間 ${gameTime.value} 秒\n",
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
}
