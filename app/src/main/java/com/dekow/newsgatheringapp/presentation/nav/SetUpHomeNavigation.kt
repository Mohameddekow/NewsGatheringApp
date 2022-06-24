package com.dekow.newsgatheringapp.presentation.nav

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.dekow.newsgatheringapp.presentation.deatils.DetailsScreen
import com.dekow.newsgatheringapp.presentation.home.HomeScreen
import com.dekow.newsgatheringapp.presentation.profile.ProfileScreen
import com.dekow.newsgatheringapp.presentation.screen.Screens
import com.dekow.newsgatheringapp.presentation.search.SearchNewsScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.navigation
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SetUpHomeNavigation() {
    val navController = rememberAnimatedNavController()

    AnimatedNavHost(
        navController = navController,
        startDestination = Screens.SearchScreen.route
    ){


        /****
         *for the enterTransition, the entering destination is the target — the one you are applying the enterTransition to.
         * The opposite applies to the exitTransition: the initial screen is the one you are applying the exit transition to.
         *****/

        composable(
            route = Screens.HomeScreen.route,

            //entering the home screen from different screen(navigating into home screen)
//            enterTransition = { _, _ ->
//                slideInHorizontally(
//                    initialOffsetX = { 300 },
//                    animationSpec = tween(300)
//                ) + fadeIn(animationSpec = tween(300))
//            },
//
//            //leaving the home screen for other screens
//            exitTransition = {
//                slideOutHorizontally(
//                    targetOffsetX = { -300 },
//                    animationSpec = tween(300)
//                ) //+ fadeOut(animationSpec = tween(300))
//            },
//
//
//            //bring Home screen back when back bottom is clicked
//            popEnterTransition = {
//                slideInHorizontally(
//                    initialOffsetX = { -300 },
//                    animationSpec = tween(300)
//                ) + fadeIn(animationSpec = tween(300))
//            },

        ) {
            HomeScreen(
                navController = navController,
            )
        }

        composable(
            route = Screens.DetailsScreen.route,

//            //entering this screen from another
//            enterTransition = {
//                slideInHorizontally (
//                    initialOffsetX = {300},
//                    animationSpec = tween(
//                        durationMillis = 300,
//                        easing = FastOutSlowInEasing
//                    )
//                ) + fadeIn(animationSpec = tween(300))
//            },
//
//            //leaving this screen for another
//            exitTransition = {
//                slideOutHorizontally (
//                    targetOffsetX = {300},
//                    animationSpec = tween(
//                        durationMillis = 300,
//                        easing = FastOutSlowInEasing
//                    )
//                ) //+ fadeOut(animationSpec = tween(300))
//            },
//
//            //enter this screen on clicking back button
//            popEnterTransition = {
//                slideInHorizontally (
//                    initialOffsetX = {-300},
//                    animationSpec = tween(
//                        durationMillis = 300,
//                        easing = FastOutSlowInEasing
//
//                    )
//                ) + fadeIn(animationSpec = tween(300))
//            },
//
//            //leaving this with back icon and removing it from back stack
//            popExitTransition = {
//                slideOutHorizontally (
//                    targetOffsetX = {300},
//                    animationSpec = tween(
//                        durationMillis = 300,
//                        easing = FastOutSlowInEasing
//                    )
//                ) + fadeOut(animationSpec = tween(300))
//            }
        ){
            DetailsScreen(navController = navController)
        }

        composable(
            route = Screens.SearchScreen.route,

//            enterTransition = {
//                slideInHorizontally (
//                    initialOffsetX = {300},
//                    animationSpec = tween(
//                        durationMillis = 300,
//                        easing = FastOutSlowInEasing
//                    )
//                ) + fadeIn(animationSpec = tween(300))
//            },
//
//            exitTransition = {
//                slideOutHorizontally (
//                    targetOffsetX = {-300},
//                    animationSpec = tween(
//                        durationMillis = 300,
//                        easing = FastOutSlowInEasing
//                    )
//                ) //+ fadeOut(animationSpec = tween(300))
//            },
//
//            popEnterTransition = {
//                slideInHorizontally (
//                    initialOffsetX = {-300},
//                    animationSpec = tween(
//                        durationMillis = 300,
//                        easing = FastOutSlowInEasing
//                    )
//                ) + fadeIn(animationSpec = tween(300))
//            },
//
//            popExitTransition = {
//                slideOutHorizontally (
//                    targetOffsetX = {300},
//                    animationSpec = tween(
//                        durationMillis = 300,
//                        easing = FastOutSlowInEasing
//                    )
//                ) + fadeOut(animationSpec = tween(300))
//            }
        ){
            SearchNewsScreen(navController = navController)
        }

        composable(
            route = Screens.ProfileScreen.route,

//            enterTransition = {
//                slideInHorizontally (
//                    initialOffsetX = {300},
//                    animationSpec = tween(
//                        durationMillis = 300,
//                        easing = FastOutSlowInEasing
//
//                    )
//                ) + fadeIn(animationSpec = tween(300))
//            },
//
//            exitTransition = {
//                slideOutHorizontally (
//                    targetOffsetX = {-300},
//                    animationSpec = tween(
//                        durationMillis = 300,
//                        easing = FastOutSlowInEasing
//                    )
//                ) //+ fadeOut(animationSpec = tween(300))
//            },
//
//            popEnterTransition = {
//                slideInHorizontally (
//                    initialOffsetX = {-300},
//                    animationSpec = tween(
//                        durationMillis = 300,
//                        easing = FastOutSlowInEasing
//
//                    )
//                ) + fadeIn(animationSpec = tween(300))
//            },
//            popExitTransition = {
//                slideOutHorizontally (
//                    targetOffsetX = {300},
//                    animationSpec = tween(
//                        durationMillis = 300,
//                        easing = FastOutSlowInEasing
//                    )
//                ) + fadeOut(animationSpec = tween(300))
//            }
        ){
            ProfileScreen(navController = navController)
        }

    }
}

