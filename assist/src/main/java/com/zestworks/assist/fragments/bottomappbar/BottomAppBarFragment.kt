package com.zestworks.assist.fragments.bottomappbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomappbar.BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.zestworks.assist.R

class BottomAppBarFragment(private var fragmentConfig: FragmentConfig = FragmentConfig()) : Fragment() {

    companion object {
        private const val BOTTOM_APP_BAR_TAG = "BOTTOM_APP_BAR_FRAGMENT"

        fun getInstance(fragmentConfig: FragmentConfig = FragmentConfig()): BottomAppBarFragment {
            return BottomAppBarFragment(fragmentConfig)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bottom_apppbar, container, false)
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateView()
    }

    private fun updateView() {
        val floatingActionButton = view?.findViewById<FloatingActionButton>(R.id.fab)!!
        floatingActionButton.apply {
            if (fragmentConfig.showFAB) {
                show()
            } else {
                hide()
            }
        }

        val bottomAppBar = view?.findViewById<BottomAppBar>(R.id.bottomAppbar)!!
        bottomAppBar.apply {
            fabAlignmentMode = fragmentConfig.fabAlignmentMode
        }
    }

    fun name() = fragmentConfig.fragmentTag ?: BOTTOM_APP_BAR_TAG

    fun updateFragmentConfig(newConfig: FragmentConfig) {
        if (name() != newConfig.fragmentTag) {
            throw IllegalStateException("Fragment Tag should be ${name()}, instead it is ${newConfig.fragmentTag}." +
                    "This might be a problem while finding the fragment using tag.")
        }
        this.fragmentConfig = newConfig
        updateView()
    }

}

data class FragmentConfig(
        //Show or hide Fab
        val showFAB: Boolean = true,
        //Fab Alignment mode - Center or End of the bottom app bar
        @BottomAppBar.FabAlignmentMode
        val fabAlignmentMode: Int = FAB_ALIGNMENT_MODE_CENTER,
        //Fragment's tag by which it is identified
        val fragmentTag: String? = null
)