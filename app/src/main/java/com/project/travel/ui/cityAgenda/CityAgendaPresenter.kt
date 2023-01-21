package com.project.travel.ui.cityAgenda

import android.util.Log
import com.project.travel.model.ResponseEvent
import com.project.travel.networking.ApiClient
import retrofit2.Call
import retrofit2.Response

class CityAgendaPresenter (val contract: CityAgendaContract){

    fun getListCityAgenda(){
        ApiClient.getService().getEvent()
            .enqueue(object : retrofit2.Callback<List<ResponseEvent>>{
                override fun onResponse(
                    call: Call<List<ResponseEvent>>,
                    response: Response<List<ResponseEvent>>
                ) {

                    if (response.isSuccessful){
                        contract.onSuccessGetCityAgenda(response.body())
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