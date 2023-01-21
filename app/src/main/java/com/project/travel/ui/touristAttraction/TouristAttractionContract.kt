package com.project.travel.ui.touristAttraction


import com.project.travel.model.ResponseTouristAttraction

interface TouristAttractionContract {

    fun onSuccessGetTouristAttraction(data: List<ResponseTouristAttraction>?)
    fun onErrorGetList(msg: String?)
}