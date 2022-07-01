package com.dekow.newsgatheringapp.presentation.deatils

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.dekow.newsgatheringapp.domain.model.NewsDetailsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SharedNewsDetailsViewModel
@Inject
constructor(
//        private val newsDetailsUseCase: NewsDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {


    var searchedKeyWord by mutableStateOf<String?>(null)
        private set


    var details by mutableStateOf<NewsDetailsItem?>(null)
        private set



    fun addDetails(newsDetails: NewsDetailsItem) {
        details = newsDetails
    }

    fun addSearchedKeyWord(keyword: String) {
        searchedKeyWord = keyword
    }

//    val sharedNewsDetailsState: State = _sharedNewsDetailsState

// private val _sharedNewsDetailsState = mutableStateOf(NewsDetailsState())
//    val sharedNewsDetailsState: State<NewsDetailsState> = _sharedNewsDetailsState
//
//
//    fun addDetails(newsDetails: NewsDetailsItem){
//         details = newsDetails
//    }


//
//
//
//    private val _newsDetailsState = mutableStateOf(NewsDetailsState())
//    val newsDetailsState: State<NewsDetailsState> = _newsDetailsState
//
//
//    init {
//        newDetails()
//
//        savedStateHandle.get<String>(SECTION_NAME)?.let { section ->
//
//        }
//    }
//
//
//
//    private fun newDetails() {
//        newsDetailsUseCase().onEach { result ->
//            when (result) {
//                is Resource.Success -> {
//                    _newsDetailsState.value = NewsDetailsState(newsDetails = result.data )
//                }
//                is Resource.Error -> {
//                    _newsDetailsState.value = NewsDetailsState(
//                        error = result.errorMessage ?: "An unexpected error occurred"
//                    )
//                }
//                is Resource.Loading -> {
//                    _newsDetailsState.value = NewsDetailsState(isLoading = true)
//                }
//            }
//        }.launchIn(viewModelScope)
//
//    }

}