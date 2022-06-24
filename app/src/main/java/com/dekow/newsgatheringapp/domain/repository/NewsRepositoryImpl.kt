package com.dekow.newsgatheringapp.domain.repository

import com.dekow.newsgatheringapp.data.remote.GuardiansNewsApi
import com.dekow.newsgatheringapp.domain.model.data_transfer_obj.test.GuardianMain
import com.dekow.newsgatheringapp.domain.model.data_transfer_obj.wait.GuardianMainT
import javax.inject.Inject

class NewsRepositoryImpl
@Inject
constructor(
    private val guardiansNewsApi: GuardiansNewsApi
): NewsRepository {


    override suspend fun searchNews(): GuardianMain {
        return guardiansNewsApi.searchNews()
    }


}