package com.dekow.newsgatheringapp.domain.model.data_transfer_obj.wait


class GuardianResponseT(
    val status: String,
    val userTier: String,
    val total: Int,
    val startIndex: Int,
    val pageSize: Int,
    val currentPage: Int,
    val pages: Int,
    val orderBy: String,
    val resultTS: List<GuardianResultT>
)