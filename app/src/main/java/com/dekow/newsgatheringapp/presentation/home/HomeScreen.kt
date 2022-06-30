package com.dekow.newsgatheringapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dekow.newsgatheringapp.R
import com.dekow.newsgatheringapp.commons.DammyData
import com.dekow.newsgatheringapp.domain.model.HomeBottomMenuItem
import com.dekow.newsgatheringapp.domain.model.NewsDetailsItem
import com.dekow.newsgatheringapp.domain.model.NewsItem
import com.dekow.newsgatheringapp.presentation.ShimmerLoadingBreakingNews
import com.dekow.newsgatheringapp.presentation.ShimmerLoadingBreakingNewsList
import com.dekow.newsgatheringapp.presentation.deatils.SharedNewsDetailsViewModel
import com.dekow.newsgatheringapp.presentation.screen.Screens
import com.dekow.newsgatheringapp.ui.theme.Test

val data = DammyData.data

@Composable
fun HomeScreen(
    navController: NavHostController,
    sharedNewsDetailsViewModel: SharedNewsDetailsViewModel
) {

    val homeViewModel: HomeViewModel = hiltViewModel()

    val breakingNewsState = homeViewModel.breakingNewsState.value

    val breakingNewsListState = homeViewModel.breakingNewsListState.value


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ) {


            //news of the day box(breaking news)
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                //load shimmer
                if (breakingNewsState.isLoading) {
                    ShimmerLoadingBreakingNews()
                }
                //show error if any
                if (breakingNewsState.error.isNotBlank()) {
                    ShimmerLoadingBreakingNews()
                    Text(
                        text = breakingNewsState.error,
                        color = MaterialTheme.colors.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 20.dp)
                            .align(Alignment.TopCenter)
                    )
                }

                //news of the day
                breakingNewsState.news?.let {
                    NewsOfTheDay(
                        navController = navController,
                        breakingNews = it,
                        sharedNewsDetailsViewModel = sharedNewsDetailsViewModel
                    )
                }

            }


            //breaking news list
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                if (breakingNewsListState.isLoading) {
                    Row(
                        modifier = Modifier
                            .padding(start = 16.dp, top = 18.dp, end = 10.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Breaking News",
                            fontSize = 21.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                        Text(text = "More", fontSize = 17.sp, fontWeight = FontWeight.Bold)
                    }
                    Row {
                        repeat(6) {
                            ShimmerLoadingBreakingNewsList()
                        }
                    }
                }

                //show error if any
                if (breakingNewsListState.error.isNotBlank()) {
                    Row {
                        repeat(6) {
                            ShimmerLoadingBreakingNewsList()
                        }
                    }
                    Text(
                        text = breakingNewsState.error,
                        color = MaterialTheme.colors.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 20.dp)
                            .align(Alignment.TopCenter)
                    )
                }

                //breaking news list
                breakingNewsListState.news?.let {
                    BreakingNews(
                        navController = navController,
                        breakingNewsList = it,
                        sharedNewsDetailsViewModel = sharedNewsDetailsViewModel
                    )
                }
            }


        }

        HomeBottomMenu(
            navController = navController,
            items = listOf(
                HomeBottomMenuItem(title = "home", iconId = R.drawable.ic_icons8_home_48),
                HomeBottomMenuItem(title = "search", iconId = R.drawable.ic_icons8_search_50),
                HomeBottomMenuItem(title = "person", iconId = R.drawable.ic_icons8_contacts_32)
            ),
            modifier = Modifier.align(Alignment.BottomCenter),
            selectedItemIndex = 0
        )
    }

}

