package com.dekow.newsgatheringapp.domain.model.data_transfer_obj.wait


import com.dekow.newsgatheringapp.domain.model.NewsItem

data class GuardianMainT(val responseT: GuardianResponseT)


fun GuardianMainT.mapToNews(): List<NewsItem> {
    val results = this.responseT.resultTS
    return results.map { result ->
        NewsItem(
            image = result.fieldsT.thumbnail,
            title = result.webTitle,
            desc = result.fieldsT.htmlBody,
            time = result.webPublicationDate,
            author = "by ${result.fieldsT.publication}",
            ratings = result.id
        )
    }
}