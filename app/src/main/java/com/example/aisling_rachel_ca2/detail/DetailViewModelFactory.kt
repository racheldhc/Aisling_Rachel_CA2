package com.example.aisling_rachel_ca2.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aisling_rachel_ca2.network.ShoppingItem

class DetailViewModelFactory(
    private val shoppingItem: ShoppingItem,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(shoppingItem, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}