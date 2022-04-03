package com.practies.groceryapp.Ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.practies.groceryapp.R
import com.practies.groceryapp.ViewModels.GroceryViewModel
import com.practies.groceryapp.databinding.FragmentOtpVarificationBinding
import com.practies.groceryapp.databinding.FragmentRegistrationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationFragment : Fragment() {
    private  var _binding: FragmentRegistrationBinding?=null
    private val binding get() = _binding!!

    private val groceryViewModel:GroceryViewModel by  activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding= FragmentRegistrationBinding.inflate(inflater,container,false)

        binding.buttonNext.setOnClickListener{
//                 val name=binding.editTextTextPersonName.text.toString()
//                 val email=binding.textEmailAddress.text.toString()
                     val name="sreeragh"
                    val email="sreeragh@gmail.com"
         //    groceryViewModel.userSignUp(requireContext(),name,email)
        //  val message=   groceryViewModel.userSignUpResponse.value?.msg

            // Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_registrationFragment_to_homeFragment)
        }


      return  binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        groceryViewModel.userSignUpResponse.observe(viewLifecycleOwner){
            binding.textView10.text=it.msg
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