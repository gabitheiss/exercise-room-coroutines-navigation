package com.example.exercise_room_coroutines.repository

import com.example.exercise_room_coroutines.model.Products
import com.example.exercise_room_coroutines.service.MakeApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class MakeRepository @Inject constructor(private val service : MakeApi) {

    suspend fun fetchProducts() : List<Products>? {
        return withContext(Dispatchers.Default){
            val responseMake = service.getMakes()
            val processedResponse = processData(responseMake)
            processedResponse
        }
    }

    private fun <T> processData(response : Response<T>) : T? {
        return if (response.isSuccessful) response.body()
        else null
    }

    //funcao para teste com ->
    suspend fun fetchProductsCallback(onComplete: (String) -> Unit) {
        val response = withContext(Dispatchers.Default) {
            service.getMakes()
        }
        if (response.isSuccessful) {
            onComplete("Success")
        } else {
            onComplete("Failure")
        }
    }

}

