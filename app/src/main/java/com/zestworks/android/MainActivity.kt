package com.zestworks.android

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomappbar.BottomAppBar
import com.zestworks.assist.fragments.bottomappbar.BottomAppBarFragmentBuilder
import com.zestworks.assist.recyclerview.AdapterItem
import com.zestworks.assist.recyclerview.RecyclerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<RecyclerView>(R.id.itemRecyclerView).apply {
            layoutManager = GridLayoutManager(context, 2)
            val defaultAdapter = RecyclerAdapter(itemList = adapterItems)
            defaultAdapter.adapterItemClickListener = object : RecyclerAdapter.AdapterClickListener<AdapterItem> {
                override fun onItemClick(item: AdapterItem) {
                    openFragment(item)
                }

                override fun onItemLongClick(item: AdapterItem) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            }
            adapter = defaultAdapter
        }

    }

    private fun openFragment(adapterItem: AdapterItem) {
        when (adapterItem.title) {
            "Bottom App Bar" -> {

                val adapterItems = mutableListOf<AdapterItem>()
                (1..20).forEach {
                    adapterItems.add(AdapterItem("List Item $it"))
                }

                val defaultAdapter = RecyclerAdapter(adapterItems)
                defaultAdapter.adapterItemClickListener = object : RecyclerAdapter.AdapterClickListener<AdapterItem> {
                    override fun onItemClick(item: AdapterItem) {
                        Toast.makeText(this@MainActivity, "Clicked on ${item.title}", Toast.LENGTH_SHORT).show()
                    }

                    override fun onItemLongClick(item: AdapterItem) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                }
                val bottomAppBarFragment = BottomAppBarFragmentBuilder()
                        .setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END)
                        .requireFab(true)
                        .setRecyclerViewAdapter(defaultAdapter as RecyclerView.Adapter<*>)
                        .setRecyclerViewLayoutManager(LinearLayoutManager(this, RecyclerView.VERTICAL, false))
                        .setFabIcon(R.drawable.ic_twotone_share)
                        .setFabClickListener(View.OnClickListener {
                            Toast.makeText(this@MainActivity, "Clicked on FAB", Toast.LENGTH_SHORT).show()
                        })
                        .create()

                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, bottomAppBarFragment, bottomAppBarFragment.name())
                        .addToBackStack(null)
                        .commit()

                supportFragmentManager.executePendingTransactions()
            }
        }
    }
}
