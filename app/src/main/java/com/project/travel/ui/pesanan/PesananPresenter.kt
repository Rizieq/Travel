package com.project.travel.ui.pesanan

import android.util.Log
import com.project.travel.model.ResponsePesananItem
import com.project.travel.model.ResponseTouristAttraction
import com.project.travel.networking.ApiClient
import com.project.travel.ui.touristAttraction.TouristAttractionContract
import retrofit2.Call
import retrofit2.Response

class PesananPresenter(val contract: PesananContract) {


    fun getPesanan(){
        ApiClient.getService().getPesanan()
            .enqueue(object : retrofit2.Callback<List<ResponsePesananItem>>{
                /**
                 * Invoked for a received HTTP response.
                 *
                 *
                 * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
                 * Call [Response.isSuccessful] to determine if the response indicates success.
                 */
                override fun onResponse(
                    call: Call<List<ResponsePesananItem>>,
                    response: Response<List<ResponsePesananItem>>
                ) {
                    if (response.isSuccessful){
                        contract.onSuccessGetPesanan(response.body())
                    }else{
                        contract.onErrorGetList(response.message())
                    }
                }

                /**
                 * Invoked when a network exception occurred talking to the server or when an unexpected
                 * exception occurred creating the request or processing the response.
                 */
                override fun onFailure(
                    call: Call<List<ResponsePesananItem>>,
                    t: Throwable
                ) {
                    contract.onErrorGetList(t.localizedMessage)
                    Log.d("Error ", t.localizedMessage)
                }
            })
    }
}