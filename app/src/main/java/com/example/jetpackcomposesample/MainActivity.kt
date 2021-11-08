package com.example.jetpackcomposesample

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesample.data.News
import com.example.jetpackcomposesample.data.news
import com.example.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeSampleTheme {
                NewsList(news)
            }
        }
    }


    @Composable
    fun NewsList(news: List<News>) {
        LazyColumn {
            items(news) { newsItem ->
                NewsCard(newsItem)
            }
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

        /*
        Material Design is built around three pillars: Color, Typography, Shape.
         */

        Box(
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth()
        ) {

            var isExpanded by remember { mutableStateOf(false) }
            val surfaceColor: Color by animateColorAsState(
                if (isExpanded) Color.DarkGray else Color.White
            )
            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                Text(
                    text = news.title,
                    color = Color.Gray,
                    style = MaterialTheme.typography.h5
                )
                Spacer(modifier = Modifier.height(4.dp))
                androidx.compose.material.Surface(
                    shape = MaterialTheme.shapes.medium,
                    elevation = 1.dp,
                    color = surfaceColor,
                    modifier = Modifier
                        .animateContentSize()
                        .padding(1.dp)
                ) {
                    Text(
                        text = news.description,
                        modifier = Modifier.padding(all = 4.dp).width(64.dp),
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.body2
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))


            val imageSize = if (isExpanded) 100.dp else 40.dp

            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "News icon",
                modifier = Modifier
                    .size(imageSize)
                    .clip(RectangleShape)
                    .border(2.dp, Color.DarkGray, RectangleShape)
                    .align(Alignment.CenterEnd)
            )
        }

    }

    @Preview(name = "Light Mode")
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )
    @Composable
    fun PreviewNewsCard() {
        JetpackComposeSampleTheme {
            NewsCard(
                news = News(
                    title = "Jetpack Compose",
                    description = "It's composable function"
                )
            )
        }
    }
}
