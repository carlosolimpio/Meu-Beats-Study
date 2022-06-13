package com.example.meubeatsstudy.domain.login

import com.example.meubeatsstudy.util.State

interface LoginRepository {
    fun login(userName: String, password: String): Boolean
}