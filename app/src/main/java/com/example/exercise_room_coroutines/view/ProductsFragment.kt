package com.example.exercise_room_coroutines.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.exercise_room_coroutines.databinding.FragmentProductsBinding
import com.example.exercise_room_coroutines.view_model.ProductsViewModel

class ProductsFragment : Fragment() {

    private lateinit var productsViewModel: ProductsViewModel
    private var _binding: FragmentProductsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        productsViewModel = ViewModelProvider(this).get(ProductsViewModel::class.java)

        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}