package com.project.travel.model

import com.google.gson.annotations.SerializedName


data class ResponseTravelPackage(

	@field:SerializedName("ViewsPackage")
	val viewsPackage: String? = null,

	@field:SerializedName("NamePackage")
	val namePackage: String? = null,

	@field:SerializedName("ImagePackage")
	val imagePackage: String? = null,

	@field:SerializedName("DayPackage")
	val dayPackage: String? = null,

	@field:SerializedName("ID")
	val iD: String? = null,

	@field:SerializedName("PricePackage")
	val pricePackage: String? = null,

	@field:SerializedName("StarPackage")
	val starPackage: String? = null,

	@field:SerializedName("LikePackage")
	val likePackage: String? = null,

	@field:SerializedName("DescPackage")
	val descPackage: String? = null
)
