package com.example.meubeatsstudy.presentation.productlist.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meubeatsstudy.R
import com.example.meubeatsstudy.data.productlist.model.Product
import com.example.meubeatsstudy.data.productlist.repository.HeadsetListRepositoryImpl
import com.example.meubeatsstudy.databinding.FragmentHeadsetListBinding
import com.example.meubeatsstudy.di.MockedHeadsetProductList
import com.example.meubeatsstudy.domain.productlist.HeadsetListRepository
import com.example.meubeatsstudy.domain.productlist.HeadsetListUseCase
import com.example.meubeatsstudy.presentation.productlist.viewmodel.HeadsetListViewModel
import com.example.meubeatsstudy.util.State

class HeadsetListFragment : Fragment() {

    private lateinit var binding: FragmentHeadsetListBinding
    private lateinit var productAdapter: HeadsetListAdapter

    private val headsetListViewModel =
        HeadsetListViewModel(HeadsetListUseCase(HeadsetListRepositoryImpl()))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHeadsetListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        headsetListViewModel.getProductList()
        setObservers()
    }

    private fun initViews() {
        binding.apply {
            btnLogout.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.loginFragment)
            }

            btnAbout.setOnClickListener {
                Toast.makeText(binding.root.context, "Created by Carlos", Toast.LENGTH_LONG)
            }
        }
    }

    private fun setObservers() {
        headsetListViewModel.products.observe(viewLifecycleOwner) {
            when (it) {
                is State.Success -> {
                    setUpList(it.data as List<Product>)
                }
                is State.Error -> {
                    Toast.makeText(activity, it.message, Toast.LENGTH_LONG)
                }
                is State.Loading -> {}
            }
        }
    }

    private fun setUpList(productList: List<Product>) {
        productAdapter = HeadsetListAdapter()
        productAdapter.setData(productList)

        with (binding.rvProducts) {
            layoutManager = LinearLayoutManager(activity)
            adapter = productAdapter
        }
    }
}