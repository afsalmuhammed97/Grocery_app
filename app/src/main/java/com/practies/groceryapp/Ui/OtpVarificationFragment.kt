package com.practies.groceryapp.Ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.practies.groceryapp.R
import com.practies.groceryapp.databinding.FragmentLoginBinding
import com.practies.groceryapp.databinding.FragmentOtpVarificationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OtpVarificationFragment : Fragment() {
    private  var _binding:FragmentOtpVarificationBinding?=null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        _binding= FragmentOtpVarificationBinding.inflate(inflater,container,false)


        binding.sendVarificationButton.setOnClickListener{
            findNavController().navigate(R.id.action_otpVarificationFragment_to_registrationFragment)
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