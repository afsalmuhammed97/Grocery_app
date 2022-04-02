package com.practies.groceryapp.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practies.groceryapp.model.Product
import com.practies.groceryapp.repository.GroceryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GroceryViewModel @Inject constructor(private val repository: GroceryRepository):ViewModel(){

    private val _productList=MutableLiveData<List<Product>>()

    val productList_liveData:LiveData<List<Product>> get() =_productList


           init {
               getAllProductsList()
           }

    private fun getAllProductsList(){

        try {
            viewModelScope.launch {
                val result=repository.getAllProducts()

                _productList.value=result.products
                Log.i("Check",result.msg)
                Log.i("check2",result.products.toString())
            }

        }catch (e:Exception){
            Log.i("Exception",e.toString())
        }
    }

}