package com.dekow.newsgatheringapp.presentation.search.sections.componets

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dekow.newsgatheringapp.R
import com.dekow.newsgatheringapp.domain.model.NewsDetailsItem
import com.dekow.newsgatheringapp.domain.model.NewsItem
import com.dekow.newsgatheringapp.presentation.ShimmerLoadingSectionNewsList
import com.dekow.newsgatheringapp.presentation.deatils.SharedNewsDetailsViewModel
import com.dekow.newsgatheringapp.presentation.search.sections.NewsSectionListItem
import com.dekow.newsgatheringapp.presentation.search.sections.SectionsViewModel

@Composable
fun FoodSectionLazyColumn(
    navController: NavHostController,
    sharedNewsDetailsViewModel: SharedNewsDetailsViewModel,

    ) {

    val sectionsViewModel: SectionsViewModel = hiltViewModel()

    val foodSectionState = sectionsViewModel.foodSectionsState.value

//    foodSectionState.news?.forEach { news ->
//        val newsDetails = NewsDetailsItem(
//            image = news.image,
//            title = news.title,
//            headline = news.headline,
//            time = news.time,
//            author = news.author,
//            authorsImage = news.authorsImage,
//            ratings = news.ratings,
//            sourcePublication = news.sourcePublication,
//            sectionName = news.sectionName,
//            bodyText = news.bodyText,
//            trailText = news.trailText,
//        )
//
//        sharedNewsDetailsViewModel.addDetails(newsDetails)
//    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        LazyColumn(
            contentPadding = PaddingValues(start = 4.dp, end = 4.dp, top = 15.dp, bottom = 70.dp),
            verticalArrangement = Arrangement.spacedBy(7.dp)
        ) {

            foodSectionState.news?.let {
                items(it) { news ->

                    NewsSectionListItem(
                        searchNewsItem = news,
                        navController = navController,
                        sharedNewsDetailsViewModel = sharedNewsDetailsViewModel
                    )
                }
            }

        }


        // show error if any
        if (foodSectionState.error.isNotBlank()) {
            Text(
                text = foodSectionState.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 20.dp)
                    .align(Alignment.TopCenter)
            )
        }

        //load shimmer
        if (foodSectionState.isLoading) {
            Column {
                repeat(10) {
                    ShimmerLoadingSectionNewsList()
                }
            }
        }

    }
}


@Composable
fun NewsSectionListItem2(
    searchNewsItem: NewsItem,
    navController: NavHostController,// = getNavController(),
    sharedNewsDetailsViewModel: SharedNewsDetailsViewModel,// = getSharedNewsDetailsViewModel(),

) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .clickable {

                val newsDetails = NewsDetailsItem(
                    image = null,//"searchNewsItem.image",
                    title = "searchNewsItem.title",
                    headline = searchNewsItem.headline,
                    time = "searchNewsItem.time",
                    author = "searchNewsItem.author",
                    authorsImage = "searchNewsItem.authorsImage",
                    ratings = "searchNewsItem.ratings",
                    sourcePublication = "searchNewsItem.sourcePublication",
                    sectionName = "searchNewsItem.sectionName",
                    bodyText = "searchNewsItem.bodyText",
                    trailText = "searchNewsItem.trailText",
                )

                sharedNewsDetailsViewModel.addDetails(newsDetails)

                Log.d("section det", newsDetails.headline.toString())

//                navController.navigate(route = Screens.TestScreen.route) {
//                    popUpTo(Screens.TestScreen.route) {
//                        inclusive = true
//                    }
//                }

            },
//            .clickable { onItemClick() },
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
                Text(
                    text = "published on $it", modifier = Modifier
                        .alpha(0.6f)
                        .padding(start = 4.dp, top = 3.dp)
                )
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
                    Text(
                        text = it.toString(), modifier = Modifier
                            .alpha(0.6f)
                            .padding(end = 20.dp)
                    )
                }
            }
        }
    }
}



