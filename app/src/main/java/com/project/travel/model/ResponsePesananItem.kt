package com.project.travel.model

import com.google.gson.annotations.SerializedName

data class ResponsePesananItem(

	@field:SerializedName("DayTransaksi")
	val dayTransaksi: String? = null,

	@field:SerializedName("NoTransaksi")
	val noTransaksi: String? = null,

	@field:SerializedName("MeberTransaksi")
	val meberTransaksi: String? = null,

	@field:SerializedName("ID")
	val iD: String? = null,

	@field:SerializedName("NameTransaksi")
	val nameTransaksi: String? = null,

	@field:SerializedName("Date")
	val date: String? = null,

	@field:SerializedName("Price")
	val price: String? = null

)