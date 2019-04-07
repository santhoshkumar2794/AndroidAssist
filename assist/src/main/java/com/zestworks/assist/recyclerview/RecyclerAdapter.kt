package com.zestworks.assist.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.zestworks.assist.R

class RecyclerAdapter(
        private val itemList: List<AdapterItem>,
        private val layoutID: Int = R.layout.recycler_view_holder_card1
) :
        RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    var adapterItemClickListener: AdapterClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutID, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.onBindHolder(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    inner class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        init {
            view.setOnClickListener {
                adapterItemClickListener?.onItemClick(itemList[adapterPosition])
            }
        }

        fun onBindHolder(item: AdapterItem) {
            itemView.findViewById<TextView>(R.id.title).text = item.title

            val imageView = itemView.findViewById<ImageView>(R.id.image)
            imageView.visibility = View.VISIBLE

            val imageUrl = item.imageUrl
            when {
                imageUrl.url != null -> {
                    Picasso.get().load(imageUrl.url).into(imageView)
                }
                imageUrl.filePath != null -> {
                    Picasso.get().load(imageUrl.filePath).into(imageView)
                }
                imageUrl.resourcePath != null -> {
                    Picasso.get().load(imageUrl.resourcePath).into(imageView)
                }
                else -> {
                    imageView.visibility = View.GONE
                }
            }
        }
    }

    interface AdapterClickListener {
        fun onItemClick(item: AdapterItem)
        fun onItemLongClick(item: AdapterItem)
    }
}

