package com.example.aisling_rachel_ca2.network


import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://demo4086704.mockable.io"

enum class ShoppingApiFilter(val value: String) { SHOW_VEGETABLES("vegetables"), SHOW_FRUITS("fruits"), SHOW_MEATS("meats"), SHOW_DAIRY("dairy"), SHOW_ALL("all") }

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface ShoppingApiService {
    @GET("Aisling_Rachel_CA2")
    suspend fun getItems(@Query("filter") type: String): List<ShoppingItem>
}

object ShoppingApi {
    val retrofitService : ShoppingApiService by lazy { retrofit.create(ShoppingApiService::class.java) }
}