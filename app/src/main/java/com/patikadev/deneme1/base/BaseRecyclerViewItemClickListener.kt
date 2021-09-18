package com.patikadev.deneme1.base

import androidx.annotation.IdRes

interface BaseRecyclerViewItemClickListener<T>{

    fun onItemClicked(clickedObject : T, @IdRes id : Int = 0)
}