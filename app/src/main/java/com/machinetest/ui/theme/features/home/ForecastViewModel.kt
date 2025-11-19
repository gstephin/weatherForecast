package com.machinetest.ui.theme.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.machinetest.domain.usecase.ForecastUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.machinetest.core.remote.Result
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine

/**
 * ForecastViewModel
 *
 * @author stephingeorge
 * @date 18/11/2025
 */
@HiltViewModel
class ForecastViewModel @Inject constructor(private val useCase: ForecastUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow<ForecastUiState>(ForecastUiState.Idle)
    val uiState: StateFlow<ForecastUiState> = _uiState

    fun getForecast(

    ) {

        viewModelScope.launch {
            _uiState.value = ForecastUiState.Loading
            useCase(33.04, 44.05).collect {
                when (it) {
                    is Result.Error -> {
                        _uiState.value = ForecastUiState.Error(it.errorMsg)
                    }

                    is Result.Loading -> {
                        _uiState.value = ForecastUiState.Loading
                    }

                    is Result.Success -> {

                        _uiState.value = ForecastUiState.Success(it.data)
                    }
                }
            }


        }


    }

}