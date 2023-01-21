package com.project.travel.ui.hotel

import com.project.travel.model.ResponseHotel

interface HotelContract {

    fun onSuccessGetHotel(data: List<ResponseHotel>?)
    fun onErrorGetList(msg: String?)
}