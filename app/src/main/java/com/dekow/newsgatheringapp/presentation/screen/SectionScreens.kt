package com.dekow.newsgatheringapp.presentation.screen

sealed class SectionScreens(val route: String){
    object FoodSectionScreen: Screens(route = "food_section_screen")
    object NavigateToSectionSpecified: Screens(route = "any_section_specified_screen")
}