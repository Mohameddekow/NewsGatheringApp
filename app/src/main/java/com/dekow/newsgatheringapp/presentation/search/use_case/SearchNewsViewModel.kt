package com.dekow.newsgatheringapp.presentation.search.use_case

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dekow.newsgatheringapp.commons.Constants.SECTION_NAME
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
        private val searchUseCase: SearchUseCase,
        savedStateHandle: SavedStateHandle
    ): ViewModel()
{

    private val _newsListState = mutableStateOf(NewsState())
    val newsListState: State<NewsState> = _newsListState

    private val _sectionNews = mutableStateOf(NewsState())
    val sectionNewsState: State<NewsState> = _sectionNews

    init {

        savedStateHandle.get<String>(SECTION_NAME)?.let { section ->
            searchNews(section)

        }
    }

    private fun searchNews(query: String) {

        searchUseCase(query).onEach { result ->
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