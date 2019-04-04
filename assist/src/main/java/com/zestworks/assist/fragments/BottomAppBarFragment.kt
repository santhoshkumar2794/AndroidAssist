package com.zestworks.assist.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomappbar.BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
import com.zestworks.assist.R

class BottomAppBarFragment : Fragment() {

    companion object {
        fun getInstance(fragmentConfig: FragmentConfig): BottomAppBarFragment {
            val bottomAppBarFragment = BottomAppBarFragment()
            bottomAppBarFragment.arguments = fragmentConfig.toBundle()
            return bottomAppBarFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bottom_apppbar, container, false)
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentConfig = FragmentConfig.fromBundle(arguments)
        view.findViewById<BottomAppBar>(R.id.bottomAppbar).apply {
            fabAlignmentMode = fragmentConfig.fabAlignmentMode
        }
    }

    fun name() = "BOTTOM_APP_BAR_FRAGMENT"

}

data class FragmentConfig(
        @BottomAppBar.FabAlignmentMode
        val fabAlignmentMode: Int = FAB_ALIGNMENT_MODE_CENTER
) {

    fun toBundle(): Bundle {
        val bundle = Bundle()
        bundle.putInt(FAB_ALIGNMENT_MODE, fabAlignmentMode)
        return bundle
    }

    companion object {
        private const val FAB_ALIGNMENT_MODE = "fabAlignmentMode"
        fun fromBundle(bundle: Bundle?): FragmentConfig {
            if (bundle == null) {
                return FragmentConfig()
            }
            return FragmentConfig(
                    fabAlignmentMode = bundle.getInt(FAB_ALIGNMENT_MODE, FAB_ALIGNMENT_MODE_CENTER)
            )
        }
    }
}