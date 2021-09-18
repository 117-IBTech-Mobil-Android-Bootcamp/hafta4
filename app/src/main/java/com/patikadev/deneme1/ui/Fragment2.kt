package com.patikadev.deneme1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.patikadev.deneme1.R
import kotlinx.android.synthetic.main.fragment_2.*

class Fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //parse bundle data
        val stringValue = arguments?.getString("myStringValue")
        val integerValue = arguments?.getInt("myIntegerValue", 100)
        myTextView.text = "$stringValue $integerValue"



        myTextView.setOnClickListener {
            findNavController().navigate(R.id.action_fragment2_to_fragment33)
        }
    }
}