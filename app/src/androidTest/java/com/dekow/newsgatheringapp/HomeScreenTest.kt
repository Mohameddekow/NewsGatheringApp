package com.dekow.newsgatheringapp

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dekow.newsgatheringapp.domain.model.NewsItem
import com.dekow.newsgatheringapp.presentation.home.HomeScreen
import com.dekow.newsgatheringapp.ui.theme.NewsGatheringAppTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<HomeScreen>()

    @Test
    fun testHomeScreenIfNewsListsAreEmpty() {
        composeTestRule.setContent {
            NewsGatheringAppTheme {
                HomeScreen(emptyList())
            }
        }
        composeTestRule.onNodeWithTag(NEWS_LIST_TEST_TAG)
            .onChildren()
            .assertCountEquals(0)
    }

    @Test
    fun testTaskListScreenIfTasksAreNotEmpty() {
        composeTestRule.setContent {
            NewsGatheringAppTheme {
                HomeScreen(getNewsList())
            }
        }
        composeTestRule.onNodeWithTag(TASK_LIST_TEST_TAG)
            .onChildren()
            .assertCountEquals(4)
    }

    @Test
    fun testFirstAndLastTaskDescription(){
        composeTestRule.setContent {
            JetPackComposeAndroidTheme {
                HomeScreen(getNewsList())
            }
        }

        composeTestRule.apply {
            onNodeWithTag(NEWS_LIST_TEST_TAG)
                .onChildren()
                .onFirst()
                .assert(hasText("Buy Milk and eggs!"))

            onNodeWithTag(TASK_LIST_TEST_TAG)
                .onChildren()
                .onLast()
                .assert(hasText("Plan for weekend trip"))
        }
    }

    fun getNewsList(): List<NewsItem> = listOf(NewsItem("Buy Milk and eggs!"),
        NewsItem("Run 3 miles"),
        NewsItem("Take puppy to clinic"),
        NewsItem("Plan for weekend trip")
    )
}