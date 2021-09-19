package com.patikadev.deneme1.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.patikadev.deneme1.R
import android.util.Log
import com.patikadev.deneme1.service.BaseCallBack
import com.patikadev.deneme1.service.ServiceConnector
import com.patikadev.deneme1.ui.todo_app.model.User
import com.patikadev.deneme1.utils.USER_TOKEN
import com.patikadev.deneme1.utils.gone
import com.patikadev.deneme1.utils.toast
import kotlinx.android.synthetic.main.fragment_register.*


class SplashActivity : AppCompatActivity() {

    private var token : String?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        if(isLoggedIn()){

            //HOMEPAGE SHOULD BE SEEN

            User.getCurrentInstance().token = token
            ServiceConnector.restInterface.getMe().enqueue(object : BaseCallBack<User>(){
                override fun onSuccess(data: User) {
                    super.onSuccess(data)
                    progressbar.gone()
                    User.getCurrentInstance().setUser(data)
                    toast("User is logged in successfully")
                }

                override fun onFailure() {
                    super.onFailure()
                    Log.e("something went", "wrong")

                }
            })

        }else{

            //REGISTER SCREEN SHOULD BE SEEN
            progressbar.gone()
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }





    private fun isLoggedIn() : Boolean{
        val token = getToken()
        return if(token.isEmpty()) false else true
    }

    private fun getToken() : String{
        val sh = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        token = sh.getString(USER_TOKEN, "")!!


        return token!!
    }

}