package com.hussein.shopapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hussein.shopapp.database.ProductEntity
import com.hussein.shopapp.databinding.ProductItemLayoutBinding
import com.hussein.shopapp.model.ProductX

class ProductAdapter (private val mList: List<ProductX>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    private lateinit var binding: ProductItemLayoutBinding

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // that is used to hold list item
        binding = ProductItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]
        holder.bind(item)

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(private val binding: ProductItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: ProductX) {
            binding.product = product
        }
    }
}