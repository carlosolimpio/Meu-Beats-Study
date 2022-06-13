package com.example.meubeatsstudy.data.login

import com.example.meubeatsstudy.domain.login.LoginRepository
import com.example.meubeatsstudy.util.State

class LoginRepositoryImpl : LoginRepository {
    override fun login(userName: String, password: String): Boolean {
        return userName.isNotBlank() && password.isNotBlank()
    }
}