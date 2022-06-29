package com.dekow.newsgatheringapp.domain.model.data_transfer_obj.details_dto

data class Response(
    val status: String,
    val userTier: String,
    val total: Int,
    val content: Content
)
