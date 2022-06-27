package com.dekow.newsgatheringapp.domain.model.data_transfer_obj.guardian_dto


data class GuardianResponse(
    val currentPage: Int,
    val orderBy: String,
    val pageSize: Int,
    val pages: Int,
    val results: List<GuardianResult>,
    val startIndex: Int,
    val status: String,
    val total: Int,
    val userTier: String
)

//
//fun ResponseT.toNewsItem(): NewsItem {
//    return NewsItem(
////        image = ResponseT.,
//        title = ResponseT.re.fields.headline,
//        desc = ResponseT.results.webTitle,
//        time = ResponseT.results.webPublicationDate,
//        author = "by ${ResponseT.results.tags[0].firstName} ${ResponseT.results.tags[0].firstName}",
//        ratings = ResponseT.results.fields.shortUrl
//    )
//}