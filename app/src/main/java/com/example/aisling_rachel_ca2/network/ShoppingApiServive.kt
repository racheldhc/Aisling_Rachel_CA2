package com.example.aisling_rachel_ca2.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://demo4086704.mockable.io"

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object pointing to the desired URL
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

/**
 * A public interface that exposes the [getProperties] method
 */
interface ShoppingApiService {
    /**
     * Returns a Retrofit callback that delivers a String
     * The @GET annotation indicates that the "realestate" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("Aisling_Rachel_CA2")
    fun getProperties(): Call<String>
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object ShoppingApi {
    val retrofitService : ShoppingApiService by lazy { retrofit.create(ShoppingApiService::class.java) }
}