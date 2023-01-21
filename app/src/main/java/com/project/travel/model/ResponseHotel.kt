package com.project.travel.model

import com.google.gson.annotations.SerializedName

data class ResponseHotel(
	@field:SerializedName("Description")
	val description: String? = null,

	@field:SerializedName("Address")
	val address: String? = null,

	@field:SerializedName("Long")
	val long: String? = null,

	@field:SerializedName("Photo")
	val photo: String? = null,

	@field:SerializedName("ID")
	val iD: String? = null,

	@field:SerializedName("Review")
	val review: String? = null,

	@field:SerializedName("NameHotel")
	val nameHotel: String? = null,

	@field:SerializedName("Lat")
	val lat: String? = null,

	@field:SerializedName("OtherInfo")
	val otherInfo: String? = null,

	@field:SerializedName("Price")
	val price: String? = null



)
