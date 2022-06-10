package com.dekow.newsgatheringapp.domain.model

data class NewsItem(
    val image : Int,
    val title: String,
    val desc: String,
    val time: String,
    val author: String,
    val views: Int,
)
