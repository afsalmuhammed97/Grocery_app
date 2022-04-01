package com.practies.groceryapp.Ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.practies.groceryapp.R
import com.practies.groceryapp.databinding.FragmentOtpVarificationBinding
import com.practies.groceryapp.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {
    private  var _binding: FragmentRegistrationBinding?=null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding= FragmentRegistrationBinding.inflate(inflater,container,false)

        binding.buttonNext.setOnClickListener{
            findNavController().navigate(R.id.action_registrationFragment_to_homeFragment)
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