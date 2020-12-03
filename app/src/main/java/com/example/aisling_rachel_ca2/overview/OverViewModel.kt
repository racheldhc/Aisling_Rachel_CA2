package com.example.aisling_rachel_ca2.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aisling_rachel_ca2.network.ShoppingApi
import com.example.aisling_rachel_ca2.network.ShoppingItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class OverviewViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()

    val status: LiveData<String>
        get() = _status

    private val _items = MutableLiveData<List<ShoppingItem>>()

    val items : LiveData<List<ShoppingItem>>
        get() = _items

    init {
        getShoppingItems()
    }

    private val _navigateToSelectedItem = MutableLiveData<ShoppingItem>()

    val navigateToSelectedItem: LiveData<ShoppingItem>
        get() = _navigateToSelectedItem

    fun displayItemDetails(shoppingItem: ShoppingItem) {
        _navigateToSelectedItem.value = shoppingItem
    }

    fun displayItemDetailsComplete() {
        _navigateToSelectedItem.value = null
    }


    private fun getShoppingItems() {
        viewModelScope.launch {
            try{
                var listResult  = ShoppingApi.retrofitService.getItems()
                _status.value = "Success: ${listResult.size} shopping items found!!"
                if(listResult.size > 0){
                    _items.value=listResult
                }
            }
            catch (e:Exception){
                _status.value = "Failure: " + e.message
            }
        }
    }
    }
