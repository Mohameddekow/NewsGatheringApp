package com.dekow.newsgatheringapp.presentation.search.sections

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dekow.newsgatheringapp.commons.Constants.SECTION_NAME
import com.dekow.newsgatheringapp.commons.Resource
import com.dekow.newsgatheringapp.presentation.search.sections.use_case.SectionsUseCase
import com.dekow.newsgatheringapp.presentation.states.NewsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class SectionsViewModel
    @Inject
    constructor(
        private val sectionsUseCase: SectionsUseCase,
        savedStateHandle: SavedStateHandle
    ): ViewModel()
{

    private val _sectionsState = mutableStateOf(NewsState())
    val sectionsState: State<NewsState> = _sectionsState

    //all news
    private val _allNewsSectionsState = mutableStateOf(NewsState())
    val allNewsSectionsState: State<NewsState> = _allNewsSectionsState

    //food
    private val _foodSectionsState = mutableStateOf(NewsState())
    val foodSectionsState: State<NewsState> = _foodSectionsState

    //football
    private val _footballSectionsState = mutableStateOf(NewsState())
    val footballSectionsState: State<NewsState> = _footballSectionsState

    //politics
    private val _politicsSectionsState = mutableStateOf(NewsState())
    val politicsSectionsState: State<NewsState> = _politicsSectionsState

    //science
    private val _scienceSectionsState = mutableStateOf(NewsState())
    val scienceSectionsState: State<NewsState> = _scienceSectionsState

    //technology
    private val _technologySectionsState = mutableStateOf(NewsState())
    val technologySectionsState: State<NewsState> = _technologySectionsState




    init {

        //get food news to launch it first
        getAllNews("news")
        getFoodNews("food")
        getFootballNews("football")
        getPoliticsNews("politics")
        getScienceNews("science")
        getTechnologyNews("technology")



        savedStateHandle.get<String>(SECTION_NAME)?.let { section ->
            getNewsOfSpecificSection(section)
        }
    }



    private fun getAllNews(query: String) {
        sectionsUseCase(query).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _allNewsSectionsState.value = NewsState(news = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _allNewsSectionsState.value = NewsState(
                        error = result.errorMessage ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _allNewsSectionsState.value = NewsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }

    private fun getFoodNews(query: String) {
        sectionsUseCase(query).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _foodSectionsState.value = NewsState(news = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _foodSectionsState.value = NewsState(
                        error = result.errorMessage ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _foodSectionsState.value = NewsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }

    private fun getFootballNews(query: String) {
        sectionsUseCase(query).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _footballSectionsState.value = NewsState(news = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _footballSectionsState.value = NewsState(
                        error = result.errorMessage ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _footballSectionsState.value = NewsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }


    private fun getPoliticsNews(query: String) {
        sectionsUseCase(query).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _politicsSectionsState.value = NewsState(news = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _politicsSectionsState.value = NewsState(
                        error = result.errorMessage ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _politicsSectionsState.value = NewsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }

    private fun getScienceNews(query: String) {
        sectionsUseCase(query).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _scienceSectionsState.value = NewsState(news = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _scienceSectionsState.value = NewsState(
                        error = result.errorMessage ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _scienceSectionsState.value = NewsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }

    private fun getTechnologyNews(query: String) {
            sectionsUseCase(query).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _technologySectionsState.value = NewsState(news = result.data ?: emptyList())
                    }
                    is Resource.Error -> {
                        _technologySectionsState.value = NewsState(
                            error = result.errorMessage ?: "An unexpected error occurred"
                        )
                    }
                    is Resource.Loading -> {
                        _technologySectionsState.value = NewsState(isLoading = true)
                    }
                }
            }.launchIn(viewModelScope)

        }



    private fun getNewsOfSpecificSection(query: String) {

        sectionsUseCase(query).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _sectionsState.value = NewsState(news = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _sectionsState.value = NewsState(
                        error = result.errorMessage ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _sectionsState.value = NewsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)


    }


}