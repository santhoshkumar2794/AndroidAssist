package com.zestworks.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomappbar.BottomAppBar
import com.zestworks.assist.fragments.BottomAppBarFragment
import com.zestworks.assist.fragments.FragmentConfig
import com.zestworks.assist.recyclerview.AdapterItem
import com.zestworks.assist.recyclerview.DefaultAdapter
import com.zestworks.assist.recyclerview.RecyclerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<RecyclerView>(R.id.itemRecyclerView).apply {
            layoutManager = GridLayoutManager(context, 2)
            val defaultAdapter = DefaultAdapter(list = adapterItems)
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
                val bottomAppBarFragment = BottomAppBarFragment.getInstance(
                        fragmentConfig = FragmentConfig(
                                fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                        )
                )

                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, bottomAppBarFragment, bottomAppBarFragment.name())
                        .addToBackStack(null)
                        .commit()

                supportFragmentManager.executePendingTransactions()
            }
        }
    }
}
