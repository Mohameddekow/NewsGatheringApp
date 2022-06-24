package com.dekow.newsgatheringapp.domain.model.data_transfer_obj.test


import com.google.gson.annotations.SerializedName

data class GuardianFields(
    val headline: String,
    val trailText: String,
    val shortUrl: String,
    val starRating: String,
    val thumbnail: String,
    val bodyText: String,
    val publication: String,
    val lastModified: String
)