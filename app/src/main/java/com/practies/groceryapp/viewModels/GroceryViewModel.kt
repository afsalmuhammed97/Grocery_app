package com.practies.groceryapp.viewModels

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.provider.Settings
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practies.groceryapp.model.*
import com.practies.groceryapp.repository.GroceryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel

class GroceryViewModel @Inject constructor(private val repository: GroceryRepository):ViewModel(){

    private val _productList=MutableLiveData<List<Product>>()
    val productListLiveData:LiveData<List<Product>> get() =_productList


    private val _productDetails=MutableLiveData<Detail>()

    val productDetailsLiveData:LiveData<Detail> get() =_productDetails

    private val  _userSignUpResponse=MutableLiveData<SignUpResult>()

    val userSignUpResponse:LiveData<SignUpResult> get() = _userSignUpResponse

    private val _otpResultData=MutableLiveData<OtpSuccess>()
    val otpResultData:LiveData<OtpSuccess>  get() = _otpResultData

    private val _loginResultData= MutableLiveData<LoginResult>()
    val loginResultData:LiveData<LoginResult> get()=_loginResultData


    var userPhoneNumber:Long=111111111111

    var productId:Int =0



    private var generatedOtp:Int=0



     fun getAllProductsList(){

        try {
            viewModelScope.launch {
                val result=repository.getAllProducts()

                _productList.value=result.products
//                Log.i("Msg",result.msg)
                Log.i("result",result.products.toString())
            }

        }catch (e:Exception){
            Log.i("Exception",e.toString())
        }
    }

    fun  generateOTP(phone:PhoneInput){              //phone:Long){

        try {
            viewModelScope.launch {

                val data = repository.generateOtp(phone)

                 _otpResultData.value=data


            }

        }catch (e:Exception){
            Log.i("Exception",e.toString())
        }
     //   otpResultData.value?.let { Log.i("OTP MSG", it.msg) }

    }


     fun getProductDetails(){

        try {
            viewModelScope.launch {
              //  val result=repository.getProductDetails(productId)

               // _productDetails.value=result.details

             //   Log.i("Check",result.msg)
                  //  Log.i("Result",result.body().description)
            }

        }catch (e:Exception){
            Log.i("Exception",e.toString())
        }
    }





     fun userSignUp(context: Context,name:String,email:String?,){

         val deviceId=getDeviceId(context)
         val deviceType=getSystemDetail()
         val userSignUpData=  SignUpData(userPhoneNumber,name,email,deviceId,deviceType)

         try {
              viewModelScope.launch {

                  val result= repository.userSignUp(userSignUpData)
                  _userSignUpResponse.value=result

         }
         }catch (e:Exception){

             Log.e("Exception",e.toString())
         }catch (e:HttpException){
             Log.e("Exception",e.toString())
         }catch (e:IOException){
             Log.e("Exception",e.toString())
         }


     }


    fun userLogIn(context: Context,phone:Long){

        val deviceId=getDeviceId(context)
        val deviceType=getSystemDetail()
        val userSigInData=SignInData(deviceId,deviceType, phone)
        try {
            viewModelScope.launch {
               val result=repository.userSignIn(userSigInData)

               _loginResultData.value=result


            }

        }catch (e:Exception){
            Log.i("Exception",e.toString())
        }
    }




    @SuppressLint("HardwareIds")
    fun getDeviceId(context: Context):String{
     return  Settings.Secure.getString(context.contentResolver,Settings.Secure.ANDROID_ID)
    }


     fun getSystemDetail(): String {
        return "Brand: ${Build.BRAND} \n" +
                "Model: ${Build.MODEL} \n" +
                "ID: ${Build.ID} \n" +
                "SDK: ${Build.VERSION.SDK_INT} \n" +
                "Manufacture: ${Build.MANUFACTURER} \n" +
                "Brand: ${Build.BRAND} \n" +
                "User: ${Build.USER} \n" +
                "Type: ${Build.TYPE} \n" +
                "Base: ${Build.VERSION_CODES.BASE} \n" +
                "Incremental: ${Build.VERSION.INCREMENTAL} \n" +
                "Board: ${Build.BOARD} \n" +
                "Host: ${Build.HOST} \n" +
                "FingerPrint: ${Build.FINGERPRINT} \n" +
                "Version Code: ${Build.VERSION.RELEASE}"
    }

}