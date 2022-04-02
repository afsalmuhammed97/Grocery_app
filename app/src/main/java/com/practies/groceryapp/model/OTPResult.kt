package com.practies.groceryapp.model

data class OTPResult(
    val msg: String,
    val otp: String,
    val status: String
)