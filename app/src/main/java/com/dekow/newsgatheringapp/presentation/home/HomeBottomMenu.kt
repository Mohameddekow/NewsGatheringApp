package com.dekow.newsgatheringapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.dekow.newsgatheringapp.domain.model.HomeBottomMenuItem
import com.dekow.newsgatheringapp.presentation.screen.Screens
import com.dekow.newsgatheringapp.ui.theme.*


@Composable
fun HomeBottomMenu(
    navController: NavHostController,
    items: List<HomeBottomMenuItem>,
    modifier: Modifier = Modifier,
    activeItemColorInLightMode: Color = ActiveItemColorInLightMode,
    activeItemColorInDarkMode: Color = ActiveItemColorInDarkMode,
    selectedItemIndex: Int
) {
    val darkTheme: Boolean = isSystemInDarkTheme()

    var selectedItemIndex by remember{ mutableStateOf(selectedItemIndex) }

    Column(
        modifier = modifier.wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Divider(
            color = ActiveItemColorInLightMode,
            thickness = 2.dp,
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = modifier
                .background(
                    color = if (!darkTheme) LightModeBackgroundWhite else Color.Black
                )
                .padding(top = 7.dp, bottom = 8.dp, end = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            items.forEachIndexed { index, homeBottomMenuItem ->
                BottomMenuItem(
                    items = homeBottomMenuItem,
                    activeItemColorInLightMode = activeItemColorInLightMode,
                    activeItemColorInDarkMode = activeItemColorInDarkMode,
                    itemIsSelected = index == selectedItemIndex
                ){
                    selectedItemIndex = index

                    when (selectedItemIndex) {
                        0 -> {
                            navController.navigate(Screens.HomeScreen.route){
                                launchSingleTop = true

                                popUpTo(Screens.HomeScreen.route){
                                    inclusive = true
                                }
                            }
                        }
                        1 -> {
                            navController.navigate(Screens.SearchScreen.route ){
                                launchSingleTop = true

                                popUpTo(Screens.HomeScreen.route ){
                                    inclusive = false
                                }
                            }
                        }
                        else -> {
                            navController.navigate(Screens.ProfileScreen.route){

                                launchSingleTop = true

                                popUpTo(Screens.HomeScreen.route){
                                    inclusive = false
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun BottomMenuItem(
    items: HomeBottomMenuItem,
    activeItemColorInLightMode: Color,
    activeItemColorInDarkMode: Color,
    itemIsSelected: Boolean,
    onItemClick: () -> Unit
) {
    val darkTheme: Boolean = isSystemInDarkTheme()

    Box(
        modifier = Modifier
            .padding(vertical = 5.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable { onItemClick() }
            .background(
                color =
                if ((!darkTheme) && (itemIsSelected)) activeItemColorInLightMode
                else if ((darkTheme) && (itemIsSelected)) {
                    activeItemColorInDarkMode
                } else {
                    Color.Transparent
                } // nothing happens
            )
            .padding(4.dp),
        contentAlignment = Alignment.Center
    ) {

        Icon(
            painter = painterResource(id = items.iconId),
            contentDescription = items.title,
            modifier = Modifier
                .size(35.dp),
            tint =
            if (darkTheme){
                if (itemIsSelected) Color.Black else Color.White
            }else{
                if (itemIsSelected) Color.Black else Color.Black
            }

        )
    }

}
