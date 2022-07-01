package com.dekow.newsgatheringapp.domain.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.dekow.newsgatheringapp.data.remote.GuardiansNewsApi
import com.dekow.newsgatheringapp.domain.model.data_transfer_obj.details_dto.NewsDetailsResponse
import com.dekow.newsgatheringapp.domain.model.data_transfer_obj.guardian_dto.GuardianMain
import javax.inject.Inject

class NewsRepositoryImpl
@Inject
constructor(
    private val guardiansNewsApi: GuardiansNewsApi
): NewsRepository {

//    override suspend fun newsDetails(sectionId: String): NewsDetailsDto {
//        return guardiansNewsApi.newsDetails(sectionId = sectionId)
//    }


    override suspend fun newsDetails(): NewsDetailsResponse {
        return guardiansNewsApi.newsDetails()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getNewsOfSpecificSection(query: String): GuardianMain {
        return guardiansNewsApi.getNewsOfSpecificSection(query = query)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getBreakingNews(query: String): GuardianMain {
        return guardiansNewsApi.getBreakingNews(query = query)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun searchForAnyNews(query: String): GuardianMain {
        return guardiansNewsApi.searchForAnyNews(query = query)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getBreakingNewsList(query: String): GuardianMain {
        return guardiansNewsApi.getBreakingNewsList(query = query)
    }


}