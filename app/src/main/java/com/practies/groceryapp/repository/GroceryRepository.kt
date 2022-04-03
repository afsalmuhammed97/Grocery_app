package com.practies.groceryapp.repository

import com.practies.groceryapp.model.SignInData
import com.practies.groceryapp.model.SignUpData
import com.practies.groceryapp.network.ApiService
import javax.inject.Inject

class GroceryRepository @Inject constructor(private val apiService: ApiService) {


    suspend fun getAllProducts()=apiService.getAllProducts()

   // suspend fun getProductDetails(productId:Int)=apiService.getProductDetails(productId)

    suspend fun  generateOtp(phone:Long)=apiService.generateOtp(phone)


   // suspend fun userSignUp(signUpData: SignUpData)=apiService.signUp(signUpData)

  //  suspend fun  userSignIn(signInData: SignInData)=apiService.signIn(signInData)

   // suspend fun  checkPhoneNumber

}