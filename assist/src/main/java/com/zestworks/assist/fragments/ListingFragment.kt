package com.zestworks.assist.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.zestworks.assist.R

abstract class ListingFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_listing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<RecyclerView>(R.id.recyclerView).apply {
            adapter = this@ListingFragment.getAdapter()
            layoutManager = this@ListingFragment.getLayoutManager()
        }

        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            onFabClicked()
        }
    }

    abstract fun getAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>

    abstract fun getLayoutManager(): RecyclerView.LayoutManager

    abstract fun onFabClicked()
}