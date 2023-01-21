package com.project.travel.networking

import com.project.travel.model.*
import retrofit2.Call
import retrofit2.http.GET

interface UserSevice {

    //GET LIST TOKO
    @GET("getEvent.php")
    fun getEvent() : Call<List<ResponseEvent>>

    //GET LIST HOTEL
    @GET("getHotel.php")
    fun getHotel() : Call<List<ResponseHotel>>

    //GET LIST TOURIST ATTRACTION
    @GET("getTouristAttraction.php")
    fun getTouristAttraction() : Call<List<ResponseTouristAttraction>>

    //GET LIST BANNER
    @GET("getBanner.php")
    fun getBanner() : Call<List<ResponseBanner>>

    //GET LIST TRAVEL PACKAGE
    @GET("getTravelPackage.php")
    fun getTravelPackage() : Call<List<ResponseTravelPackage>>

    //GET LIST TRAVEL PACKAGE
    @GET("getPesanan.php")
    fun getPesanan() : Call<List<ResponsePesananItem>>

    //GET LIST TRAVEL PACKAGE
    @GET("getPayment.php")
    fun getPayment() : Call<List<ResponsePaymentItem>>
}