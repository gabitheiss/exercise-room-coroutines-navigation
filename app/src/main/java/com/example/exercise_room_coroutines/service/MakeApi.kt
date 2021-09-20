package com.example.exercise_room_coroutines.service

import com.example.exercise_room_coroutines.model.Products
import retrofit2.Response
import retrofit2.http.GET

interface MakeApi {

    @GET("/api/v1/products.json?brand=maybelline")
    suspend fun getMakes() : Response<List<Products>>

}