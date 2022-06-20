package com.dekow.newsgatheringapp.presentation.screen

sealed class Screens(val route: String){
    object HomeScreen: Screens(route = "home_screen")
    object SearchScreen: Screens(route = "search_screen")
    object ProfileScreen: Screens(route = "profile_screen")
    object DetailsScreen: Screens(route = "details_screen")
}