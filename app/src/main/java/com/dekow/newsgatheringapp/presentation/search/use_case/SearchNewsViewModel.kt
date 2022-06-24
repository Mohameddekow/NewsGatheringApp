package com.dekow.newsgatheringapp.presentation.search.use_case

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
class SearchNewsViewModel
    @Inject
    constructor(
        val searchUseCase: SearchUseCase
    ): ViewModel()
{

    private val _newsListState = mutableStateOf(NewsState())
    val newsListState: State<NewsState> = _newsListState

    init {
        searchNews()
    }

    private fun searchNews() {

        searchUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _newsListState.value = NewsState(news = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _newsListState.value = NewsState(
                        error = result.errorMessage ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _newsListState.value = NewsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)


    }

}