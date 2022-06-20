package com.dekow.newsgatheringapp.presentation.deatils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dekow.newsgatheringapp.R
import com.dekow.newsgatheringapp.presentation.home.data
import com.dekow.newsgatheringapp.presentation.screen.Screens
import com.dekow.newsgatheringapp.ui.theme.DetailsItemBackgroundWhite
import com.dekow.newsgatheringapp.ui.theme.LightModeBackgroundWhite
import com.dekow.newsgatheringapp.ui.theme.PurpleWhite
import com.dekow.newsgatheringapp.ui.theme.Test

@Composable
fun DetailsScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        NewsDetails(navController = navController)
    }
}


@Composable
fun NewsDetails(
    navController: NavHostController
) {
    val darkTheme: Boolean = isSystemInDarkTheme()

    //container box
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize(),
        //contentAlignment = Alignment.Center//,
    ) {

        //headline box
        Box(
            modifier = Modifier
                .fillMaxHeight(0.45f)
                .fillMaxWidth(),
        ) {

            //headline news image
            Image(
                painter = painterResource(R.drawable.newimageplaceholder),
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentScale = ContentScale.FillBounds,
            )

            //back arrow

            IconButton(onClick = {
                navController.navigate(route = Screens.HomeScreen.route){
                    popUpTo(Screens.HomeScreen.route){
                        inclusive = true
                    }
                }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.icons8_left_arrow_50),
                    contentDescription = "back arrow",
                    modifier = Modifier
                        .padding(start = 15.dp, top = 20.dp)
                        .size(40.dp),
                    tint = Color.White,
                )
            }

            //headline news column
            Column(
                modifier = Modifier
                    .padding(start = 15.dp, top = 100.dp, end = 15.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 3.dp, bottom = 10.dp)
                        .clip(RoundedCornerShape(45))
                        .background(Test),
                ) {
                    Text(
                        text = "Health",
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
                        color = Color.White
                    )
                }

                Text(
                    text = data.title,
                    modifier = Modifier
                        .padding(bottom = 5.dp, end = 5.dp)
                        .fillMaxWidth(0.9f),
                    textAlign = TextAlign.Start,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    color = Color.White,
                    maxLines = 3,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                )

                Text(
                    text = data.desc,
                    modifier = Modifier
                        .padding(end = 5.dp,  top = 3.dp, bottom = 10.dp),
                    color = Color.White,
                )

            }

        }


        //news details box
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 25.dp,
                        topEnd = 25.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                )
                .fillMaxHeight(0.6f)
                .fillMaxWidth()
                .background(
                    color = if (!darkTheme) LightModeBackgroundWhite else Color.Black
                )
                .align(Alignment.BottomCenter),
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(horizontal = 15.dp)

            ) {

                Row(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {

                    //author
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(35.dp))
                            .background(
                                color = if (!darkTheme) Color.Black else LightModeBackgroundWhite
                            )
                            .padding(start = 5.dp, top = 5.dp, bottom = 5.dp, end = 15.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.engineering),
                            contentDescription = "Author image" ,
                            modifier = Modifier
                                .clip(RoundedCornerShape(50))
                                .size(34.dp),
                            contentScale = ContentScale.FillBounds


                        )
                        Text(
                            text = "Fahad Yassin",
                            style = TextStyle.Default,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .padding(start = 6.dp),
                            color = if (!darkTheme) PurpleWhite else Color.Black

                        )
                    }

                    //publication time
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(45))
                            .background(
                                color = if (!darkTheme) DetailsItemBackgroundWhite else LightModeBackgroundWhite
                            )
                            .padding(horizontal = 6.dp, vertical = 10.dp),
                                contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = "5 hours ago",
                            fontWeight = FontWeight.SemiBold,
                            //fontSize = 19.sp,
                            color = if (!darkTheme) Color.Black else Color.Black

                        )
                    }

                    //ratings
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(45))
                            .background(
                                color = if (!darkTheme) DetailsItemBackgroundWhite else LightModeBackgroundWhite
                            )
                            .padding(horizontal = 6.dp, vertical = 10.dp),
                    contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = "5 ratings",
                            fontWeight = FontWeight.SemiBold,
                            //fontSize = 19.sp,
                            color = if (!darkTheme) Color.Black else Color.Black

                        )
                    }
                }

                //headline
                Text(
                    text = data.title,
                    modifier = Modifier.padding(bottom = 15.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    textAlign = TextAlign.Start
                )


                //the whole news
                Text(
                    text = data.desc,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .alpha(0.7f),
                    textAlign = TextAlign.Start
                )
            }

        }



    }
}


@Preview
@Composable
fun DetailsPrev() {
    DetailsScreen(navController = rememberNavController())
}