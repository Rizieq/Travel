package com.project.travel.ui

import android.util.Log
import com.project.travel.model.ResponseEvent
import com.project.travel.networking.ApiClient
import retrofit2.Call
import retrofit2.Response

class MainActiviyPresenter(val contract: MainActivityContract) {

    fun getListProduk(){
        ApiClient.getService().getToko()
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
}