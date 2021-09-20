package com.example.exercise_room_coroutines.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.exercise_room_coroutines.model.Products

@Dao
interface ProductsDAO {

    //select para retornar todos os produtos
    @Query("SELECT * FROM Products ORDER BY make_name")
    fun all() : List<Products>

}
