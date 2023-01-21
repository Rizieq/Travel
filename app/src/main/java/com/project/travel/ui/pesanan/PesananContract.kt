package com.project.travel.ui.pesanan

import com.project.travel.model.ResponsePesananItem

interface PesananContract {


    fun onSuccessGetPesanan(data: List<ResponsePesananItem>?)
    fun onErrorGetList(msg: String?)
}