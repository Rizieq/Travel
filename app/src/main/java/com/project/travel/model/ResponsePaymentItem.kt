package com.project.travel.model

import com.google.gson.annotations.SerializedName

data class ResponsePaymentItem(

	@field:SerializedName("NoTransaksi")
	val noTransaksi: String? = null,

	@field:SerializedName("PaymentName")
	val paymentName: String? = null,

	@field:SerializedName("Photo")
	val photo: String? = null,

	@field:SerializedName("ID")
	val iD: String? = null
)