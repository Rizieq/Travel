package com.project.travel.networking

import com.project.travel.model.ResponseEvent
import retrofit2.Call
import retrofit2.http.GET

interface UserSevice {

    //GET LIST TOKO
    @GET("getEvent.php")
    fun getToko() : Call<List<ResponseEvent>>

}