package com.dekow.newsgatheringapp.presentation.search.sections.section_tabs

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.dekow.newsgatheringapp.presentation.deatils.SharedNewsDetailsViewModel
import com.dekow.newsgatheringapp.presentation.search.sections.componets.*
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalPagerApi::class, ExperimentalPagerApi::class)
@Composable
fun SectionTabScreen(
    navController: NavHostController,
    sharedNewsDetailsViewModel: SharedNewsDetailsViewModel,
) {

    val tabs = listOf(
        TabsItem.FoodTab,
        TabsItem.FootballTab,
        TabsItem.TechnologyTab,
        TabsItem.PoliticsTab,
        TabsItem.ScienceTab,
        TabsItem.AllNewsTab
    )


    val pagerState = rememberPagerState()


    Scaffold {
        Column {

            Tabs(tabs = tabs, pagerState = pagerState)

            TabsContent(
                tabs = tabs,
                pagerState = pagerState,
                navController = navController,
                sharedNewsDetailsViewModel = sharedNewsDetailsViewModel,
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalPagerApi::class)
@Composable
fun Tabs(tabs: List<TabsItem>, pagerState: PagerState) {

    val scope = rememberCoroutineScope()
    // OR ScrollableTabRow()
    ScrollableTabRow(
        modifier = Modifier.fillMaxWidth(),
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = MaterialTheme.colors.background,
//        contentColor = Color.White,
        edgePadding = 0.dp,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }

    ) {
        tabs.forEachIndexed { index, tab ->
            // OR LeadingIconTab()
            Tab(
                text = {
                    Text(text = tab.title, fontSize = MaterialTheme.typography.h6.fontSize)
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }

}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(
    tabs: List<TabsItem>,
    pagerState: PagerState,
    navController: NavHostController,
    sharedNewsDetailsViewModel: SharedNewsDetailsViewModel,
) {

    HorizontalPager(state = pagerState, count = tabs.size) { page ->

        when (page) {
            0 -> FoodSectionLazyColumn(
                navController = navController,
                sharedNewsDetailsViewModel = sharedNewsDetailsViewModel
            )

            1 -> FootballSectionLazyColumn(
                navController = navController,
                sharedNewsDetailsViewModel = sharedNewsDetailsViewModel
            )

            2 -> TechnologySectionLazyColumn(
                navController = navController,
                sharedNewsDetailsViewModel = sharedNewsDetailsViewModel
            )

            3 -> PoliticsSectionLazyColumn(
                navController = navController,
                sharedNewsDetailsViewModel = sharedNewsDetailsViewModel
            )

            4 -> ScienceSectionLazyColumn(
                navController = navController,
                sharedNewsDetailsViewModel = sharedNewsDetailsViewModel
            )

            5 -> {
                AllNewsLazyColumn(
                    navController = navController,
                    sharedNewsDetailsViewModel = sharedNewsDetailsViewModel
                )

            }
        }
    }
}
