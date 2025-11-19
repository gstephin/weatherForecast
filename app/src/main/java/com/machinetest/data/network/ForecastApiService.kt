package com.machinetest.data.network

import com.machinetest.data.network.model.ForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * WeatherApiService
 *
 * @author stephingeorge
 * @date 12/11/2025
 */
interface ForecastApiService {

    @GET("forecast")
    suspend fun getFiveDayForecast(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") apiKey: String,
        @Query("units") units: String
    ): ForecastResponse
}