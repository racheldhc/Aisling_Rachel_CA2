package com.example.aisling_rachel_ca2.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.aisling_rachel_ca2.network.ShoppingItem

class DetailViewModel(shoppingItem: ShoppingItem, app: Application) : AndroidViewModel(app) {
    private val _selectedItem = MutableLiveData<ShoppingItem>()

    val selectedItem: LiveData<ShoppingItem>
        get() = _selectedItem

    init {
        _selectedItem.value = shoppingItem
    }
}