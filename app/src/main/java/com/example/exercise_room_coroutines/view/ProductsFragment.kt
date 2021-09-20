package com.example.exercise_room_coroutines.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_room_coroutines.R
import com.example.exercise_room_coroutines.adapter.ProductsAdapter
import com.example.exercise_room_coroutines.databinding.FragmentProductsBinding
import com.example.exercise_room_coroutines.model.Products
import com.example.exercise_room_coroutines.view_model.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : Fragment(R.layout.fragment_products) {

    private lateinit var productsViewModel: ProductsViewModel
    private var _binding: FragmentProductsBinding? = null
    private lateinit var recyclerView : RecyclerView

    private val adapterProducts = ProductsAdapter()
    private val observerImages = Observer<List<Products>> {
        adapterProducts.update(it)
    }

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        productsViewModel = ViewModelProvider(this).get(ProductsViewModel::class.java)
        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProductsBinding.bind(view)
        productsViewModel = ViewModelProvider(this).get(ProductsViewModel::class.java)
        productsViewModel.makes.observe(viewLifecycleOwner, observerImages)
        recyclerView = _binding!!.recyclerViewLista
        recyclerView.adapter = adapterProducts
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        productsViewModel.fetchProducts()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}