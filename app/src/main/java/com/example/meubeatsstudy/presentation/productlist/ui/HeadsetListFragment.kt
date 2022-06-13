package com.example.meubeatsstudy.presentation.productlist.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.meubeatsstudy.R
import com.example.meubeatsstudy.databinding.FragmentHeadsetListBinding

class HeadsetListFragment : Fragment() {

    private lateinit var binding: FragmentHeadsetListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHeadsetListBinding.inflate(inflater, container, false)
        return binding.root
    }


}