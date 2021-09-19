package com.patikadev.deneme1.ui.spacex

import android.os.Bundle
import android.util.Log
import android.view.View
import com.patikadev.deneme1.R
import com.patikadev.deneme1.base.BaseFragment
import com.patikadev.deneme1.service.BaseCallBack
import com.patikadev.deneme1.service.ServiceConnector
import com.patikadev.deneme1.ui.spacex.adapter.LaunchAdpater
import com.patikadev.deneme1.ui.spacex.dto.Launch
import com.patikadev.deneme1.utils.toast
import kotlinx.android.synthetic.main.fragment_spacex_launches.*
class SpaceXLaunchesFragment : BaseFragment() {


    override fun getLayoutID() = R.layout.fragment_spacex_launches


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        getLaunches()
        prepareView()
        computeSomeThings()


    }

    private fun getLaunches() {

        /**
         * ANDROID UYGULAMALARINDA
         * --------------------
         * asenkron akış ve   --- servis işlemlerinin askenskron akışlara girmesenin sebebi ayrı bir thread'de çalışmalarıdır
         * senrkon akış olabiliyor  --- genelde UI thread'inde çalışan şeyler. Ama biz başkathread'de çalışsa bile, bu thread'i bekle diyebiliyoruz.
         */


        //UI THREAD'DEN KOPMA OLUYOR. BAŞAKA BİR THREAD OLUSUYOR.
       /* ServiceConnector.restInterface.getLaunches().enqueue(object : BaseCallBack<List<Launch>>(){

            override fun onFailure() {
                super.onFailure()
            }

            override fun onSuccess(data: List<Launch>) {
                super.onSuccess(data)
                populateData(data)

            }
        })*/


        /**
         * ui thread'inde sadece "senkron" çalıştıyorum
         */

        /*thread {
            val response = ServiceConnector.restInterface.getLaunches().execute()

            requireActivity().runOnUiThread {
                Thread.sleep(3000)
                if(response.isSuccessful) toast("senkron istek success oldu")
                computeSomeThings()
                prepareView()
            }
        }*/



    }

    private fun populateData(launches : List<Launch>) {
        val launchAdapter = LaunchAdpater(launches){
            toast(it.missionName)
        }

        recyclerview_launch.adapter = launchAdapter
    }


    override fun prepareView() {
        launch_count.text = "this data will be fetch from the back end"
    }

    private fun computeSomeThings(){
        for(i in 1..30){
            Log.e("i", i.toString())
        }
    }


}