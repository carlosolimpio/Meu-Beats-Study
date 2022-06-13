package com.example.meubeatsstudy.presentation.productlist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.meubeatsstudy.R
import com.example.meubeatsstudy.data.productlist.model.Product
import com.example.meubeatsstudy.databinding.CardProductLayoutItemBinding

class HeadsetListAdapter : RecyclerView.Adapter<HeadsetListAdapter.HeadsetListViewHolder>() {

    private lateinit var productList: List<Product>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadsetListViewHolder {
        val binding = CardProductLayoutItemBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return HeadsetListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeadsetListViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount() = productList.size

    fun setData(list: List<Product>) {
        productList = list
        notifyDataSetChanged()
    }

    inner class HeadsetListViewHolder(
        private val binding: CardProductLayoutItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.apply {
                tvProductName.text = product.name
                tvRating.text = product.stars.toString()
                tvReviews.text = product.reviews.toString().plus(" Reviews")
                tvProductPrice.text = "R$ ".plus(product.price)

                clProductLayout.setOnClickListener {
                    val destination = HeadsetListFragmentDirections
                        .actionHeadsetListFragmentToProductDesciptionFragment().apply {
                            productId = product.id
                        }

                    clProductLayout.findNavController().navigate(destination)
                }
            }
        }
    }
}