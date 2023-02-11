package com.hussein.shopapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.hussein.shopapp.adapter.ProductAdapter
import com.hussein.shopapp.database.ProductEntity
import com.hussein.shopapp.databinding.ActivityMainBinding
import com.hussein.shopapp.model.ProductX
import com.hussein.shopapp.viewmodel.ProductViewModel
import com.hussein.shopapp.viewmodel.ProductViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var productViewModel: ProductViewModel
    lateinit var binding: ActivityMainBinding
    lateinit var mAdapter:ProductAdapter

    @Inject
    lateinit var productViewModelFactory: ProductViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (application as App).component.inject(this)

        productViewModel= ViewModelProvider(this,productViewModelFactory)[ProductViewModel::class.java]
        //productViewModel=ViewModelProvider(this,productViewModelFactory).get(ProductViewModel::class.java)  // This same in next line

        initView()

    }
    private fun initView()
    {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvProducts.layoutManager = layoutManager
        binding.rvProducts.setHasFixedSize(true)
        binding.rvProducts.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))

        getProducts()
    }
    private fun getProducts()
    {
        //Get Products from DB if DB not empty else get from API
        binding.progress.visibility=View.VISIBLE
        productViewModel.productsDB.observe(this) { listProducts ->
            if(listProducts.isEmpty())
            {
                showProductsAPI()
            }
            else
            {
                showProductsDB(listProducts)
            }
        }
    }
    private fun showProductsDB(productList: List<ProductEntity>)
    {
        val mList: ArrayList<ProductX> = ArrayList()
        productList.forEach {
            val images:ArrayList<String> = ArrayList()
            images.add(it.image)
            val item=ProductX(it.brand,"","",0.0,it.id,images,it.price,it.rate,0,it.image,it.name)
            mList.add(item)
        }
        mAdapter=ProductAdapter(mList)
        binding.rvProducts.adapter = mAdapter
        binding.progress.visibility=View.GONE
    }
    private fun showProductsAPI()
    {
        productViewModel.getProductAPI().observe(this) {
            mAdapter=ProductAdapter(it.products)
            binding.rvProducts.adapter = mAdapter
            binding.progress.visibility=View.GONE
        }
    }
}