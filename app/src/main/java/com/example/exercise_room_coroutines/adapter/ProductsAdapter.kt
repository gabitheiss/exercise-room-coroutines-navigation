package com.example.exercise_room_coroutines.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exercise_room_coroutines.R
import com.example.exercise_room_coroutines.databinding.ItensListBinding
import com.example.exercise_room_coroutines.model.Products

class ProductsAdapter : RecyclerView.Adapter<ProductsViewHolder>() {

    private var listOfProducts = emptyList<Products>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.itens_list, parent, false).apply {
            return ProductsViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        listOfProducts[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int = listOfProducts.size

    fun update(newList: List<Products>) {
        val diffCallback = MakeDiffCallback(oldList = listOfProducts, newList = newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listOfProducts = newList
        diffResult.dispatchUpdatesTo(this)

    }
}



class ProductsViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

    private val binding = ItensListBinding.bind(itemView)

    fun bind(products: Products) {
        binding.idName.text = products.nome
        binding.idPreco.text = products.preco
        Glide.with(itemView).load(products.imagem).into(binding.idImagem)
    }
}