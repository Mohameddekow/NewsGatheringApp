package com.dekow.newsgatheringapp.domain.model.data_transfer_obj.wait


class GuardianResultT(
    val id: String,
    val type: String,
    val sectionId: String,
    val webTitle: String,
    val webPublicationDate: String,
    val fieldsT: GuardianFieldsT,
    val webUrl: String,
    val apiUrl: String,
    val sectionName: String
)
