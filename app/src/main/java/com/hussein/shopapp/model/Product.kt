package com.hussein.shopapp.model

data class Product(
    val limit: Int,
    val products: List<ProductX>,
    val skip: Int,
    val total: Int
)