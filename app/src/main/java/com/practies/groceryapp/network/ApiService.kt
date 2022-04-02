package com.practies.groceryapp.network

import com.practies.groceryapp.model.OTPResult
import com.practies.groceryapp.model.ProductData
import com.practies.groceryapp.network.helper.Constants.CHECK_PHONE
import com.practies.groceryapp.network.helper.Constants.GENERATE_OTP
import com.practies.groceryapp.network.helper.Constants.PRODUCT_LIST
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST(GENERATE_OTP)
    suspend fun generateOtp(@Body phone:Int):Response<OTPResult>


     @POST(CHECK_PHONE)
     suspend fun checkPhoneNumber(@Body phone: Int)

    suspend fun signUp()

    suspend fun signIn()

    @GET(PRODUCT_LIST)
    suspend fun getAllProducts():ProductData


    suspend fun getProductDetails()



}