package com.project.travel.ui.mainHome

import android.util.Log
import com.project.travel.model.ResponseBanner
import com.project.travel.model.ResponseEvent
import com.project.travel.networking.ApiClient
import retrofit2.Call
import retrofit2.Response

class MainActiviyPresenter(val contract: MainActivityContract) {

    fun getListEvent(){
        ApiClient.getService().getEvent()
            .enqueue(object : retrofit2.Callback<List<ResponseEvent>>{
                override fun onResponse(
                    call: Call<List<ResponseEvent>>,
                    response: Response<List<ResponseEvent>>
                ) {

                    if (response.isSuccessful){
                        contract.onSuccessGetEvent(response.body())
                    }else{
                        contract.onErrorGetList(response.message())
                    }
                }

                override fun onFailure(call: Call<List<ResponseEvent>>, t: Throwable) {
                    contract.onErrorGetList(t.localizedMessage)
                    Log.d("Error ", t.localizedMessage)
                }

            })
    }

    fun getListBanner(){
        ApiClient.getService().getBanner()
            .enqueue(object : retrofit2.Callback<List<ResponseBanner>>{
                override fun onResponse(
                    call: Call<List<ResponseBanner>>,
                    response: Response<List<ResponseBanner>>
                ) {

                    if (response.isSuccessful){
                        contract.onSuccessGetBanner(response.body())
                    }else{
                        contract.onErrorGetListBanner(response.message())
                    }
                }

                override fun onFailure(call: Call<List<ResponseBanner>>, t: Throwable) {
                    contract.onErrorGetListBanner(t.localizedMessage)
                    Log.d("Error ", t.localizedMessage)
                }

            })
    }
}