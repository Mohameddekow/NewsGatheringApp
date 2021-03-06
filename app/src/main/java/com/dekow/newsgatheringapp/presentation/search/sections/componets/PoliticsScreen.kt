package com.dekow.newsgatheringapp.presentation.search.sections.componets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.dekow.newsgatheringapp.presentation.ShimmerLoadingSectionNewsList
import com.dekow.newsgatheringapp.presentation.deatils.SharedNewsDetailsViewModel
import com.dekow.newsgatheringapp.presentation.search.sections.NewsSectionListItem
import com.dekow.newsgatheringapp.presentation.search.sections.SectionsViewModel

@Composable
fun PoliticsSectionLazyColumn(
    navController: NavHostController,
    sharedNewsDetailsViewModel: SharedNewsDetailsViewModel,
) {

    val sectionsViewModel: SectionsViewModel = hiltViewModel()

    val politicsState = sectionsViewModel.politicsSectionsState.value

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        LazyColumn(
            contentPadding = PaddingValues(start = 4.dp, end = 4.dp, top = 15.dp, bottom = 70.dp),
            verticalArrangement = Arrangement.spacedBy(7.dp)
        ) {

            politicsState.news?.let {
                items(it) { news ->
                    NewsSectionListItem(
                        searchNewsItem = news,
                        navController = navController,
                        sharedNewsDetailsViewModel = sharedNewsDetailsViewModel
                    )

                }
            }

        }


        //show error if any
        if (politicsState.error.isNotBlank()) {
            Text(
                text = politicsState.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 20.dp)
                    .align(Alignment.TopCenter)
            )
        }

        //load shimmer
        if (politicsState.isLoading) {
            Column{
                repeat(10){
                    ShimmerLoadingSectionNewsList()
                }
            }
        }
    }

}