package com.zestworks.assist.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.zestworks.assist.R

class DefaultAdapter(list: List<AdapterItem>, private val layoutID: Int = R.layout.recycler_view_holder_card1) :
    RecyclerAdapter<AdapterItem, DefaultAdapter.DefaultHolder>(list) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefaultHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutID, parent, false)
        return DefaultHolder(view)
    }

    inner class DefaultHolder(view: View) : RecyclerViewHolder(view) {

        override fun onBindHolder(item: AdapterItem) {
            itemView.findViewById<TextView>(R.id.title).text = item.title

            val imageView = itemView.findViewById<ImageView>(R.id.image)

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

                }
            }
        }
    }
}