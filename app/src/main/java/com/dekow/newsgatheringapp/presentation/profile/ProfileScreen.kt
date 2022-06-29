package com.dekow.newsgatheringapp.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.dekow.newsgatheringapp.R
import com.dekow.newsgatheringapp.domain.model.HomeBottomMenuItem
import com.dekow.newsgatheringapp.presentation.deatils.SharedNewsDetailsViewModel
import com.dekow.newsgatheringapp.presentation.home.HomeBottomMenu
import com.dekow.newsgatheringapp.presentation.home.HomeScreen
import com.dekow.newsgatheringapp.presentation.home.data
import com.dekow.newsgatheringapp.presentation.screen.Screens
import com.dekow.newsgatheringapp.ui.theme.LightModeBackgroundWhite


@Composable
fun ProfileScreen(
    navController: NavHostController,
    sharedNewsDetailsViewModel: SharedNewsDetailsViewModel

) {
    val darkTheme: Boolean = isSystemInDarkTheme()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        //profile navigation box
        Box(
            modifier = Modifier
                .background(color = if (!darkTheme) LightModeBackgroundWhite else Color.Black)
                .fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
            ) {
                //user profile
                ProfileItem(navController = navController)

                RowItems(
                    title = "My Location",
                    icon = R.drawable.ic_round_location_on_24,
                    modifier = Modifier
                )
                RowItems(
                    title = "Settings",
                    icon = R.drawable.ic_icons8_search_50,
                    modifier = Modifier
                )
                RowItems(
                    title = "Help",
                    icon = R.drawable.ic_round_help_outline_24,
                    modifier = Modifier
                )
                RowItems(title = "Support", icon = R.drawable.ic_round_call_24, modifier = Modifier)

            }

            //sing out row
            RowItems(
                title = "Signout",
                icon = R.drawable.ic_icons8_share_3__1_,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(bottom = 150.dp)
            )
        }

        //place holder box
        Box(
            modifier = Modifier
                .padding(start = 290.dp)
                //.fillMaxSize()
                .clip(RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp))
                .fillMaxHeight(0.65f)
                .background(Color.Blue)
                .alpha(1f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Gray)
            ) {

            }
        }

        //home screen background box
        Box(
            modifier = Modifier
                .padding(start = 300.dp)
                .clip(RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp))
                //.fillMaxSize()
                .fillMaxHeight(0.7f)
//                .clickable(enabled = false, onClickLabel = "hh", null, onClick = {})
                .background(Color.LightGray)
        ) {
            HomeScreen(
                navController = navController,
                sharedNewsDetailsViewModel = sharedNewsDetailsViewModel
            )
        }


        //profile home button menu
        HomeBottomMenu(
            navController = navController,
            items = listOf(
                HomeBottomMenuItem(title = "home", iconId = R.drawable.ic_icons8_home_48),
                HomeBottomMenuItem(title = "search", iconId = R.drawable.ic_icons8_search_50),
                HomeBottomMenuItem(title = "person", iconId = R.drawable.ic_icons8_contacts_32)
            ),
            modifier = Modifier.align(Alignment.BottomCenter),
            selectedItemIndex = 2
        )
    }

}


@Composable
fun ProfileItem(
    navController: NavHostController
) {
    val darkTheme: Boolean = isSystemInDarkTheme()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 80.dp, top = 30.dp, start = 20.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top,
        ) {


           Image(
                painter = painterResource(id = R.drawable.moha_profile),
                contentDescription = "profile image",
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .size(60.dp),
                contentScale = ContentScale.Crop
            )


            Column(
                modifier = Modifier
                    .padding(start = 7.dp),
                verticalArrangement = Arrangement.Center,
            ) {

                Text(
                    text = "Mohamed Dekow",
                    modifier = Modifier.padding(top = 3.dp),
                    fontWeight = FontWeight.Bold,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = "mohadekow@gmail.com", modifier = Modifier
                        .alpha(0.8f)
                        .padding(end = 20.dp)
                )
            }

        }


        IconButton(onClick = {
            navController.popBackStack()
        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_icons8_cancel_50),
                contentDescription = "search icon",
                modifier = Modifier
                    .padding(10.dp)
                    .size(37.dp),
                tint = if (darkTheme) LightModeBackgroundWhite else Color.Black
            )
        }
    }


}

@Composable
fun RowItems(
    icon: Int,
    title: String,
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .padding(start = 20.dp, bottom = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,

        ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "location",
            Modifier.size(25.dp)
        )
        Text(text = title, modifier = Modifier.padding(start = 10.dp))
    }
}
