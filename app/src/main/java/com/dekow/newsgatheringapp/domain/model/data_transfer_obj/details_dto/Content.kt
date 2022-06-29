package com.dekow.newsgatheringapp.domain.model.data_transfer_obj.details_dto

data class Content(
    val apiUrl: String,
    val fields: Fields,
    val id: String,
    val sectionId: String,
    val sectionName: String,
    val tags: List<Tag>?,
    val type: String,
    val webPublicationDate: String,
    val webTitle: String,
    val webUrl: String,
    val isHosted: Boolean,
    val pillarId: String,
    val pillarName: String,
)
