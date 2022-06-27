package com.dekow.newsgatheringapp.presentation.search.sections.using_lazyrow

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.dekow.newsgatheringapp.domain.model.NewsSectionItem
import com.dekow.newsgatheringapp.presentation.nav.SetUpNewsSectionNavigation
import com.dekow.newsgatheringapp.presentation.screen.SectionScreens
import com.dekow.newsgatheringapp.ui.theme.DetailsItemBackgroundWhite
import com.dekow.newsgatheringapp.ui.theme.NewCategoryInActiveItemColor


@Composable
fun NewsSectionRowItem(
    newsSectionItemChips: List<NewsSectionItem>
) {
    var selectedItemIndex by remember { mutableStateOf(0) }

    val darkTheme: Boolean = isSystemInDarkTheme()

    @Composable
    fun ItemsCategoriesRow(
        onItemClick : (selectedItemIndex: Int) -> Unit
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            contentPadding = PaddingValues(4.dp)
        ){

            itemsIndexed(newsSectionItemChips){index, item  ->
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {
                            selectedItemIndex = index
                            onItemClick(index)
                        }
                        .padding(start = 2.dp, top = 3.dp, bottom = 3.dp)
                ) {
                    //the row item
                    Text(
                        text = item.title,
                        modifier = Modifier.padding(end = 5.dp, top = 5.dp, bottom = 5.dp, start = 0.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.h5.fontSize,

                        color = if (!darkTheme) {
                            if (selectedItemIndex == index) Color.Black else NewCategoryInActiveItemColor
                        } else if (darkTheme) {
                            if (selectedItemIndex == index) Color.White else Color.White.copy(alpha = 0.5f)
                        } else {
                            DetailsItemBackgroundWhite
                        },
                    )

                    //underline text
                    Text(
                        text = item.title,
                        modifier = Modifier
                            .clip(RoundedCornerShape(48))
                            .height(3.dp)
                            .background(
                                color =
                                if (!darkTheme) {
                                    if (selectedItemIndex == index) Color.Black else Color.Transparent
                                } else if (darkTheme) {
                                    if (selectedItemIndex == index) Color.White else Color.Transparent
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


    val sectionNavController = rememberNavController()

    //updating the index to 0 on back pressed and navigation to food section as default
    if(selectedItemIndex == 1
        || selectedItemIndex == 2
        || selectedItemIndex == 3
        || selectedItemIndex == 4
        || selectedItemIndex == 5
    ) {
        BackHandler(enabled = true) {
            selectedItemIndex = 0

            sectionNavController.navigate(
                SectionScreens.FoodSectionScreen.route
            ){
                popUpTo(SectionScreens.FoodSectionScreen.route){
                    inclusive = true
                }
            }
        }

    }

    ItemsCategoriesRow{ index ->
        when(index){
              0 -> {

                    sectionNavController.navigate(
                        SectionScreens.FoodSectionScreen.route
                    ){
                        popUpTo(SectionScreens.FoodSectionScreen.route){
                            inclusive = true
                        }
                    }

                }
                1 -> {
                    sectionNavController.navigate(
                        SectionScreens.NavigateToSectionSpecified.route + "/news"
                    ){
                        popUpTo(SectionScreens.FoodSectionScreen.route){
                            inclusive = false
                        }
                    }

                }
                2 -> {
                    sectionNavController.navigate(
                        SectionScreens.NavigateToSectionSpecified.route + "/technology"
                    ) {
                        popUpTo(SectionScreens.FoodSectionScreen.route) {
                            inclusive = false
                        }
                    }
                }

                3 -> {
                    sectionNavController.navigate(
                        SectionScreens.NavigateToSectionSpecified.route + "/football"
                    ){
                        popUpTo(SectionScreens.FoodSectionScreen.route){
                            inclusive = false
                        }
                    }

                }
                4 -> {
                    sectionNavController.navigate(
                        SectionScreens.NavigateToSectionSpecified.route + "/politics"
                    ){
                        popUpTo(SectionScreens.FoodSectionScreen.route){
                            inclusive = false
                        }
                    }

                }

                5 -> {
                    sectionNavController.navigate(
                        SectionScreens.NavigateToSectionSpecified.route + "/science"
                    ){
                        popUpTo(SectionScreens.FoodSectionScreen.route){
                            inclusive = false
                        }
                    }

                }

            }
    }

    //set up section navigation
    SetUpNewsSectionNavigation(sectionNavController = sectionNavController )
}
