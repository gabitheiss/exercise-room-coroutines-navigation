package com.example.exercise_room_coroutines.model

import com.google.gson.annotations.SerializedName

class Products(


    @SerializedName("name") val nome: String,
    @SerializedName("price") val preco: String,
    @SerializedName("image_link") val imagem: String,

    )



