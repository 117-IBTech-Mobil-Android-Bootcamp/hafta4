package com.patikadev.deneme1.ui.todo_app.response

import com.google.gson.annotations.SerializedName
import com.patikadev.deneme1.ui.todo_app.model.User

data class RegisterResponse(
    @SerializedName("user") val user: User,
    val token : String
)