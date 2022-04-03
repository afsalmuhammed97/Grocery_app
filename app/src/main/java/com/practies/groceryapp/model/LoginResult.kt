package com.practies.groceryapp.model

data class LoginResult(
    val email: Any,
    val full_name: String,
    val msg: String,
    val phone: String,
    val status: String,
    val user_id: Int
)