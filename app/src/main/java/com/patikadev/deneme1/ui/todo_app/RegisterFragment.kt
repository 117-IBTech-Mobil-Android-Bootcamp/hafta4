package com.patikadev.deneme1.ui.todo_app

import com.patikadev.deneme1.R
import com.patikadev.deneme1.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_1.button_register
import kotlinx.android.synthetic.main.fragment_register.*
import android.util.Patterns

import android.text.TextUtils
import android.util.Log
import com.patikadev.deneme1.service.BaseCallBack
import com.patikadev.deneme1.service.ServiceConnector
import com.patikadev.deneme1.ui.todo_app.response.RegisterResponse
import com.patikadev.deneme1.utils.*


class RegisterFragment : BaseFragment() {
    override fun getLayoutID() = R.layout.fragment_register

    override fun prepareView() {


        button_register.setOnClickListener {
            hitRegisterEndpoint()
        }
    }


    private fun hitRegisterEndpoint() {

        val email = emailET.getString()
        val password = password.getString()
        val name = nameET.getString()
        val age = ageET.getString()


        if (allFieldsAreValid(email, password, name, age)) {
            //isteği at
            progressbar.visible()


            /*
            params["name"] = name
            params["email"] = email
            params["password"] = password
            params["age"] = age
            */
            val params = mutableMapOf<String, Any>().apply {
                put("name", name)
                put("email", email)
                put("password", password)
                put("age", age)
            }

            ServiceConnector.restInterface.register(params).enqueue(object : BaseCallBack<RegisterResponse>() {
                override fun onSuccess(registerResponse: RegisterResponse) {
                    super.onSuccess(registerResponse)
                    progressbar.gone()
                    Log.e("crated user token ", registerResponse.token)

                    saveDataAsString(USER_TOKEN, registerResponse.token)
                }

                override fun onFailure() {
                    super.onFailure()
                    progressbar.gone()
                    toast("bir hata oluştu")
                }
            })
        } else {
            toast("Lütfen alanları kontrol ediniz.")
        }

    }

    private fun allFieldsAreValid(
        email: String,
        password: String, name: String, age: String
    ): Boolean {
        var allFieldsAreValid = true

        if (email.isEmpty() || !isValidEmail(email)) {
            allFieldsAreValid = false
        }

        if (password.isEmpty() || password.length < 7) allFieldsAreValid = false
        if (name.isEmpty() || name.length < 2) allFieldsAreValid = false
        if (age.isEmpty() || age.length < 2) allFieldsAreValid = false


        return allFieldsAreValid
    }


    fun isValidEmail(target: CharSequence): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}