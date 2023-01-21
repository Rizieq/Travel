package com.project.travel.model

import com.google.gson.annotations.SerializedName

data class ResponseBanner(
	@field:SerializedName("ID")
	val ID: String? = null,
	@field:SerializedName("Name")
	val Name: String? = null,
	@field:SerializedName("Link")
	val Link: String? = null
)

