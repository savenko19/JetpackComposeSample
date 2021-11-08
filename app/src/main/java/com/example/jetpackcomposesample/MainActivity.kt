package com.example.jetpackcomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesample.data.News

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsCard(
                news = News(
                    title = "Jetpack Compose",
                    description = "It's composable function"
                )
            )
        }
    }

    @Composable
    fun NewsCard(news: News) {
        //Column fun lets you arrange elements vertically
        //Row fun to arrange items horizontally
        //Box fun to stack elements

        /*
        modifiers allow to change the composable's size,
        layout, appearance or add high-level interactions,
        such as making an element clickable
         */
        Row(modifier = Modifier.padding(all = 8.dp)) {

            Column {
                Text(text = news.title)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = news.description)
            }
            Spacer(modifier = Modifier.width(8.dp))

            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "News icon",
                modifier = Modifier
                    .size(40.dp)
                    .clip(RectangleShape)
            )
        }

    }
}
