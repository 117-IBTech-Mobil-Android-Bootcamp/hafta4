package com.patikadev.deneme1.service

import com.patikadev.deneme1.ui.spacex.dto.Launch
import retrofit2.Call
import retrofit2.http.GET

interface SpaceXAPI {

    @GET("v2/launches")
    fun getLaunches() : Call<List<Launch>>
}