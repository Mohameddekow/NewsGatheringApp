package com.dekow.newsgatheringapp.presentation.search


import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.dekow.newsgatheringapp.R
import com.dekow.newsgatheringapp.domain.model.HomeBottomMenuItem
import com.dekow.newsgatheringapp.presentation.deatils.SharedNewsDetailsViewModel
import com.dekow.newsgatheringapp.presentation.home.HomeBottomMenu
import com.dekow.newsgatheringapp.presentation.search.sections.section_tabs.SectionTabScreen
import com.dekow.newsgatheringapp.ui.theme.DetailsItemBackgroundWhite
import com.dekow.newsgatheringapp.ui.theme.LightModeBackgroundWhite
import com.dekow.newsgatheringapp.ui.theme.PurpleWhite
import com.google.accompanist.pager.ExperimentalPagerApi


@OptIn(ExperimentalPagerApi::class)
@Composable
fun SearchNewsScreen(
    navController: NavHostController,
    sharedNewsDetailsViewModel: SharedNewsDetailsViewModel
) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {


        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
        ) {

            SearchNewsBar(navController = navController)

            Column(
                modifier = Modifier
                    .padding(top = 20.dp, start = 15.dp, end = 15.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                SectionTabScreen(
                    navController = navController,
                    sharedNewsDetailsViewModel = sharedNewsDetailsViewModel,
                )

            }


        }


        HomeBottomMenu(
            navController = navController,
            items = listOf(
                HomeBottomMenuItem(title = "home", iconId = R.drawable.ic_icons8_home_48),
                HomeBottomMenuItem(title = "search", iconId = R.drawable.ic_icons8_search_50),
                HomeBottomMenuItem(title = "person", iconId = R.drawable.ic_icons8_contacts_32)
            ),
            modifier = Modifier.align(Alignment.BottomCenter),
            selectedItemIndex = 1
        )


    }
}

@Composable
fun SearchNewsBar(
    navController: NavHostController
) {
    var searchQuery by remember {
        mutableStateOf("")
    }

    val darkTheme: Boolean = isSystemInDarkTheme()

    Icon(
        painter = painterResource(id = R.drawable.ic_icons8_news__1_),
        contentDescription = "menu",
        modifier = Modifier
            .padding(start = 15.dp, top = 35.dp, bottom = 60.dp)
            .size(36.dp),
        tint = if (!darkTheme) Color.Black else PurpleWhite,
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, bottom = 2.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Discover",
            modifier = Modifier.padding(bottom = 6.dp),
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h3.fontSize,
        )
        Text(
            text = "News from all over the world",
            modifier = Modifier
                .padding(bottom = 20.dp)
                .alpha(0.6f),
        )

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .clip(RoundedCornerShape(7))
                .fillMaxWidth(0.99f)
                .background(color = if (!darkTheme) DetailsItemBackgroundWhite else LightModeBackgroundWhite),
            textStyle = TextStyle(
                color = if (darkTheme) Color.Black else Color.Black,
                fontSize = 20.sp
            ),
            placeholder = {
                Text(
                    text = "Search",
                    modifier = Modifier.alpha(0.6f),
                    color = if (darkTheme) Color.Black else Color.Black
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_icons8_search_50),
                    contentDescription = "search icon",
                    modifier = Modifier
                        .size(20.dp),
                    tint = if (darkTheme) Color.Black else Color.Black
                )
            },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_icons8_cancel_50),
                        contentDescription = "search icon",
                        modifier = Modifier
                            .size(20.dp),
                        tint = if (darkTheme) Color.Black else Color.Black
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    ///on Search
                }
            )
        )

    }
}
