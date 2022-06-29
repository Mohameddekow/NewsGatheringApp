package com.dekow.newsgatheringapp.domain.model.data_transfer_obj.details_dto


import com.google.gson.annotations.SerializedName

data class Fields(
    val headline: String,
    val trailText: String,
    val shortUrl: String,
    val starRating: String,
    val thumbnail: String,
    val bodyText: String,
    val publication: String,
    val lastModified: String
)