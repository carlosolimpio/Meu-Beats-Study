package com.example.meubeatsstudy.util

sealed class State<T> {
    data class Success(val data: Any): State<Any>()
    data class Error(val message: String): State<Any>()
    object Loading : State<Any>()
}