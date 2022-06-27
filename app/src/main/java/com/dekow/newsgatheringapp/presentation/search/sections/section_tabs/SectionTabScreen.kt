package com.dekow.newsgatheringapp.presentation.search.sections.section_tabs

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dekow.newsgatheringapp.R
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

//val darkTheme: Boolean = isSystemInDarkTheme()


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalPagerApi::class, ExperimentalPagerApi::class)
@Composable
fun SectionTabScreen() {

    val tabs = listOf(
        TabsItem.FoodTab,
        TabsItem.FootballTab,
        TabsItem.TechnologyTab,
        TabsItem.PoliticsTab,
        TabsItem.ScienceTab,
        TabsItem.AllNewsTab
    )

    val pagerState = rememberPagerState()

    Scaffold{
        Column {
            Tabs(tabs = tabs, pagerState = pagerState)
            TabsContent(tabs = tabs, pagerState = pagerState)
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
        }){

        tabs.forEachIndexed { index, tab ->
            // OR LeadingIconTab()

            Tab(
                text = {
                    Text(
                        text = tab.title,
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        )},
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
fun TabsContent(tabs: List<TabsItem>, pagerState: PagerState) {
    HorizontalPager(state = pagerState, count = tabs.size) { page ->
        tabs[page].screen()
    }
}
