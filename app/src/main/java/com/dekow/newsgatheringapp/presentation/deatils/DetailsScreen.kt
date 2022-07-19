package com.dekow.newsgatheringapp.presentation.deatils

import android.graphics.Paint
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.Placeholder
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
import com.dekow.newsgatheringapp.ui.theme.*
import kotlin.math.max

@Composable
fun DetailsScreen(
    navController: NavHostController,
    sharedNewsDetailsViewModel: SharedNewsDetailsViewModel
) {
    val newsDetails = sharedNewsDetailsViewModel.details


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


        //headline box
//        Box(
//            modifier = Modifier
//                // .fillMaxHeight(0.43f)
//                .fillMaxWidth(),
//        ) {}


    val scrollState = rememberScrollState()




        //news details box
//        Box(
//            modifier = Modifier
//                .clip(
//                    RoundedCornerShape(
//                        topStart = 25.dp,
//                        topEnd = 25.dp,
//                        bottomStart = 0.dp,
//                        bottomEnd = 0.dp
//                    )
//                )
//                // .fillMaxHeight(0.6f)
//                .fillMaxWidth()
//                .background(
//                    color = if (!darkTheme) LightModeBackgroundWhite else Color.Black
//                )
//            // .align(Alignment.BottomCenter),
//        ) {}

    Box(
        modifier = Modifier.fillMaxSize()
    ) {


        Column(
            modifier = Modifier.verticalScroll(scrollState)//.fillMaxWidth()
        ) {


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ){

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

                Column(
                    modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 70.dp)
                ){
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


            Column(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 25.dp,
                            topEnd = 25.dp,
                            bottomStart = 0.dp,
                            bottomEnd = 0.dp
                        )
                    )
                    // .fillMaxHeight(0.6f)
                    //.fillMaxWidth()
                    .background(
                        color = if (!darkTheme) LightModeBackgroundWhite else Color.Black
                    )
                // .align(Alignment.BottomCenter),
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

        FadingTopBar( scrollState = scrollState, navController = navController, darkTheme = darkTheme)

    }

    //container box
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .fillMaxSize(),
//        //contentAlignment = Alignment.Center,
//    ) {
//    }

}

@Composable
fun FadingTopBar(
    scrollState: ScrollState,
    navController: NavHostController,
    darkTheme: Boolean
) {

   Box(
       contentAlignment = Alignment.Center
   ){


       Box(
           modifier = Modifier
               .alpha(max(0.3f, scrollState.value / scrollState.maxValue.toFloat()))
               .fillMaxWidth()
               .height(56.dp)
               .background(
                   if (!darkTheme) StatusBarLightModeColor else Color.Black
               ),

           contentAlignment = Alignment.CenterStart
       ) {

           Row(
               modifier = Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.Start,
               verticalAlignment = Alignment.CenterVertically
           ) {
              // back arrow
               IconButton(
                   modifier = Modifier
                       .padding(start = 15.dp)
                       .alpha(1f),
                   onClick = { navController.popBackStack() },
               ){
                   Icon(
                       painter = painterResource(id = R.drawable.icons8_left_arrow_50),
                       contentDescription = "back arrow",
                       modifier = Modifier
                           .size(40.dp),
                       tint = Color.White,
                   )
               }


               Text(
                   modifier = Modifier
                       //.fillMaxWidth()
                       .padding(start = 20.dp),
                   text = "Details",
                   fontWeight = FontWeight.SemiBold,
                   fontSize = MaterialTheme.typography.h6.fontSize,
               )

           }

//           Box(
//               modifier = Modifier
//                   .fillMaxWidth()
//                   .alpha(max(0.3f, scrollState.value / scrollState.maxValue.toFloat()))
//                   .background(
//                       if (!darkTheme) StatusBarLightModeColor else Color.Black
//                   )
//           ) {
//
//           }
       }


//       IconButton(
//           modifier = Modifier
//               .padding(start = 15.dp)
//               .align(Alignment.TopStart)
//               .alpha(1f),
//           onClick = { navController.popBackStack() }
//       ){
//           Icon(
//               painter = painterResource(id = R.drawable.icons8_left_arrow_50),
//               contentDescription = "back arrow",
//               modifier = Modifier
//                   .size(40.dp),
//               tint = Color.White,
//           )
//       }
    }
}