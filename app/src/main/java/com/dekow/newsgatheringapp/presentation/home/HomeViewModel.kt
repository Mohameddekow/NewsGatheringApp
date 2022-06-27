package com.dekow.newsgatheringapp.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dekow.newsgatheringapp.commons.Resource
import com.dekow.newsgatheringapp.presentation.states.NewsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class HomeViewModel
    @Inject
    constructor(
        private val breakingNewsUseCase: BreakingNewsUseCase,
        private val breakingNewsListUseCase: BreakingNewsListUseCase
    ): ViewModel()
{

    private val _breakingNewsState = mutableStateOf(NewsState())
    val breakingNewsState: State<NewsState> = _breakingNewsState

    private val _breakingNewsListState = mutableStateOf(NewsState())
    val breakingNewsListState: State<NewsState> = _breakingNewsListState


    init {
        getBreakingNews("politics")

        getBreakingNewsList("politics")
    }



    private fun getBreakingNews(query: String) {
        breakingNewsUseCase(query).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _breakingNewsState.value = NewsState(news = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _breakingNewsState.value = NewsState(
                        error = result.errorMessage ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _breakingNewsState.value = NewsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }


    private fun getBreakingNewsList(query: String) {
        breakingNewsListUseCase(query).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _breakingNewsListState.value = NewsState(news = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _breakingNewsListState.value = NewsState(
                        error = result.errorMessage ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _breakingNewsListState.value = NewsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }

}