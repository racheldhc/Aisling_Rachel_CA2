package com.example.aisling_rachel_ca2.network

import com.squareup.moshi.Json

data class ShoppingItem(
    val imgURL: String,
    val name: String,
    val currency: String,
    val price: Double,
    val pricePer: Double,
    val pricePerQuantity: String,
    val type: String
)