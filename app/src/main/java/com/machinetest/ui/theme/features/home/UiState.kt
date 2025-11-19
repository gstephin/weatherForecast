package com.machinetest.ui.theme.features.home

import com.machinetest.domain.model.ForecastData

/**
 * UiState
 *
 * @author stephingeorge
 * @date 18/11/2025
 */
sealed class ForecastUiState {

    object Idle : ForecastUiState()
    object Loading : ForecastUiState()
    data class Success(val forecast: List<ForecastData>) : ForecastUiState()
    data class Error(val errorType: String) : ForecastUiState()
}