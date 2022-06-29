package com.dekow.newsgatheringapp.domain.repository

import com.dekow.newsgatheringapp.domain.model.data_transfer_obj.details_dto.NewsDetailsResponse
import com.dekow.newsgatheringapp.domain.model.data_transfer_obj.guardian_dto.GuardianMain


interface NewsRepository {

//    suspend fun newsDetails(sectionId: String):  NewsDetailsDto
    suspend fun newsDetails():  NewsDetailsResponse

    suspend fun getNewsOfSpecificSection(query: String):  GuardianMain

    suspend fun getBreakingNews(query: String):  GuardianMain

    suspend fun getBreakingNewsList(query: String):  GuardianMain

}