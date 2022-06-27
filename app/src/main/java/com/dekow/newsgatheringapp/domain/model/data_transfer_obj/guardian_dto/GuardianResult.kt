package com.dekow.newsgatheringapp.domain.model.data_transfer_obj.guardian_dto


data class GuardianResult(
    val apiUrl: String,
    val fields: GuardianFields,
    val id: String,
    val isHosted: Boolean,
    val pillarId: String,
    val pillarName: String,
    val sectionId: String,
    val sectionName: String,
    val tags: List<GuardianTag>?,
    val type: String,
    val webPublicationDate: String,
    val webTitle: String,
    val webUrl: String
)