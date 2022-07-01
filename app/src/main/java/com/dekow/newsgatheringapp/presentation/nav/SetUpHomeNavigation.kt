package com.dekow.newsgatheringapp.presentation.nav

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dekow.newsgatheringapp.presentation.deatils.DetailsScreen
import com.dekow.newsgatheringapp.presentation.deatils.SharedNewsDetailsViewModel
import com.dekow.newsgatheringapp.presentation.home.HomeScreen
import com.dekow.newsgatheringapp.presentation.profile.ProfileScreen
import com.dekow.newsgatheringapp.presentation.screen.Screens
import com.dekow.newsgatheringapp.presentation.search.DisplaySearchedNews
import com.dekow.newsgatheringapp.presentation.search.SearchNewsScreen
import com.dekow.newsgatheringapp.presentation.search.sections.componets.*


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SetUpHomeNavigation() {

    val navController: NavHostController = rememberNavController()
    val sharedNewsDetailsViewModel: SharedNewsDetailsViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route
    ) {


        /****
         *for the enterTransition, the entering destination is the target — the one you are applying the enterTransition to.
         * The opposite applies to the exitTransition: the initial screen is the one you are applying the exit transition to.
         *****/

        composable(
            route = Screens.HomeScreen.route
        ) {
            HomeScreen(
                navController = navController,
                sharedNewsDetailsViewModel = sharedNewsDetailsViewModel
            )
        }

        composable(
            route = Screens.DetailsScreen.route
        ) {
            DetailsScreen(
                navController = navController,
                sharedNewsDetailsViewModel = sharedNewsDetailsViewModel
            )
        }

        composable(
            route = Screens.SearchScreen.route
        ) {
            SearchNewsScreen(
                navController = navController,
                sharedNewsDetailsViewModel = sharedNewsDetailsViewModel
            )
        }
        composable(
            route = Screens.DisplaySearchedScreen.route + "/{q}"
        ) {
            DisplaySearchedNews(
                navController = navController,
                sharedNewsDetailsViewModel = sharedNewsDetailsViewModel
            )
        }

        composable(
            route = Screens.ProfileScreen.route
        ) {
            ProfileScreen(
                navController = navController,
                sharedNewsDetailsViewModel = sharedNewsDetailsViewModel
            )
        }


        composable(
            route = Screens.AllNewsScreen.route
        ) {
            AllNewsLazyColumn(
                navController = navController,
                sharedNewsDetailsViewModel = sharedNewsDetailsViewModel
            )
        }


        composable(
            route = Screens.FoodScreen.route
        ) {
            FoodSectionLazyColumn(
                navController = navController,
                sharedNewsDetailsViewModel = sharedNewsDetailsViewModel
            )
        }

        composable(
            route = Screens.FootballScreen.route
        ) {
            FootballSectionLazyColumn(
                navController = navController,
                sharedNewsDetailsViewModel = sharedNewsDetailsViewModel
            )
        }

        composable(
            route = Screens.PoliticsScreen.route
        ) {
            PoliticsSectionLazyColumn(
                navController = navController,
                sharedNewsDetailsViewModel = sharedNewsDetailsViewModel
            )
        }

        composable(
            route = Screens.ScienceScreen.route
        ) {
            ScienceSectionLazyColumn(
                navController = navController,
                sharedNewsDetailsViewModel = sharedNewsDetailsViewModel
            )
        }
        composable(
            route = Screens.TechnologyScreen.route
        ) {
            TechnologySectionLazyColumn(
                navController = navController,
                sharedNewsDetailsViewModel = sharedNewsDetailsViewModel
            )
        }

    }
}

