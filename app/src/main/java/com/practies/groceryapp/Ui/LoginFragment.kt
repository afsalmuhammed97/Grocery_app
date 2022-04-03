package com.practies.groceryapp.Ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.practies.groceryapp.R
import com.practies.groceryapp.ViewModels.GroceryViewModel
import com.practies.groceryapp.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

private  var _binding:FragmentLoginBinding?=null
    private val binding get() = _binding!!

    private val groceryViewModel by  activityViewModels<GroceryViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding= FragmentLoginBinding.inflate(inflater,container,false)



        binding.loginBt.setOnClickListener{

            val phone=binding.numberInput.text.toString()

         //  val phoneNumber =phone.toLong()


                groceryViewModel.generateOTP()



            findNavController().navigate(R.id.action_loginFragment_to_otpVarificationFragment)
        }

   return  binding.root
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