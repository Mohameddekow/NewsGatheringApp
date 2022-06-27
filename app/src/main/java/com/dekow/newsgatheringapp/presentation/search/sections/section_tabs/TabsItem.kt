package com.dekow.newsgatheringapp.presentation.search.sections.section_tabs

import androidx.compose.runtime.Composable
import com.dekow.newsgatheringapp.presentation.search.sections.componets.*

typealias ComposableFun = @Composable () -> Unit

sealed class TabsItem(val title: String, val screen: ComposableFun){
    object AllNewsTab: TabsItem(title = "All", { AllNewsLazyColumn() })
    object FoodTab: TabsItem(title = "Food", {FoodSectionLazyColumn()})
    object FootballTab: TabsItem(title = "Football",  { FootballSectionLazyColumn() })
    object TechnologyTab: TabsItem(title = "Technology",  { TechnologySectionLazyColumn() })
    object PoliticsTab: TabsItem(title = "Politics",  { PoliticsSectionLazyColumn() })
    object ScienceTab: TabsItem(title = "Science",  { ScienceSectionLazyColumn() })
}
