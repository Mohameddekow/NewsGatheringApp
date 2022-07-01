package com.dekow.newsgatheringapp.presentation.screen

sealed class Screens(val route: String){
    object HomeScreen: Screens(route = "home_screen")
    object SearchScreen: Screens(route = "search_screen")
    object DisplaySearchedScreen: Screens(route = "display_search_screen")
    object ProfileScreen: Screens(route = "profile_screen")
    object DetailsScreen: Screens(route = "details_screen")
    object AllNewsScreen: Screens(route = "all_news_screen")
    object FoodScreen: Screens(route = "food_screen")
    object FootballScreen: Screens(route = "football_screen")
    object PoliticsScreen: Screens(route = "politics_screen")
    object ScienceScreen: Screens(route = "science_screen")
    object TechnologyScreen: Screens(route = "technology_screen")
    object  SectionScreen: Screens(route = "section_tbs_screen")
    object  TestScreen: Screens(route = "test_tbs_screen")
    object  TestSuchScreen: Screens(route = "test_such_tbs_screen")
}