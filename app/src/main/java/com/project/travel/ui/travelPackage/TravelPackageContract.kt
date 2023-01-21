package com.project.travel.ui.travelPackage

import com.project.travel.model.ResponseTravelPackage

interface TravelPackageContract {

    fun onSuccessGetTravelPackage(data: List<ResponseTravelPackage>?)
    fun onErrorGetList(msg: String?)
}