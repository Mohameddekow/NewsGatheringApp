package com.dekow.newsgatheringapp.presentation.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.dekow.newsgatheringapp.R
import com.dekow.newsgatheringapp.domain.model.HomeBottomMenuItem
import com.dekow.newsgatheringapp.domain.model.NewsCategoryItem
import com.dekow.newsgatheringapp.domain.model.NewsItem
import com.dekow.newsgatheringapp.presentation.home.HomeBottomMenu
import com.dekow.newsgatheringapp.presentation.home.data
import com.dekow.newsgatheringapp.presentation.home.dataList
import com.dekow.newsgatheringapp.presentation.screen.Screens
import com.dekow.newsgatheringapp.ui.theme.*

val myItemsList = listOf<NewsCategoryItem>(
    NewsCategoryItem("Technology"),
    NewsCategoryItem("Health"),
    NewsCategoryItem("Politics"),
    NewsCategoryItem("Football"),
    NewsCategoryItem("Science"),
    NewsCategoryItem("Food")
)
@Composable
fun SearchNewsScreen(
    navController: NavHostController
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
        ) {
            SearchNews(navController = navController)
            NewCategory(myItems = myItemsList)
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
fun SearchNews(
    navController: NavHostController
) {
    var searchQuery by remember {
        mutableStateOf("")
    }

    val darkTheme: Boolean = isSystemInDarkTheme()

    Icon(
        painter = painterResource(id = R.drawable.ic_icons8_menu_60),
        contentDescription = "menu",
        modifier = Modifier
            .padding(start = 15.dp, top = 35.dp)
            .size(36.dp)
            .clickable {
               navController.navigate(Screens.ProfileScreen.route){
                   popUpTo(Screens.ProfileScreen.route){
                       inclusive = true
                   }
               }
            },
        tint = if (!darkTheme) Color.Black else PurpleWhite,
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 70.dp, bottom = 20.dp),
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
            onValueChange = {
                searchQuery = it
            },
            modifier = Modifier
                .clip(RoundedCornerShape(7))
                .fillMaxWidth(0.99f)
                .background(color = if (!darkTheme) DetailsItemBackgroundWhite else LightModeBackgroundWhite),

            textStyle = TextStyle(color = if (darkTheme) Color.Black else Color.Black, fontSize = 20.sp),

            placeholder = { Text(
                text = "Search",
                modifier = Modifier.alpha(0.6f),
                color = if (darkTheme) Color.Black else Color.Black
            ) },
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
            keyboardActions = KeyboardActions (
                onSearch = {
                    ///on Search
                }
            )
        )
    }
}

@Composable
fun NewCategory(
    myItems: List<NewsCategoryItem>
) {
    Column(
        modifier = Modifier
            .padding(top = 20.dp, start = 15.dp, end = 15.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        val myItemsList = listOf<NewsCategoryItem>(
            NewsCategoryItem("Technology"),
            NewsCategoryItem("Health"),
            NewsCategoryItem("Politics"),
            NewsCategoryItem("Football"),
            NewsCategoryItem("Science"),
            NewsCategoryItem("Food")
        )

        //news category row
        NewsCategoryRowItem(myItemsList)

        LazyColumn(
            contentPadding = PaddingValues(start = 4.dp, end = 4.dp, top = 15.dp, bottom = 30.dp),
            verticalArrangement = Arrangement.spacedBy(7.dp)
        ){
            items(dataList){ news ->
                NewsListItem(newsItemList = news)
            }
        }

    }
}



@Composable
fun NewsListItem(
    newsItemList: NewsItem
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top,
    ) {

        Image(
            painter = painterResource(id = newsItemList.image),
            contentDescription = data.title,
            modifier = Modifier
                .clip(RoundedCornerShape(7.dp))
                .size(height = 90.dp, width = 120.dp),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .padding(start = 7.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            Text(
                text = newsItemList.title,
                modifier = Modifier.padding(start = 4.dp, top = 3.dp),
                fontWeight = FontWeight.Bold,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp, top = 8.dp, bottom = 3.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(text = "3 hours ago", modifier = Modifier.alpha(0.6f))
                Text(text = "by Fahad yassin", modifier = Modifier
                    .alpha(0.6f)
                    .padding(end = 20.dp))
            }
        }
    }
}


@Composable
fun NewsCategoryRowItem(
    newsCategoryItemChips: List<NewsCategoryItem>
) {
    var selectedItemIndex by remember {
        mutableStateOf(0)
    }
    val darkTheme: Boolean = isSystemInDarkTheme()


    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        contentPadding = PaddingValues(4.dp)
    ){

        items(newsCategoryItemChips.size) {

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { selectedItemIndex = it }
                    .padding(start = 2.dp, top = 3.dp, bottom = 3.dp)
            ) {
                //the row item
                Text(
                    text = newsCategoryItemChips[it].title,
                    modifier = Modifier.padding(end = 5.dp, top = 5.dp, bottom = 5.dp, start = 0.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.h5.fontSize,

                    color = if (!darkTheme) {
                        if (selectedItemIndex == it) Color.Black else NewCategoryInActiveItemColor
                    } else if (darkTheme) {
                        if (selectedItemIndex == it) Color.White else Color.White.copy(alpha = 0.5f)
                    } else {
                        DetailsItemBackgroundWhite
                    },

                )

                //underline text
                Text(
                    text = newsCategoryItemChips[it].title,
                    modifier = Modifier
                        .clip(RoundedCornerShape(48))
                        .height(3.dp)
                        .background(
                        color =
                            if (!darkTheme) {
                                if (selectedItemIndex == it) Color.Black else Color.Transparent
                            } else if (darkTheme) {
                                if (selectedItemIndex == it) Color.White else Color.Transparent
                            } else {
                                DetailsItemBackgroundWhite
                            }
                    ),
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                )

            }


        }
    }


}
