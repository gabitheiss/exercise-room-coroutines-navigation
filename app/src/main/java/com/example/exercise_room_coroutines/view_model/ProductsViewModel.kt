package com.example.exercise_room_coroutines.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exercise_room_coroutines.model.Products
import com.example.exercise_room_coroutines.repository.MakeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val repository: MakeRepository) : ViewModel() {

   private val _makes = MutableLiveData<List<Products>>()
           val makes : LiveData<List<Products>> = _makes

    fun fetchProducts() {
        viewModelScope.launch {
            val returnedImages = repository.fetchProducts()
            returnedImages?.let {
                _makes.value = it
            }
        }
    }
}