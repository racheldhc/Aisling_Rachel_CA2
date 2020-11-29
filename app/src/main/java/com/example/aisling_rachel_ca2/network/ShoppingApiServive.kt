package com.example.aisling_rachel_ca2.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://demo4086704.mockable.io"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface ShoppingApiService {
    @GET("Aisling_Rachel_CA2")
    fun getItems(): Call<String>
}

object ShoppingApi {
    val retrofitService : ShoppingApiService by lazy { retrofit.create(ShoppingApiService::class.java) }
}