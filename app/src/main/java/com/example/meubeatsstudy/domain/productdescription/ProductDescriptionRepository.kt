package com.example.meubeatsstudy.domain.productdescription

import com.example.meubeatsstudy.data.productlist.model.Product

interface ProductDescriptionRepository {
    fun getProduct(id: Int): Product
}