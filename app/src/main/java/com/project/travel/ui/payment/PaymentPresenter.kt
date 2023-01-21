package com.project.travel.ui.payment

import android.util.Log
import com.project.travel.model.ResponsePaymentItem
import com.project.travel.model.ResponsePesananItem
import com.project.travel.networking.ApiClient
import retrofit2.Call
import retrofit2.Response

class PaymentPresenter (val contract: PaymentContract){

    fun getPayment(){
        ApiClient.getService().getPayment()
            .enqueue(object : retrofit2.Callback<List<ResponsePaymentItem>>{
                /**
                 * Invoked for a received HTTP response.
                 *
                 *
                 * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
                 * Call [Response.isSuccessful] to determine if the response indicates success.
                 */
                override fun onResponse(
                    call: Call<List<ResponsePaymentItem>>,
                    response: Response<List<ResponsePaymentItem>>
                ) {
                    if (response.isSuccessful){
                        contract.onSuccessGetPayment(response.body())
                    }else{
                        contract.onErrorGetList(response.message())
                    }
                }

                /**
                 * Invoked when a network exception occurred talking to the server or when an unexpected
                 * exception occurred creating the request or processing the response.
                 */
                override fun onFailure(
                    call: Call<List<ResponsePaymentItem>>,
                    t: Throwable
                ) {
                    contract.onErrorGetList(t.localizedMessage)
                    Log.d("Error ", t.localizedMessage)
                }
            })
    }
}