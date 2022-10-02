package com.project.travel.ui

import com.project.travel.model.ResponseEvent

interface MainActivityContract {

    //getListProduk
    fun onSuccessGetEvent(data: List<ResponseEvent>?)
    fun onErrorGetList(msg: String?)
}