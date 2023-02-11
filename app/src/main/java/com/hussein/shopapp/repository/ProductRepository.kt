package com.hussein.shopapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hussein.shopapp.database.ProductEntity
import com.hussein.shopapp.database.ShopDao
import com.hussein.shopapp.model.Product
import com.hussein.shopapp.model.ProductX
import com.hussein.shopapp.retrofit.RetrofitAPI
import javax.inject.Inject

class ProductRepository @Inject constructor(private val retrofitAPI: RetrofitAPI,private val dao: ShopDao) {
    private val _products=MutableLiveData<Product>()
    val products:LiveData<Product>
    get() = _products

    private val _productsDB=MutableLiveData<List<ProductEntity>>()
    val productsDB:LiveData<List<ProductEntity>>
        get() = _productsDB

    suspend fun getProducts()
    {
        val result=retrofitAPI.getProducts()
        if(result.isSuccessful && result.body()!=null)
        {
            deleteAllProducts()
            val list: List<ProductX> = result.body()!!.products
            list.forEach { product ->
                var imageURL=""
                if(product.images.isNotEmpty())
                {
                    imageURL=product.images[0]
                }
                val item=ProductEntity(name=product.title, price = product.price, image = imageURL
                    ,brand=product.brand, rate = product.rating)
                insertRecord(item)
            }
            _products.postValue(result.body())
        }
    }
    //RoomDB
    suspend fun getDBProducts(){
         val list=dao.getAllRecordsFromDB()
        _productsDB.postValue(list)
     }

    suspend fun insertRecord(productEntity: ProductEntity)
    {
        getDBProducts()
        dao.insertRecord(productEntity)
    }
    suspend fun deleteAllProducts()
    {
        dao.deleteAllRecords()
    }

}