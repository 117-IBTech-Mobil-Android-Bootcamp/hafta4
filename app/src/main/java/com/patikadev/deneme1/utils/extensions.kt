package com.patikadev.deneme1.utils

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


inline fun Fragment.navigateToNextFragment(@IdRes id: Int, block: Bundle.() -> Unit = {}) {
    findNavController().navigate(id, Bundle().apply(block))
}


fun View.visible(){
    this.visibility = View.VISIBLE
}

fun View.gone(){
    this.visibility = View.GONE
}


fun Fragment.toast(messageToShow : String, duration : Int = Toast.LENGTH_LONG){
    Toast.makeText(requireContext(), messageToShow, duration).show()
}