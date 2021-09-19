package com.example.exercise_room_coroutines

import androidx.recyclerview.widget.DiffUtil
import com.example.exercise_room_coroutines.model.Products

open class MakeDiffCallback(private val oldList: List<Products>,
                            private val newList  :List<Products>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}