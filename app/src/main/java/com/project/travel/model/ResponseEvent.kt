package com.project.travel.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

 data class ResponseEvent (

    @field:SerializedName("ID")
    val ID: String? = null,

    @field:SerializedName("NameEvent")
    val NameEvent: String? = null,

    @field:SerializedName("Address")
    val Address: String? = null,

    @field:SerializedName("Description")
    val Description: String? = null,

    @field:SerializedName("Lat")
    val Lat: String? = null,

    @field:SerializedName("Long")
    val Long: String? = null,

    @field:SerializedName("OtherInfo")
    val OtherInfo: String? = null,

    @field:SerializedName("Photo")
    val Photo: String? = null
 )