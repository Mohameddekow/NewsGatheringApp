package com.dekow.newsgatheringapp.domain.model.data_transfer_obj.details_dto


import com.google.gson.annotations.SerializedName

data class Tag(
    val apiUrl: String,
    val bio: String,
    val firstName: String,
    val id: String,
    val lastName: String,
    val references: List<Any>,
    val type: String,
    val webTitle: String,
    val webUrl: String,
    val bylineImageUrl: String,
    val bylineLargeImageUrl: String
)