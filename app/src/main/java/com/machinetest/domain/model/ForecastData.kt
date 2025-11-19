package com.machinetest.domain.model

/**
 * ForecastData
 *
 * @author stephingeorge
 * @date 18/11/2025
 */
data class ForecastData(
    val timeStamp: Long,
    val temperature: Int,
    val condition: String,
    val icon: String,
    val cityName: String) {
}