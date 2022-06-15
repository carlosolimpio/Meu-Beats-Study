package com.example.meubeatsstudy.presentation.productdescription.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.meubeatsstudy.R
import com.example.meubeatsstudy.data.productdescription.ProductDescriptionRepositoryImpl
import com.example.meubeatsstudy.data.productlist.model.Product
import com.example.meubeatsstudy.databinding.FragmentProductDesciptionBinding
import com.example.meubeatsstudy.domain.productdescription.ProductDescriptionUseCase
import com.example.meubeatsstudy.presentation.productdescription.viewmodel.ProductDescriptionViewModel
import com.example.meubeatsstudy.util.State

class ProductDescriptionFragment : Fragment() {

    private lateinit var binding: FragmentProductDesciptionBinding
    private val productDescriptionViewModel =
        ProductDescriptionViewModel(ProductDescriptionUseCase(ProductDescriptionRepositoryImpl()))
    private val args: ProductDescriptionFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDesciptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productDescriptionViewModel.getProduct(args.productId)
        registerObservers()
    }

    private fun registerObservers() {
        productDescriptionViewModel.product.observe(viewLifecycleOwner) {
            when (it) {
                is State.Success -> {
                    initViews(it.data as Product)
                }
                is State.Error -> {
                    Toast.makeText(activity, it.message, Toast.LENGTH_LONG)
                }
                is State.Loading -> {}
            }
        }
    }

    private fun initViews(product: Product) {
        binding.apply {
            //textView2.text = product.description.captionType
        }
    }
}