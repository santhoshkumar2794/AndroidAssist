package com.zestworks.assist.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class RecyclerAdapter<T : Any, VH : RecyclerViewHolder<T>>(protected val listItem: List<T>) : RecyclerView.Adapter<VH>() {

    override fun getItemCount(): Int = listItem.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBindHolder(listItem[position])
    }
}

abstract class RecyclerViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun onBindHolder(item: T)
}
