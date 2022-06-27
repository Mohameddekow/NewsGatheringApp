package com.dekow.newsgatheringapp.presentation.nav

import androidx.compose.animation.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dekow.newsgatheringapp.presentation.deatils.DetailsScreen
import com.dekow.newsgatheringapp.presentation.home.HomeScreen
import com.dekow.newsgatheringapp.presentation.profile.ProfileScreen
import com.dekow.newsgatheringapp.presentation.screen.Screens
import com.dekow.newsgatheringapp.presentation.search.SearchNewsScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SetUpHomeNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route
    ){


        /****
         *for the enterTransition, the entering destination is the target — the one you are applying the enterTransition to.
         * The opposite applies to the exitTransition: the initial screen is the one you are applying the exit transition to.
         *****/

        composable(
            route = Screens.HomeScreen.route
        ) {
            HomeScreen(
                navController = navController,
            )
        }

        composable(
            route = Screens.DetailsScreen.route
        ){
            DetailsScreen(navController = navController)
        }

        composable(
            route = Screens.SearchScreen.route
        ){
            SearchNewsScreen(navController = navController)
        }

        composable(
            route = Screens.ProfileScreen.route
        ){
            ProfileScreen(navController = navController)
        }

    }
}

