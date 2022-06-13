package com.example.meubeatsstudy.presentation.productdescription.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.meubeatsstudy.domain.productdescription.ProductDescriptionUseCase
import com.example.meubeatsstudy.util.State

class ProductDescriptionViewModel(
    private val useCase: ProductDescriptionUseCase
) : ViewModel() {
    private val _product: MutableLiveData<State<Any>> by lazy { MutableLiveData<State<Any>>() }
    val product: LiveData<State<Any>> get() = _product

    fun getProduct(id: Int) {
        _product.postValue(State.Loading)

        val product = useCase.execute(id)

        _product.postValue(State.Success(product))
    }
}