package com.dekow.newsgatheringapp.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dekow.newsgatheringapp.R
import com.dekow.newsgatheringapp.commons.DammyData
import com.dekow.newsgatheringapp.domain.model.NewsItem
import com.dekow.newsgatheringapp.ui.theme.*

val data = DammyData.data
val dataList = DammyData.dataList

@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {

        NewsOfTheDay()
        BreakingNews()

    }
}

@Composable
fun NewsOfTheDay() {

    Box(
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomStart = 25.dp,
                    bottomEnd = 25.dp
                )
            )
            .fillMaxHeight(0.4f)
            .fillMaxWidth(),
    ) {

        Image(
            painter = painterResource(R.drawable.newimageplaceholder),
            contentDescription = "image",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .alpha(1f),
            contentScale = ContentScale.FillBounds,
        )

        Icon(
            imageVector = Icons.Rounded.Menu,
            contentDescription = "menu",
            modifier = Modifier
                .padding(start = 15.dp, top = 25.dp)
                .size(36.dp),
            tint = Color.White,
        )

        Column(
            modifier = Modifier
                .padding(start = 15.dp, top = 90.dp, end = 15.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 3.dp, bottom = 10.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(Test),
            ) {
                Text(
                    text = "New of the day",
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
                    color = Color.White
                )
            }

            Text(
                text = data.desc,
                modifier = Modifier
                    .padding(bottom = 15.dp, end = 25.dp),
                textAlign = TextAlign.Start,
                fontSize = MaterialTheme.typography.h5.fontSize,
                color = Color.White,
            )

            Row (modifier = Modifier
                .padding(bottom = 15.dp, top = 5.dp),
                horizontalArrangement = Arrangement.Start)
            {
                Text(
                    text = "Learn More",
                    modifier = Modifier.padding(end = 5.dp),
                    color = Color.White,
                )
                Icon(
                    imageVector = Icons.Rounded.ArrowForward,
                    tint = Color.White,
                    contentDescription = "learn more arrow"
                )
            }
        }

    }

}

@Composable
fun BreakingNews() {
    Column(
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .fillMaxHeight(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
    ) {

        Row(
            modifier = Modifier
                .padding(vertical = 18.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            ) {

            Text(
                text = "Breaking News",
                modifier = Modifier
                    .padding(vertical = 4.dp),
                textAlign = TextAlign.Center,
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = "More",
                modifier = Modifier
                    .padding(4.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
            )

        }

        LazyRow(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(end = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            items(dataList) { news ->
                NewsRowItem(newsItem = news)
            }
        }

    }

}

@Composable
fun NewsRowItem(
    newsItem: NewsItem
) {
    Column(
        modifier = Modifier
    ) {
        Image(
            painter = painterResource(id = newsItem.image),
            contentDescription = "newsImage",
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .width(180.dp)
                .height(120.dp)
        )

        Text(
            text = newsItem.desc,
            modifier = Modifier
                .padding(top = 7.dp)
                .width(160.dp),
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
        )

        Text(
            text = newsItem.time,
            modifier = Modifier
                .alpha(0.6f)
                .padding(top = 6.dp),
            textAlign = TextAlign.Start,
        )

        Text(
            text = newsItem.author,
            modifier = Modifier
                .alpha(0.6f)
                .padding(top = 6.dp),
            textAlign = TextAlign.Start,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HomePev() {
    NewsOfTheDay()
    BreakingNews()
}