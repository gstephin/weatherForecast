package com.machinetest.data.network.repository

import com.machinetest.data.network.ForecastApiService
import com.machinetest.domain.model.ForecastData
import com.machinetest.domain.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import com.machinetest.core.remote.Result

/**
 * WeatherRepositoryImpl
 *
 * @author stephingeorge
 * @date 18/11/2025
 */
class WeatherRepositoryImpl @Inject constructor(
    private val apiService: ForecastApiService,
) : WeatherRepository {
    override suspend fun getForecast(
        latitude: Double,
        longitude: Double
    ): Result<List<ForecastData>> {

        return withContext(Dispatchers.IO) {

            try {
                val response = apiService.getFiveDayForecast(
                    latitude = latitude,
                    longitude = longitude,
                    "d11eb8d1003d074d0461d486e9f8aded",
                    "metric"
                )

                val forecastList = response.list.map { item ->
                    ForecastData(
                        timeStamp = item.timeStamp,
                        temperature = item.main.temp.toInt(),
                        condition = item.weather.firstOrNull()?.description ?: "N/A",
                        icon = item.weather.firstOrNull()?.icon ?: "",
                        cityName = response.city.name
                    )
                }

                Result.Success(forecastList)
            } catch (e: Exception) {
                Result.Error(e.toString())
            }
        }
    }


}