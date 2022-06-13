package com.example.meubeatsstudy.domain.productlist

import com.example.meubeatsstudy.data.productlist.model.Product

interface HeadsetListRepository {
    fun getList(): List<Product>
}