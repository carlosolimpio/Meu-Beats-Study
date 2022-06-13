package com.example.meubeatsstudy.presentation.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.meubeatsstudy.domain.login.LoginUseCase
import com.example.meubeatsstudy.util.State
import com.example.meubeatsstudy.util.State.Loading

class LoginViewModel(
    private val useCase: LoginUseCase
) : ViewModel() {
    private val _login: MutableLiveData<State<Any>> by lazy { MutableLiveData<State<Any>>() }
    val login: LiveData<State<Any>> get() = _login

    fun doLogin(userName: String, password: String) {
        _login.postValue(Loading)

        val response = useCase.execute(userName, password)
        if (response) {
            _login.postValue(State.Success("Success on login! Welcome, $userName!"))
        } else {
            _login.postValue(State.Error("Failed to login. Try again!"))
        }
    }
}