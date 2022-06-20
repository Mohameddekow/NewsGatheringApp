package com.dekow.newsgatheringapp.domain.model

import androidx.annotation.DrawableRes

data class HomeBottomMenuItem(
    val title: String,
    @DrawableRes
    val iconId: Int,
)
