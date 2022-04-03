package com.practies.groceryapp.model

data class SignUpData(
    val  phone:Long,
    val full_name:String,
    val email:String?,
    val device_id:String,
    val device_type:String
)
