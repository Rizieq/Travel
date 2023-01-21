package com.project.travel.ui.cityAgenda

import com.project.travel.model.ResponseEvent

interface CityAgendaContract {
    //getListProduk
    fun onSuccessGetCityAgenda(data: List<ResponseEvent>?)
    fun onErrorGetList(msg: String?)
}