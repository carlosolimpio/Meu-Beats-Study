package com.example.meubeatsstudy.domain.login

import com.example.meubeatsstudy.util.State

class LoginUseCase(private val repository: LoginRepository) {
    fun execute(userName: String, password: String): Boolean {
        return repository.login(userName, password)
    }
}