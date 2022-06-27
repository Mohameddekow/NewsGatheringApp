package com.dekow.newsgatheringapp.presentation.home

import com.dekow.newsgatheringapp.commons.Resource
import com.dekow.newsgatheringapp.domain.model.NewsItem
import com.dekow.newsgatheringapp.domain.model.data_transfer_obj.guardian_dto.toNewsItem
import com.dekow.newsgatheringapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class BreakingNewsListUseCase
@Inject
constructor(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(query: String): Flow<Resource<List<NewsItem>>> = flow {
        try {
            emit(Resource.Loading<List<NewsItem>>())

            val newsList = newsRepository.getBreakingNewsList(query = query).toNewsItem()

            emit(Resource.Success<List<NewsItem>>(newsList))
        }catch (e: HttpException){
            emit(Resource.Error<List<NewsItem>>(e.localizedMessage ?: "An unexpected error occurred"))

        }catch (e: IOException){
            emit(Resource.Error<List<NewsItem>>("Couldn't reach server. Check your internet connection."))
        }catch (e: Exception){
            emit(Resource.Error<List<NewsItem>>("Something unexpected happened. Please try again"))
        }
    }
}