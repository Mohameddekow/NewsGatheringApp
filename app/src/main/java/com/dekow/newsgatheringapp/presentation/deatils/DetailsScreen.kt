package com.dekow.newsgatheringapp.presentation.deatils

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dekow.newsgatheringapp.R
import com.dekow.newsgatheringapp.domain.model.NewsDetailsItem
import com.dekow.newsgatheringapp.presentation.screen.Screens
import com.dekow.newsgatheringapp.ui.theme.DetailsItemBackgroundWhite
import com.dekow.newsgatheringapp.ui.theme.LightModeBackgroundWhite
import com.dekow.newsgatheringapp.ui.theme.PurpleWhite
import com.dekow.newsgatheringapp.ui.theme.Test

@Composable
fun DetailsScreen(
    navController: NavHostController,
    sharedNewsDetailsViewModel: SharedNewsDetailsViewModel
) {
    val newsDetails = sharedNewsDetailsViewModel.details

//    Log.d("detailss2222", details?.bodyText.toString())
//
//
//    LaunchedEffect(key1 = details){
//        Log.d("detailss", details?.headline.toString())
//    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LaunchedEffect(key1 = newsDetails) {
            Log.d("detailss", newsDetails.toString())

        }
        NewsDetails(navController = navController, newsDetails = newsDetails)
    }

}


@Composable
fun NewsDetails(
    navController: NavHostController,
    newsDetails: NewsDetailsItem?
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
                .fillMaxHeight(0.43f)
                .fillMaxWidth(),
        ) {


            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(newsDetails?.image)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.placeholder),
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentScale = ContentScale.FillBounds,
                fallback = painterResource(id = R.drawable.placeholder)
            )


            //back arrow
            IconButton(
                modifier = Modifier.padding(start = 15.dp, top = 20.dp),
                onClick = { navController.popBackStack() }
            ){
                Icon(
                    painter = painterResource(id = R.drawable.icons8_left_arrow_50),
                    contentDescription = "back arrow",
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.Center),
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
                    newsDetails?.sectionName?.let {
                        Text(
                            text = it,//"Health",
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
                            color = Color.White
                        )
                    }
                }

                newsDetails?.headline?.let {
                    Text(
                        text = it,
                        modifier = Modifier
                            .padding(bottom = 5.dp, end = 5.dp)
                            .fillMaxWidth(0.9f),
                        textAlign = TextAlign.Start,
                        fontSize = MaterialTheme.typography.h5.fontSize,
                        color = PurpleWhite,
                        maxLines = 3,
                        fontWeight = FontWeight.Bold,
                        overflow = TextOverflow.Ellipsis,

                    )
                }

                newsDetails?.trailText?.let {
                    Text(
                        text = it,
                        modifier = Modifier
                            .padding(end = 5.dp, top = 3.dp, bottom = 10.dp),
                        color = PurpleWhite,
                    )
                }

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
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .verticalScroll(rememberScrollState())

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
                            //.weight(1f)
                            .padding(start = 3.dp, top = 3.dp, bottom = 3.dp, end = 15.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {

                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(newsDetails?.authorsImage)
                                .crossfade(true)
                                .build(),
                            placeholder = painterResource(R.drawable.placeholder),
                            contentDescription = "Author image",
                            modifier = Modifier
                                .clip(RoundedCornerShape(50))
                                .size(30.dp),
                            contentScale = ContentScale.FillBounds,
                            fallback = painterResource(id = R.drawable.placeholder)
                        )


                        newsDetails?.author?.let {
                            Text(
                                text = it,//"Fahad Yassin",
                                style = TextStyle.Default,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontSize = 18.sp,
                                modifier = Modifier
                                    .padding(start = 6.dp),
                                color = if (!darkTheme) PurpleWhite else Color.Black,

                            )
                        }
                    }

                    //publication time
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(45))
                            .background(
                                color = if (!darkTheme) DetailsItemBackgroundWhite else LightModeBackgroundWhite
                            )
                            //.weight(1f)
                            .padding(horizontal = 6.dp, vertical = 10.dp),
                        contentAlignment = Alignment.Center,
                    ) {

                            newsDetails?.lastModified?.let {
                                Text(
                                    text =  it, //"5 hours ago",
//                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = MaterialTheme.typography.subtitle2.fontSize,
                                    color = if (!darkTheme) Color.Black else Color.Black,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                )
                            }


                    }

                    //production office
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(45))
                            //.weight(1f)
                            .background(
                                color = if (!darkTheme) DetailsItemBackgroundWhite else LightModeBackgroundWhite
                            )
                            .padding(horizontal = 6.dp, vertical = 10.dp),
                        contentAlignment = Alignment.Center,
                    ) {
                            newsDetails?.productionOffice?.let {
                                Text(
                                    text = it,  //5 ratings",
//                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = MaterialTheme.typography.subtitle2.fontSize,
                                    color = if (!darkTheme) Color.Black else Color.Black,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                )
                            }


                    }
                }


                //the whole news
                newsDetails?.bodyText?.let {
                    Text(
                        text = it,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .alpha(0.9f),
                        textAlign = TextAlign.Start,
                        fontSize = MaterialTheme.typography.subtitle1.fontSize,

                    )
                }
            }

        }


    }
}

