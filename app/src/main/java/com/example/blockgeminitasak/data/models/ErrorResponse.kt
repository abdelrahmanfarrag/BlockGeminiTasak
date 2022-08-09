package com.example.blockgeminitasak.data.models

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("code")
    val code: String?=null,
    @SerializedName("message")
    val message: String?=null,
    @SerializedName("status")
    val status: String?=null

)
