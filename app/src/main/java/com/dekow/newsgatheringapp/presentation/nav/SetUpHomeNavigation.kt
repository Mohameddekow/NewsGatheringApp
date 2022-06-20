package com.dekow.newsgatheringapp.presentation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dekow.newsgatheringapp.presentation.deatils.DetailsScreen
import com.dekow.newsgatheringapp.presentation.home.HomeScreen
import com.dekow.newsgatheringapp.presentation.profile.ProfileScreen
import com.dekow.newsgatheringapp.presentation.screen.Screens
import com.dekow.newsgatheringapp.presentation.search.SearchNewsScreen

@Composable
fun SetUpHomeNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route
    ){

        composable(route = Screens.HomeScreen.route){
            HomeScreen(navController = navController)
        }

        composable(route = Screens.DetailsScreen.route){
            DetailsScreen(navController = navController)
        }

        composable(route = Screens.ProfileScreen.route){
            ProfileScreen(navController = navController)
        }

        composable(route = Screens.SearchScreen.route){
            SearchNewsScreen(navController = navController)
        }
    }
}