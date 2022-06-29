package com.dekow.newsgatheringapp.domain.model.data_transfer_obj.details_dto


import com.dekow.newsgatheringapp.domain.model.NewsDetailsItem

data class NewsDetailsResponse(
    val response: Response
//    val apiUrl: String,
//    val fields: Fields,
//    val id: String,
//    val isHosted: Boolean,
//    val pillarId: String,
//    val pillarName: String,
//    val sectionId: String,
//    val sectionName: String,
//    val tags: List<Tag>,
//    val type: String,
//    val webPublicationDate: String,
//    val webTitle: String,
//    val webUrl: String
)


fun NewsDetailsResponse.mapToNewsDetailsItem(): NewsDetailsItem{
    val day = response.content.webPublicationDate.slice(8..9)
    val month = response.content.webPublicationDate.slice(5..6)
    val year = response.content.webPublicationDate.slice(0..3)

    return NewsDetailsItem(
        image = response.content.fields.thumbnail,
        title = response.content.webTitle,
        headline = response.content.fields.headline,
        time =  "$day-$month-$year : ${response.content.webPublicationDate.slice(11..15)}",
        author = "by ${response.content.tags?.map { it.firstName}}",
        ratings = response.content.fields.starRating,
        sourcePublication =  response.content.fields.publication,
        authorsImage = response.content.fields.thumbnail,//tags?.map { it.bylineImageUrl }, //.let {  it.map { it.bylineImageUrl } },//
        sectionName = response.content.sectionName,
        bodyText = response.content.fields.bodyText
    )
}