@Composable
fun NewsOfTheDay(
    navController: NavHostController,
    breakingNews: List<NewsItem>,
    sharedNewsDetailsViewModel: SharedNewsDetailsViewModel
) {

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
            .fillMaxHeight(0.42f)
            .fillMaxWidth(),
    ) {


        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(breakingNews[0].image)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.placeholder),
            contentDescription = "image",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .alpha(1f),
            contentScale = ContentScale.FillBounds,
            fallback = painterResource(id = R.drawable.placeholder)
        )

        IconButton(
            modifier = Modifier.padding(start = 15.dp, top = 25.dp),
            onClick = {
                navController.navigate(Screens.ProfileScreen.route) {
                    popUpTo(Screens.ProfileScreen.route) {
                        inclusive = true
                    }
                }
            }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_icons8_menu_60),
                contentDescription = "menu",
                modifier = Modifier
                    .size(36.dp),
                tint = Color.White,
            )
        }


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

            breakingNews[0].headline?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .padding(bottom = 15.dp, end = 5.dp)
                        .fillMaxWidth(0.9f),
                    textAlign = TextAlign.Start,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    color = Color.White,
                    maxLines = 3,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                )
            }

            //learn more row(details)
            Row(
                modifier = Modifier
                    .padding(bottom = 15.dp, top = 5.dp, start = 2.dp, end = 2.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {
                        val newsDetails = NewsDetailsItem(
                            image = breakingNews[0].image,
                            title = breakingNews[0].title,
                            headline = breakingNews[0].headline,
                            time = breakingNews[0].time,
                            author = breakingNews[0].author,
                            authorsImage = breakingNews[0].authorsImage,
                            ratings = breakingNews[0].ratings,
                            sourcePublication = breakingNews[0].sourcePublication,
                            sectionName = breakingNews[0].sectionName,
                            bodyText = breakingNews[0].bodyText,
                            trailText = breakingNews[0].trailText,
                            body = breakingNews[0].body,
                            productionOffice = breakingNews[0].productionOffice,
                            lastModified = breakingNews[0].lastModified,

                            )

                        sharedNewsDetailsViewModel.addDetails(newsDetails)

                        navController.navigate(route = Screens.DetailsScreen.route) {
                            popUpTo(Screens.DetailsScreen.route) {
                                inclusive = true
                            }
                        }
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            )
            {
                Text(
                    text = "Learn More",
                    modifier = Modifier
                        .padding(end = 5.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )
                Icon(
                    painter = painterResource(id = R.drawable.icons8_right_arrow_50),
                    tint = Color.White,
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .size(40.dp),
                    contentDescription = "learn more arrow"
                )

            }
        }

    }

}


@Composable
fun BreakingNews(
    navController: NavHostController,
    breakingNewsList: List<NewsItem>,
    sharedNewsDetailsViewModel: SharedNewsDetailsViewModel
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 15.dp),
        // .fillMaxHeight(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
    ) {

        //breaking news row headline
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
                fontSize = 21.sp,
                fontWeight = FontWeight.ExtraBold,
            )

            Text(
                text = "More",
                modifier = Modifier
                    .padding(4.dp)
                    .clickable {
                        navController.navigate(route = Screens.SearchScreen.route) {
                            popUpTo(Screens.SearchScreen.route) {
                                inclusive = true
                            }
                        }
                    },
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
            )

        }


        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(end = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            items(breakingNewsList) { news ->
                NewsRowItem(
                    breakingNews = news,
                    sharedNewsDetailsViewModel = sharedNewsDetailsViewModel,
                    navController = navController
                )
            }
        }

    }

}

@Composable
fun NewsRowItem(
    breakingNews: NewsItem,
    navController: NavHostController,
    sharedNewsDetailsViewModel: SharedNewsDetailsViewModel
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .clickable {
                val newsDetails = NewsDetailsItem(
                    image = breakingNews.image,
                    title = breakingNews.title,
                    headline = breakingNews.headline,
                    time = breakingNews.time,
                    author = breakingNews.author,
                    authorsImage = breakingNews.authorsImage,
                    ratings = breakingNews.ratings,
                    sourcePublication = breakingNews.sourcePublication,
                    sectionName = breakingNews.sectionName,
                    bodyText = breakingNews.bodyText,
                    trailText = breakingNews.trailText,
                    body = breakingNews.body,
                    productionOffice = breakingNews.productionOffice,
                    lastModified = breakingNews.lastModified,
                )

                sharedNewsDetailsViewModel.addDetails(newsDetails)

                navController.navigate(route = Screens.DetailsScreen.route) {
                    popUpTo(Screens.DetailsScreen.route) {
                        inclusive = true
                    }
                }
            }
    ) {

        breakingNews.let {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(it.image)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.placeholder),
                contentDescription = "newsImage",
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .width(180.dp)
                    .height(125.dp),
                contentScale = ContentScale.FillBounds,
                fallback = painterResource(id = R.drawable.placeholder)
            )

            Text(
                text = it.headline.toString(),
                modifier = Modifier
                    .padding(top = 7.dp)
                    .width(160.dp),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis,
            )

            Text(
                text = it.time.toString(),
                modifier = Modifier
                    .alpha(0.6f)
                    .padding(top = 6.dp),
                textAlign = TextAlign.Start,
            )

            Text(
                text = it.author.toString(),
                modifier = Modifier
                    .alpha(0.6f)
                    .width(180.dp)
                    .padding(top = 6.dp, bottom = 3.dp),
                textAlign = TextAlign.Start,
            )

        }

    }

}
