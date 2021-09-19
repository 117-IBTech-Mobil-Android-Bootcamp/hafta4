package com.patikadev.deneme1.service

import com.patikadev.deneme1.ui.spacex.dto.Launch
import com.patikadev.deneme1.ui.todo_app.model.User
import com.patikadev.deneme1.ui.todo_app.response.RegisterResponse
import retrofit2.Call
import retrofit2.http.*

interface TodoAPI {

    @POST("user/register")
    fun register(@Body params : MutableMap<String, Any>) : Call<RegisterResponse>

   /* @GET("endpoint")
    fun blabla(@QueryMap params : MutableMap<String, Any>) : Call<RegisterResponse>*/

    @GET("user/me")
    fun getMe() : Call<User>

}