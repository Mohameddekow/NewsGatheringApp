package com.dekow.newsgatheringapp.presentation.search.sections

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dekow.newsgatheringapp.R
import com.dekow.newsgatheringapp.domain.model.NewsItem




@Composable
fun NewsSectionListItem(
    searchNewsItem: NewsItem
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top,
    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(searchNewsItem.image)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.placeholder),
            contentDescription = searchNewsItem.title,
            modifier = Modifier
                .clip(RoundedCornerShape(7.dp))
                .size(height = 94.dp, width = 120.dp),
            contentScale = ContentScale.FillBounds,
            fallback = painterResource(id = R.drawable.placeholder)
        )

//        Image(
//            painter = rememberAsyncImagePainter(searchNewsItem.image),
//            contentDescription = searchNewsItem.title,
//            modifier = Modifier
//                .clip(RoundedCornerShape(7.dp))
//                .size(height = 94.dp, width = 120.dp),
//            contentScale = ContentScale.FillBounds
//        )

        Column(
            modifier = Modifier
                .padding(start = 7.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
        ) {

            //news headline
            searchNewsItem.headline?.let {
                Text(
                    text = it,
                    modifier = Modifier.padding(start = 4.dp, top = 1.dp),
                    fontWeight = FontWeight.Bold,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }

            //published on
            searchNewsItem.time?.let {
                Text(text = "published on $it", modifier = Modifier
                    .alpha(0.6f)
                    .padding(start = 4.dp, top = 3.dp))
            }

            //source and the author
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp, top = 2.dp, bottom = 3.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

                //source
                searchNewsItem.sourcePublication?.let {
                    Text(text = it, modifier = Modifier.alpha(0.6f))
                }

                //author
                searchNewsItem.author.let {
                    Text(text = it.toString() ?: " ", modifier = Modifier
                        .alpha(0.6f)
                        .padding(end = 20.dp))
                }
            }
        }
    }
}
