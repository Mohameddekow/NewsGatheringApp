package com.dekow.newsgatheringapp.domain.repository

import com.dekow.newsgatheringapp.domain.model.data_transfer_obj.test.GuardianMain
import com.dekow.newsgatheringapp.domain.model.data_transfer_obj.wait.GuardianMainT


interface NewsRepository {
    suspend fun searchNews():  GuardianMain
}