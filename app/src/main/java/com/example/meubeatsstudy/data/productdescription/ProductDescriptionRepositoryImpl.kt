package com.example.meubeatsstudy.data.productdescription

import com.example.meubeatsstudy.data.productlist.model.Product
import com.example.meubeatsstudy.di.MockedHeadsetProductList
import com.example.meubeatsstudy.domain.productdescription.ProductDescriptionRepository

class ProductDescriptionRepositoryImpl : ProductDescriptionRepository {
    override fun getProduct(id: Int): Product {
        return MockedHeadsetProductList.productList.single { product -> product.id == id }
    }
}