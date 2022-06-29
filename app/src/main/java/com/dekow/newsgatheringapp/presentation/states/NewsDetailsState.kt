package com.dekow.newsgatheringapp.presentation.states


import com.dekow.newsgatheringapp.domain.model.NewsDetailsItem

data class NewsDetailsState(
    val isLoading: Boolean = false,
    val newsDetails: NewsDetailsItem? = null,
    val error: String = ""
)