package com.practies.groceryapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.practies.groceryapp.R
import com.practies.groceryapp.viewModels.GroceryViewModel
import com.practies.groceryapp.databinding.FragmentRegistrationBinding
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
        //  val message=   groceryViewModel.userSignUpResponse.value?.msg

            // Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_registrationFragment_to_homeFragment)
        }


      return  binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        groceryViewModel.userSignUpResponse.observe(viewLifecycleOwner){
            binding.textView14.text=it.status
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