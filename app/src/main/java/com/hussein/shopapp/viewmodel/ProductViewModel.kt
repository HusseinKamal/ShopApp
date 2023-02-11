package com.hussein.shopapp.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.*
import com.hussein.shopapp.database.ProductEntity
import com.hussein.shopapp.database.ShopDao
import com.hussein.shopapp.model.Product
import com.hussein.shopapp.repository.ProductRepository
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductViewModel(val repository: ProductRepository) : ViewModel(){

    @Inject
    lateinit var shopDao: ShopDao

    val productsLiveData:LiveData<Product>
        get() = repository.products

    val productsDB:LiveData<List<ProductEntity>>
        get() = repository.productsDB

    init {
        viewModelScope.launch {
            repository.getDBProducts()
        }
    }
    fun getProductAPI():LiveData<Product>
    {
        viewModelScope.launch {
            repository.getProducts()
        }
        return productsLiveData
    }
    companion object {
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun bindUrlImage(view: ImageView, imageUrl: String?) {
            if (imageUrl != null) {
                Picasso.get()
                    .load(imageUrl)
                    .into(view)
            } else {
                view.setImageBitmap(null)
            }
        }
    }
}