package com.example.jetpacksample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.w3c.dom.NameList


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                NewsStory()
            }

        }
    }
}
@Composable
fun MyApp(content: @Composable () -> Unit) {
    MaterialTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}
@Composable
fun NewsStory(names: List<String> = listOf("News1", "News2","News3","News4","News5","News6","News7","News8")) {

            val typography = MaterialTheme.typography
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.header),
                    contentDescription = null,
                    modifier = Modifier
                        .height(180.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "A day wandering through the sand hills " +
                            "in Shark Fin Cove, and a few of the " +
                            "sights I saw", style = typography.h6,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    "Davenport, California", style = typography.body2
                )
                Text(
                    "December 2018", style = typography.body2
                ,color = Color.Yellow)

                Spacer(modifier = Modifier.height(16.dp))
                Column(modifier = Modifier.fillMaxHeight()) {
                    SubNewsList(names, Modifier.weight(1f))
                }
            }


}
@Composable
fun SubNewsList(names: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(items = names) { name ->
            News(name)
            Divider(color = Color.Black)
        }
    }
}
@Composable
fun News(news: String) {
    Text(text = news, modifier = Modifier.padding(24.dp))
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        NewsStory()
    }
}

