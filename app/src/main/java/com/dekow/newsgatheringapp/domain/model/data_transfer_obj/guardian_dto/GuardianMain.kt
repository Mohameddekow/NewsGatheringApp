package com.dekow.newsgatheringapp.domain.model.data_transfer_obj.guardian_dto



import com.dekow.newsgatheringapp.domain.model.NewsItem
data class GuardianMain(
    val response: GuardianResponse
)



fun GuardianMain.toNewsItem(): List<NewsItem> {
val results = this.response.results
    return results.map { result ->

        val day = result.webPublicationDate.slice(8..9)
        val month = result.webPublicationDate.slice(5..6)
        val year = result.webPublicationDate.slice(0..3)

        NewsItem(
            image = result.fields.thumbnail,
            title = result.webTitle,
            headline = result.fields.headline,
            time =  "$day-$month-$year : ${result.webPublicationDate.slice(11..15)}",
            author = "by ${result.tags?.map { it.firstName}}",
            ratings = result.fields.starRating,
            sourcePublication = result.fields.publication
        )
    }
}