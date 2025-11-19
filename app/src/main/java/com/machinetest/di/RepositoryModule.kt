package com.machinetest.di

import com.machinetest.data.network.repository.WeatherRepositoryImpl
import com.machinetest.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * RepositoryModule
 *
 * @author stephingeorge
 * @date 18/11/2025
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindForecastRepository(impl: WeatherRepositoryImpl):
            WeatherRepository


}