package com.patikadev.deneme1.ui.todo_app.model

import com.google.gson.annotations.SerializedName
import com.patikadev.deneme1.ui.todo_app.response.RegisterResponse

class User(

) {


      @SerializedName("name")
      var userName: String?= null
      var age : Int ?= null
      var email : String ?= null
      var token : String ?= null

    companion object{
        var user : User ?= null

        fun getCurrentInstance() : User {
            /*user?.let {

            } ?: kotlin.run {

            }*/

            if(user == null){
                user = User()
            }

            return user!!
        }
    }


    fun setUser(registeredUser: User){
        user?.age = registeredUser.age
        user?.userName = registeredUser.userName
        user?.email = registeredUser.email
        //user?.token = token


    }



}