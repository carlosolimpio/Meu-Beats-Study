package com.example.meubeatsstudy.di

import com.example.meubeatsstudy.data.productlist.model.Product
import com.example.meubeatsstudy.data.productlist.model.ProductDescription

class MockedHeadsetProductList {
    companion object {
        val productList = getMockedProductList()

        private fun getMockedProductList(): List<Product> {
            return arrayListOf(
                Product(description = ProductDescription()),
                Product(description = ProductDescription()),
                Product(description = ProductDescription()),
                Product(description = ProductDescription()),
                Product(description = ProductDescription()),
                Product(description = ProductDescription()),
                Product(description = ProductDescription()),
                Product(description = ProductDescription()),
                Product(description = ProductDescription()),
                Product(description = ProductDescription()),
                Product(description = ProductDescription())
            )
        }
    }
}