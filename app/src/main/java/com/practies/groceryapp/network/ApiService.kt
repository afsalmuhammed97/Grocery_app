package com.practies.groceryapp.network

import android.content.pm.SigningInfo
import com.google.gson.annotations.SerializedName
import com.practies.groceryapp.model.*
import com.practies.groceryapp.network.helper.Constants.CHECK_PHONE
import com.practies.groceryapp.network.helper.Constants.GENERATE_OTP
import com.practies.groceryapp.network.helper.Constants.PRODUCT_DETAILS
import com.practies.groceryapp.network.helper.Constants.PRODUCT_LIST
import com.practies.groceryapp.network.helper.Constants.SIGN_IN
import com.practies.groceryapp.network.helper.Constants.SIGN_UP
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST(GENERATE_OTP)
    suspend fun generateOtp( @Body phone:PhoneInput):OtpSuccess       //OtpFailier


     @POST(CHECK_PHONE)
     suspend fun checkPhoneNumber(@Field("phone") phone:Long)

     @POST(SIGN_UP)
    suspend fun signUp(@Body signUpData: SignUpData):SignUpResult

    @POST(SIGN_IN)
    suspend fun signIn(@Body signInData: SignInData):LoginResult

    @GET(PRODUCT_LIST)
    suspend fun getAllProducts():ProductData

       @POST(PRODUCT_DETAILS)
    suspend fun getProductDetails(@Body productId:Int):ProductDetails
     //  {"phone":8606336176,"full_name":"afsal","device_id":"androdid12345","device_type":"redme5"}



}