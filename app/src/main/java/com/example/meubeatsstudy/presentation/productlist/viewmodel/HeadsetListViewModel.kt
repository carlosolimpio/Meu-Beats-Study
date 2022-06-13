package com.example.meubeatsstudy.presentation.productlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.meubeatsstudy.domain.productlist.HeadsetListUseCase
import com.example.meubeatsstudy.util.State
import com.example.meubeatsstudy.util.State.Error
import com.example.meubeatsstudy.util.State.Loading
import com.example.meubeatsstudy.util.State.Success

class HeadsetListViewModel(
    private val headsetListUseCase: HeadsetListUseCase
) : ViewModel() {

    private val _products: MutableLiveData<State<Any>> by lazy { MutableLiveData<State<Any>>() }
    val products: LiveData<State<Any>> get() = _products

    fun getProductList() {
        _products.postValue(Loading)

        val list = headsetListUseCase.execute()

        if (list.isNotEmpty()) {
            _products.postValue(Success(list))
        } else {
            _products.postValue(Error("Product list is empty"))
        }
    }
}