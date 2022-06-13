package com.example.meubeatsstudy.domain.productlist

class HeadsetListUseCase(private val repository: HeadsetListRepository) {
    fun execute() = repository.getList()
}