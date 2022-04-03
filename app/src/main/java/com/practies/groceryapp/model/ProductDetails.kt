package com.practies.groceryapp.model

data class ProductDetails(
    val details:Detail,                 //List<Detail>,
    val images:Image,                  //List<Image>,
    val msg: String,
                                   //     val related:List<Related>,
    val status: String
)