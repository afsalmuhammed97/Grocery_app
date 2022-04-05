package com.practies.groceryapp.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.practies.groceryapp.R
import com.practies.groceryapp.viewModels.GroceryViewModel
import com.practies.groceryapp.databinding.FragmentRegistrationBinding
import com.practies.groceryapp.network.helper.Constants.SUCCESS
import dagger.hilt.android.AndroidEntryPoint


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
                 val fullName=binding.editTextTextPersonName.text.toString()
                 val userEmail=binding.textEmailAddress.text.toString()

            groceryViewModel.userSignUp(requireContext(),fullName,userEmail)




        }


      return  binding.root
    }


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        groceryViewModel.userSignUpResponse.observe(viewLifecycleOwner){

//
            if(it.status== SUCCESS){
                Toast.makeText(context,"You registered successfully",Toast.LENGTH_SHORT).show()

                saveUserId(it.msg.phone[5])

                findNavController().navigate(R.id.action_registrationFragment_to_homeFragment)
            }else{
                Toast.makeText(context,it.msg.phone.toString(),Toast.LENGTH_SHORT).show()
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


    private fun saveUserId(userId:String){
        val sharedPref=requireActivity().getSharedPreferences("userRegistration", Context.MODE_PRIVATE)
        val editor=sharedPref.edit()
        editor.putString("userId",userId)
       // editor.putBoolean("Finished",true)
        editor.apply()
    }


}