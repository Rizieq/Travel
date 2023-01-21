package com.project.travel.ui.hotel

import android.util.Log
import com.project.travel.model.ResponseEvent
import com.project.travel.model.ResponseHotel
import com.project.travel.networking.ApiClient
import com.project.travel.ui.mainHome.MainActivityContract
import retrofit2.Call
import retrofit2.Response

class HotelPresenter(val contract: HotelContract) {

    fun getListHotel(){
        ApiClient.getService().getHotel()
            .enqueue(object : retrofit2.Callback<List<ResponseHotel>>{
                /**
                 * Invoked for a received HTTP response.
                 *
                 *
                 * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
                 * Call [Response.isSuccessful] to determine if the response indicates success.
                 */
                override fun onResponse(
                    call: Call<List<ResponseHotel>>,
                    response: Response<List<ResponseHotel>>
                ) {
                    if (response.isSuccessful){
                        contract.onSuccessGetHotel(response.body())
                    }else{
                        contract.onErrorGetList(response.message())
                    }
                }

                /**
                 * Invoked when a network exception occurred talking to the server or when an unexpected
                 * exception occurred creating the request or processing the response.
                 */
                override fun onFailure(call: Call<List<ResponseHotel>>, t: Throwable) {
                    contract.onErrorGetList(t.localizedMessage)
                    Log.d("Error ", t.localizedMessage)
                }

            })
    }
}