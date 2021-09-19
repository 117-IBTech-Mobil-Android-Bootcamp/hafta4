package com.patikadev.deneme1.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.patikadev.deneme1.ui.activities.HomeActivity

abstract class BaseFragment : Fragment(), FragmentInterface {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutID(), container, false)
    }

    override fun onResume() {
        super.onResume()

        val baseActivity = activity as HomeActivity
        if(isNavigationbarVisible())
            baseActivity.showNavigation()
        else
            baseActivity.hideNavigation()


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareView()
    }

    abstract fun getLayoutID() : Int

    open fun prepareView(){}


}