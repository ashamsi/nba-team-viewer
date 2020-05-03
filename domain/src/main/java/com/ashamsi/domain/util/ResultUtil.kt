package com.ashamsi.domain.util

sealed class ResultUtil<out T> {
    data class Success<out T>(val data: T) : ResultUtil<T>()
    data class Error(val t: Throwable) : ResultUtil<Nothing>()
}