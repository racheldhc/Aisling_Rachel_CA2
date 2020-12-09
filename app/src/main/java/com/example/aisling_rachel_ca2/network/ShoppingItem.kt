package com.example.aisling_rachel_ca2.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShoppingItem(
    val imgURL: String,
    val name: String,
    val itemDescription: String,
    val currency: String,
    val price: Double,
    val pricePer: Double,
    val pricePerQuantity: String,
    val type: String) : Parcelable {

}