package com.example.aisling_rachel_ca2.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://demo4086704.mockable.io"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface ShoppingApiService {
    @GET("Aisling_Rachel_CA2")
    fun getItems(): Call<List<ShoppingItem>>
}

object ShoppingApi {
    val retrofitService : ShoppingApiService by lazy { retrofit.create(ShoppingApiService::class.java) }
}