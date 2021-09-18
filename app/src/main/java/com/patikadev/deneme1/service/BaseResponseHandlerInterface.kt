package com.patikadev.deneme1.service

interface BaseResponseHandlerInterface<T> {


    fun onSuccess(data :  T)
    fun onFailure()
}