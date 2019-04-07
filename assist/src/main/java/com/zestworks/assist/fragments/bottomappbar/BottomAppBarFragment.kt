package com.zestworks.assist.fragments.bottomappbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.DrawableRes
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomappbar.BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.zestworks.assist.R

class BottomAppBarFragment : Fragment() {

    companion object {
        private const val BOTTOM_APP_BAR_TAG = "BOTTOM_APP_BAR_FRAGMENT"
    }

    internal var fragmentConfig: FragmentConfig = FragmentConfig()

    fun name() = fragmentConfig.fragmentTag ?: BOTTOM_APP_BAR_TAG

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bottom_apppbar, container, false)
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        setupFab()

        setupBottomAppBar()

        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerView)!!
        recyclerView.apply {
            if (fragmentConfig.layoutManager != null) {
                layoutManager = fragmentConfig.layoutManager
            }

            if (fragmentConfig.adapter != null) {
                adapter = fragmentConfig.adapter
            }
        }
    }

    private fun setupFab() {
        val floatingActionButton = view?.findViewById<FloatingActionButton>(R.id.fab)!!

        if (fragmentConfig.fabIconDrawable != null) {
            floatingActionButton.setImageResource(fragmentConfig.fabIconDrawable!!)
        }

        floatingActionButton.apply {
            if (fragmentConfig.showFAB) {
                show()
            } else {
                hide()
            }
        }

        floatingActionButton.setOnClickListener(fragmentConfig.fabClickListener)
    }

    private fun setupBottomAppBar() {
        val bottomAppBar = view?.findViewById<BottomAppBar>(R.id.bottomAppbar)!!
        bottomAppBar.apply {
            fabAlignmentMode = fragmentConfig.fabAlignmentMode

            if (fragmentConfig.title != null) {
                title = fragmentConfig.title
            }
        }
    }

    internal fun updateFragmentConfig(newConfig: FragmentConfig) {
        if (name() != newConfig.fragmentTag) {
            throw IllegalStateException(
                    "Fragment Tag should be ${name()}, instead it is ${newConfig.fragmentTag}." +
                            "This might be a problem while finding the fragment using tag."
            )
        }
        this.fragmentConfig = newConfig
        setupView()
    }

}

class BottomAppBarFragmentBuilder {

    private val fragmentConfig = FragmentConfig()

    fun setTitle(title: String): BottomAppBarFragmentBuilder {
        fragmentConfig.title = title
        return this
    }

    fun setFabAlignmentMode(@BottomAppBar.FabAlignmentMode fabAlignmentMode: Int): BottomAppBarFragmentBuilder {
        fragmentConfig.fabAlignmentMode = fabAlignmentMode
        return this
    }

    fun requireFab(showFAB: Boolean): BottomAppBarFragmentBuilder {
        fragmentConfig.showFAB = showFAB
        return this
    }

    fun setFragmentTag(tag: String) {
        fragmentConfig.fragmentTag = tag
    }

    fun setRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>): BottomAppBarFragmentBuilder {
        fragmentConfig.adapter = adapter
        return this
    }

    fun setRecyclerViewLayoutManager(layoutManager: RecyclerView.LayoutManager): BottomAppBarFragmentBuilder {
        fragmentConfig.layoutManager = layoutManager
        return this
    }

    fun setFabIcon(@DrawableRes drawableRes: Int): BottomAppBarFragmentBuilder {
        fragmentConfig.fabIconDrawable = drawableRes
        return this
    }

    fun setFabClickListener(@Nullable clickListener: View.OnClickListener): BottomAppBarFragmentBuilder {
        fragmentConfig.fabClickListener = clickListener
        return this
    }

    fun create(): BottomAppBarFragment {
        val bottomAppBarFragment = BottomAppBarFragment()
        bottomAppBarFragment.fragmentConfig = fragmentConfig
        return bottomAppBarFragment
    }
}

internal data class FragmentConfig(
        //Title to be displayed in the bottom app bar
        var title: String? = null,
        //Show or hide Fab
        var showFAB: Boolean = true,
        //Fab Alignment mode - Center or End of the bottom app bar
        @BottomAppBar.FabAlignmentMode
        var fabAlignmentMode: Int = FAB_ALIGNMENT_MODE_CENTER,
        //Fragment's tag by which it is identified
        var fragmentTag: String? = null,
        //Adapter for RecyclerView
        var adapter: RecyclerView.Adapter<*>? = null,
        //Layout Manager for RecyclerView
        var layoutManager: RecyclerView.LayoutManager? = null,
        //Icon to be displayed in the FAB
        @DrawableRes
        var fabIconDrawable: Int? = null,
        //Click listener for the Fab
        var fabClickListener: View.OnClickListener? = null
)

