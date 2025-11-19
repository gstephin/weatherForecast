package com.machinetest.core.remote

/**
 * Result
 *
 * @author stephingeorge
 * @date 18/11/2025
 */

sealed class Result<out T> {

    data class Success<out T>(val data: T) : Result<T>()

    data class Error(val errorMsg: String) : Result<Nothing>()

    data class Loading(val isLoading: Boolean = true) : Result<Nothing>()
}