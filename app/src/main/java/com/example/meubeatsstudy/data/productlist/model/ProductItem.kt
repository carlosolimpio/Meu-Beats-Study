package com.example.meubeatsstudy.data.productlist.model

data class Product(
    val id: Int,
    val name: String = "Modelo 01",
    val stars: Number = 4.8,
    val reviews: Int = 86,
    val price: Number = 20.50,
    val description: ProductDescription
)
