package com.zestworks.assist.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class RecyclerAdapter<T : Any, VH : RecyclerAdapter<T, VH>.RecyclerViewHolder>(private val listItem: List<T>) :
        RecyclerView.Adapter<VH>() {

    var adapterItemClickListener: AdapterClickListener<T>? = null

    override fun getItemCount(): Int = listItem.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBindHolder(listItem[position])
    }

    abstract inner class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        init {
            view.setOnClickListener {
                adapterItemClickListener?.onItemClick(listItem[adapterPosition])
            }
        }

        abstract fun onBindHolder(item: T)

    }

    interface AdapterClickListener<T> {
        fun onItemClick(item: T)
        fun onItemLongClick(item: T)
    }
}


