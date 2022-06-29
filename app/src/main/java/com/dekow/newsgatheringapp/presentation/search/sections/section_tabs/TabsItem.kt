package com.dekow.newsgatheringapp.presentation.search.sections.section_tabs

import androidx.compose.runtime.Composable

typealias ComposableFun = @Composable () -> Unit

sealed class TabsItem(val title: String) {

    object AllNewsTab : TabsItem(title = "All")
    object FoodTab : TabsItem(title = "Food")
    object FootballTab : TabsItem(title = "Football")
    object TechnologyTab : TabsItem(title = "Technology")
    object PoliticsTab : TabsItem(title = "Politics")
    object ScienceTab : TabsItem(title = "Science")

}


