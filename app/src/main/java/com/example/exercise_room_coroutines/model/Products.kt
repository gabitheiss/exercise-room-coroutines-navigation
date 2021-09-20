package com.example.exercise_room_coroutines.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
class Products(

    @PrimaryKey
    @ColumnInfo(name = "make_name")
    @SerializedName("name") val nome: String,

    @ColumnInfo(name = "make_price")
    @SerializedName("price") val preco: String,

    @ColumnInfo(name="make_image")
    @SerializedName("image_link") val imagem: String,

    )



