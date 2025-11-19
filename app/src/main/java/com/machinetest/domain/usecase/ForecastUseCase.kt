package com.machinetest.domain.usecase

import com.machinetest.domain.model.ForecastData
import com.machinetest.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import com.machinetest.core.remote.Result
import kotlinx.coroutines.flow.flow


/**
 * ForecastUseCase
 *
 * @author stephingeorge
 * @date 18/11/2025
 */
class ForecastUseCase @Inject constructor(private val repository: WeatherRepository) {


    suspend operator fun invoke(lat: Double, lon: Double): Flow<Result<List<ForecastData>>> = flow {
        emit(Result.Loading())

        val result = repository.getForecast(lat, lon)
        emit(result)
    }
}