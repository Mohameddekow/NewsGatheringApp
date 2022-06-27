package com.dekow.newsgatheringapp.presentation.search.sections.using_lazyrow

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
import com.dekow.newsgatheringapp.presentation.search.sections.NewsSectionListItem
import com.dekow.newsgatheringapp.presentation.search.sections.SectionsViewModel

@Composable
fun NavigateToSectionSpecified() {

    val sectionsViewModel: SectionsViewModel = hiltViewModel()

    val sectionsState =  sectionsViewModel.sectionsState.value


    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            contentPadding = PaddingValues(start = 4.dp, end = 4.dp, top = 15.dp, bottom = 70.dp),
            verticalArrangement = Arrangement.spacedBy(7.dp)
        ){
            sectionsState.news?.let {
                items(it){ news ->
                    NewsSectionListItem(searchNewsItem = news)
                }
            }

        }


        // error or loading state
        if(sectionsState.error.isNotBlank()) {
            Text(
                text = sectionsState.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.TopCenter)
            )
        }
        if(sectionsState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.TopCenter))
        }
    }

}