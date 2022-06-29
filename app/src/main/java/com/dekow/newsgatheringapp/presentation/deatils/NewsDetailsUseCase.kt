package com.dekow.newsgatheringapp.presentation.deatils

import com.dekow.newsgatheringapp.commons.Resource
import com.dekow.newsgatheringapp.domain.model.NewsDetailsItem
import com.dekow.newsgatheringapp.domain.model.NewsItem
import com.dekow.newsgatheringapp.domain.model.data_transfer_obj.details_dto.mapToNewsDetailsItem
import com.dekow.newsgatheringapp.domain.model.data_transfer_obj.guardian_dto.mapToNewsListItems
import com.dekow.newsgatheringapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class NewsDetailsUseCase
@Inject
constructor(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(): Flow<Resource<NewsDetailsItem>> = flow {
        try {
            emit(Resource.Loading<NewsDetailsItem>())

            val newsList = newsRepository.newsDetails().mapToNewsDetailsItem()

            emit(Resource.Success<NewsDetailsItem>(newsList))
        }catch (e: HttpException){
            emit(Resource.Error<NewsDetailsItem>(e.localizedMessage ?: "An unexpected error occurred"))

        }catch (e: IOException){
            emit(Resource.Error<NewsDetailsItem>("Couldn't reach server. Check your internet connection."))
        }catch (e: Exception){
            emit(Resource.Error<NewsDetailsItem>("Something unexpected happened. Please try again"))
        }
    }
}