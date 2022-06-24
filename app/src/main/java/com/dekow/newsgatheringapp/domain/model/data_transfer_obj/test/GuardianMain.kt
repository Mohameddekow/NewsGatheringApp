package com.dekow.newsgatheringapp.domain.model.data_transfer_obj.test


import com.dekow.newsgatheringapp.domain.model.NewsItem
data class GuardianMain(
    val response: GuardianResponse
)

fun GuardianMain.toNewsItem(): List<NewsItem> {
val results = this.response.results
    return results.map { result ->

        NewsItem(
            image = result.fields.thumbnail,
            title = result.webTitle,
            desc = result.fields.headline,
            time = result.webPublicationDate,
            author = "by ${result.tags?.map { it.firstName}}",
            ratings = result.fields.starRating,
            sourcePublication = result.fields.publication
        )
    }
}