package com.patikadev.deneme1.service

import android.widget.Space
import com.patikadev.deneme1.utils.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceConnector {


    companion object {
        private var retrofit: Retrofit? = null
        lateinit var restInterface : SpaceXAPI

        fun init() {

            //logging interceptor
            val logging = HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }

            //adding logging interceptor to okhttp
            val httpClient: OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            //creating retrofit client to correspond with BackEnd Service
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build()


            restInterface = retrofit?.create<SpaceXAPI>(SpaceXAPI::class.java)!!
        }
    }

}