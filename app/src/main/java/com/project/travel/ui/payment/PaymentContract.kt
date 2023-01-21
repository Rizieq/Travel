package com.project.travel.ui.payment

import com.project.travel.model.ResponsePaymentItem

interface PaymentContract {

    //getListProduk
    fun onSuccessGetPayment(data: List<ResponsePaymentItem>?)
    fun onErrorGetList(msg: String?)
}