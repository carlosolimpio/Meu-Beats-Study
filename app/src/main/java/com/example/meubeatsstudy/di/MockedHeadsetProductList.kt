package com.example.meubeatsstudy.di

import com.example.meubeatsstudy.data.productlist.model.Product
import com.example.meubeatsstudy.data.productlist.model.ProductDescription

class MockedHeadsetProductList {
    companion object {
        val productList = getMockedProductList()

        private fun getMockedProductList(): List<Product> {
            return arrayListOf(
                Product(id = 1, description = ProductDescription()),
                Product(id = 2, description = ProductDescription()),
                Product(id = 3, description = ProductDescription()),
                Product(id = 4, description = ProductDescription()),
                Product(id = 5, description = ProductDescription()),
                Product(id = 6, description = ProductDescription()),
                Product(id = 7, description = ProductDescription()),
                Product(id = 8, description = ProductDescription()),
                Product(id = 9, description = ProductDescription()),
                Product(id = 10, description = ProductDescription()),
                Product(id = 11, description = ProductDescription())
            )
        }
    }
}