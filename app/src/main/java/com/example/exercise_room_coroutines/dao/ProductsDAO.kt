package com.example.exercise_room_coroutines.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.exercise_room_coroutines.model.Products

@Dao
interface ProductsDAO {

    //select para retornar todos os produtos
    @Query("SELECT * FROM Products ORDER BY make_name")
    fun all() : List<Products>


    //insert para inserir no banco
    //onConflict server para validar quando o insert identifica algum resigtro duplicado
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(products: Products)
}
