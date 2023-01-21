package com.project.travel.ui.travelPackage

import android.util.Log
import com.project.travel.model.ResponseTouristAttraction
import com.project.travel.model.ResponseTravelPackage
import com.project.travel.networking.ApiClient
import retrofit2.Call
import retrofit2.Response

class TravelPackagePresenter(val contract: TravelPackageContract) {


    fun getTravelpackage(){
        ApiClient.getService().getTravelPackage()
            .enqueue(object : retrofit2.Callback<List<ResponseTravelPackage>>{
                /**
                 * Invoked for a received HTTP response.
                 *
                 *
                 * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
                 * Call [Response.isSuccessful] to determine if the response indicates success.
                 */
                override fun onResponse(
                    call: Call<List<ResponseTravelPackage>>,
                    response: Response<List<ResponseTravelPackage>>
                ) {
                    if (response.isSuccessful){
                        contract.onSuccessGetTravelPackage(response.body())
                    }else{
                        contract.onErrorGetList(response.message())
                    }
                }

                /**
                 * Invoked when a network exception occurred talking to the server or when an unexpected
                 * exception occurred creating the request or processing the response.
                 */
                override fun onFailure(
                    call: Call<List<ResponseTravelPackage>>,
                    t: Throwable
                ) {
                    contract.onErrorGetList(t.localizedMessage)
                    Log.d("Error ", t.localizedMessage)
                }
            })
    }
}