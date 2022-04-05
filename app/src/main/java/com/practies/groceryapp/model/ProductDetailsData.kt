package com.practies.groceryapp.model

data class ProductDetailsData(
    val details: List<Detail>,
    val images: List<Image>,
    val msg: String,
    val related: List<Related>,
    val status: String
)