package com.machinetest.data.network.model

import com.google.gson.annotations.SerializedName

/**
 * WeatherResponse
 *
 * @author stephingeorge
 * @date 12/11/2025
 */

data class ForecastResponse(
    val list: List<ForecastItem>,
    val city: CityInfo
)
data class CityInfo(
    val id: Int,
    val name: String,
    val country: String,
    val latitude: Double,
    val longitude: Double,
    val timezone: Int,       // seconds offset from UTC
    val sunrise: Long,
    val sunset: Long
)
data class ForecastItem(
    @SerializedName("dt_txt")
    val date: String,
    @SerializedName("dt")
    val timeStamp: Long,
    val main: MainData,
    val weather: List<WeatherData>
)

data class MainData(
    val temp: Double
)

data class WeatherData(
    val main: String,
    val description: String,
    val icon: String
)
