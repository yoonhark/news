package com.harkhark.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harkhark.core.domain.model.NewsData
import com.harkhark.core.domain.usecase.GetNewsDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNewsDataUseCase: GetNewsDataUseCase,
) : ViewModel() {

    private val _uiState: MutableStateFlow<NewsUiState> = MutableStateFlow(NewsUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getNewsDataUseCase().collect{
                _uiState.value = NewsUiState.Success(it)
            }
        }
    }

}

sealed interface NewsUiState {
    data class Success(val news: List<NewsData>) : NewsUiState
    data object Error : NewsUiState
    data object Loading : NewsUiState
}