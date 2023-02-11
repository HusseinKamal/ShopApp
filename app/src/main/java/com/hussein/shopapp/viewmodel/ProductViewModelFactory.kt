package com.hussein.shopapp.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hussein.shopapp.repository.ProductRepository
import javax.inject.Inject

class ProductViewModelFactory @Inject constructor(private val repository: ProductRepository) :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(repository) as T
    }
}