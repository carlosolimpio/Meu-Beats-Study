package com.example.meubeatsstudy.domain.productdescription

class ProductDescriptionUseCase(
    private val repository: ProductDescriptionRepository
) {
    fun execute(id: Int) = repository.getProduct(id)
}