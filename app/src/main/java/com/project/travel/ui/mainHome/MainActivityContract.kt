package com.project.travel.ui.mainHome

import com.project.travel.model.ResponseBanner
import com.project.travel.model.ResponseEvent

interface MainActivityContract {

    //getListProduk
    fun onSuccessGetEvent(data: List<ResponseEvent>?)
    fun onErrorGetList(msg: String?)

    //getListBanner
    fun onSuccessGetBanner(data: List<ResponseBanner>?)
    fun onErrorGetListBanner(msg: String?)
}