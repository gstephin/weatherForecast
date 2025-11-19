package com.machinetest.domain.repository

import com.machinetest.domain.model.ForecastData
import com.machinetest.core.remote.Result

/**
 * WeatherRepository
 *
 * @author stephingeorge
 * @date 18/11/2025
 */
interface WeatherRepository {

    suspend fun getForecast(
        latitude: Double,
        longitude: Double
    ):Result<List<ForecastData>>
}