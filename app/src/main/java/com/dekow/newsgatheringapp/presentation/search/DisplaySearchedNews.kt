package com.dekow.newsgatheringapp.presentation.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.dekow.newsgatheringapp.R
import com.dekow.newsgatheringapp.presentation.ShimmerLoadingSectionNewsList
import com.dekow.newsgatheringapp.presentation.deatils.SharedNewsDetailsViewModel
import com.dekow.newsgatheringapp.presentation.search.sections.NewsSectionListItem
import com.dekow.newsgatheringapp.presentation.search.use_case.SearchNewsViewModel

@Composable
fun DisplaySearchedNews(
    navController: NavHostController,
    sharedNewsDetailsViewModel: SharedNewsDetailsViewModel
) {


    val searchViewModel: SearchNewsViewModel = hiltViewModel()

    val searchNewsState = searchViewModel.searchNewsState.value

    Box(
        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Top
    ) {

        val args = sharedNewsDetailsViewModel.searchedKeyWord

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, top = 5.dp, bottom = 5.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            //back arrow
            IconButton(
                modifier = Modifier.padding(end = 7.dp),
                onClick = { navController.popBackStack() }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icons8_left_arrow_50),
                    contentDescription = "back arrow",
                    modifier = Modifier
                        .size(40.dp),
                    tint = Color.White,
                )
            }

            Text(
                text = "Search news",
                modifier = Modifier,
                // .padding(start = 14.dp, end = 16.dp, top = 17.dp, bottom = 7.dp),
                fontWeight = FontWeight.Bold,
               // textAlign = TextAlign.Center,
                fontSize = 20.sp
            )

        }

        Column(
            modifier = Modifier.padding(top = 60.dp)
        ) {
            searchNewsState.news?.let {
                Text(
                    text = "Showing results for \"$args\" news",
                    modifier = Modifier
                        .padding(start = 15.dp, end = 16.dp, top = 1.dp, bottom = 7.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            }


            LazyColumn(
                contentPadding = PaddingValues(
                    start = 4.dp,
                    end = 4.dp,
                    top = 15.dp,
                    bottom = 70.dp
                ),
                verticalArrangement = Arrangement.spacedBy(7.dp)
            ) {

                searchNewsState.news?.let {
                    items(it) { news ->

                        NewsSectionListItem(
                            searchNewsItem = news,
                            navController = navController,
                            sharedNewsDetailsViewModel = sharedNewsDetailsViewModel
                        )

                    }
                }

            }
        }




        // show error if any
        if (searchNewsState.error.isNotBlank()) {
            Text(
                text = searchNewsState.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        //load shimmer
        if (searchNewsState.isLoading) {
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 60.dp)
            ) {

                Text(
                    text = "Loading results for \"$args\" news",
                    modifier = Modifier
                        .padding(start = 4.dp, end = 16.dp, bottom = 7.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                repeat(10) {
                    ShimmerLoadingSectionNewsList()
                }
            }
        }

    }
}