package com.example.aisling_rachel_ca2.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aisling_rachel_ca2.network.ShoppingApi
import com.example.aisling_rachel_ca2.network.ShoppingItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OverviewViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    init {
        getShoppingItems()
    }

    private fun getShoppingItems() {
        ShoppingApi.retrofitService.getItems().enqueue( object: Callback<List<ShoppingItem>> {
            override fun onFailure(call: Call<List<ShoppingItem>>, t: Throwable) {
                _response.value = "Failure: " + t.message
            }

            override fun onResponse(call: Call<List<ShoppingItem>>, response: Response<List<ShoppingItem>>) {
                _response.value = "Success: ${response.body()?.size} shopping items found!!"
            }
        })
    }
}