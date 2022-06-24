package com.dekow.newsgatheringapp.presentation.states


import com.dekow.newsgatheringapp.domain.model.NewsItem

data class NewsState(
    val isLoading: Boolean = false,
    val news: List<NewsItem>? = null,
    val error: String = ""
)