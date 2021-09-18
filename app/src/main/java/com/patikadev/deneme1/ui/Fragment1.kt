package com.patikadev.deneme1.ui
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.patikadev.deneme1.R
import com.patikadev.deneme1.base.BaseFragment
import com.patikadev.deneme1.utils.navigateToNextFragment
import kotlinx.android.synthetic.main.fragment_1.*

class Fragment1 : BaseFragment() {


    override fun getLayoutID(): Int = R.layout.fragment_1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_launches.setOnClickListener {
            navigateToNextFragment(R.id.action_fragment1_to_spaceXLaunchesFragment)
        }

        button2.setOnClickListener {
            navigateToNextFragment(R.id.action_fragment1_to_fragment4)
        }
    }
}