package com.example.meubeatsstudy.data.productlist.repository

import com.example.meubeatsstudy.di.MockedHeadsetProductList
import com.example.meubeatsstudy.domain.productlist.HeadsetListRepository

class HeadsetListRepositoryImpl : HeadsetListRepository {
    override fun getList() = MockedHeadsetProductList.productList
}