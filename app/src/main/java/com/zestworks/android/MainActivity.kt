package com.zestworks.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomappbar.BottomAppBar
import com.zestworks.assist.fragments.BottomAppBarFragment
import com.zestworks.assist.fragments.FragmentConfig
import com.zestworks.assist.recyclerview.AdapterItem
import com.zestworks.assist.recyclerview.DefaultAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<RecyclerView>(R.id.itemRecyclerView).apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = DefaultAdapter(list = adapterItems)
        }

        /*val bottomAppBarFragment = BottomAppBarFragment.getInstance(
                fragmentConfig = FragmentConfig(
                        fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                )
        )

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, bottomAppBarFragment, bottomAppBarFragment.name())
                .commit()*/

    }
}
