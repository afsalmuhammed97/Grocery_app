package com.practies.groceryapp.repository

import com.practies.groceryapp.network.ApiService
import javax.inject.Inject

class GroceryRepository @Inject constructor(private val apiService: ApiService) {


    suspend fun getAllProducts()=apiService.getAllProducts()

   suspend fun  generateOtp(phone:Int)=apiService.generateOtp(phone)

}