package com.practies.groceryapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

import com.practies.groceryapp.R
import com.practies.groceryapp.viewModels.GroceryViewModel
import com.practies.groceryapp.databinding.FragmentLoginBinding
import com.practies.groceryapp.model.PhoneInput
import com.practies.groceryapp.network.helper.Constants.SUCCESS
import dagger.hilt.android.AndroidEntryPoint

class LoginFragment : Fragment() {

private  var _binding:FragmentLoginBinding?=null
    private val binding get() = _binding!!

    private val groceryViewModel by  activityViewModels<GroceryViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        _binding= FragmentLoginBinding.inflate(inflater,container,false)


        binding.loginBt.setOnClickListener{
            loginOrGaneratOtp()
        }

        return  binding.root
    }



    fun loginOrGaneratOtp(){

        val phone=binding.numberInput.text.toString()

        if (phone.isNotEmpty()&& phone.length== 10){


            val phoneNumber=PhoneInput(phone.toLong())

            groceryViewModel.userLogIn(requireContext(),phone.toLong())

            groceryViewModel.userPhoneNumber=phoneNumber.phone


                groceryViewModel.loginResultData.observe(viewLifecycleOwner){


                    if (it.status ==SUCCESS){
                        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                    }else{

                        groceryViewModel.generateOTP(phoneNumber)
                        findNavController().navigate(R.id.action_loginFragment_to_otpVarificationFragment)
                    }


                }


        }


    }






    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onPause() {
        super.onPause()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }






}