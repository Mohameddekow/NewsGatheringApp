package com.dekow.newsgatheringapp.presentation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dekow.newsgatheringapp.presentation.screen.SectionScreens
import com.dekow.newsgatheringapp.presentation.search.sections.componets.FoodSectionLazyColumn
import com.dekow.newsgatheringapp.presentation.search.sections.using_lazyrow.NavigateToSectionSpecified

@Composable
fun SetUpNewsSectionNavigation(
    sectionNavController: NavHostController
) {

    NavHost(
        navController = sectionNavController,
        startDestination = SectionScreens.FoodSectionScreen.route
    ){

        composable(route = SectionScreens.FoodSectionScreen.route ){
            FoodSectionLazyColumn()
        }

        composable(route = SectionScreens.NavigateToSectionSpecified.route + "/{section}" ){
            NavigateToSectionSpecified()
        }
    }

}