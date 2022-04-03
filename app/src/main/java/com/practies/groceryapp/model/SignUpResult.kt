package com.practies.groceryapp.model

data class SignUpResult(
    val email: Any,
    val msg: String,
    val name: String,
    val phone: Long,
    val status: String,
    val user_id: String
)