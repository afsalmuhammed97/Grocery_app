package com.practies.groceryapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.practies.groceryapp.R
import com.practies.groceryapp.databinding.FragmentOtpVarificationBinding
import com.practies.groceryapp.viewModels.GroceryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OtpVarificationFragment : Fragment() {
    private val groceryViewModel:GroceryViewModel by activityViewModels ()

    private  var _binding:FragmentOtpVarificationBinding?=null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        _binding= FragmentOtpVarificationBinding.inflate(inflater,container,false)

        binding.sendVarificationButton.setOnClickListener{



            val otpInPut="${binding.otp1.text}" +
                    "${binding.otp2.text}" +
                    "${binding.otp3.text}" +
                    "${binding.otp4.text}" +
                    "${binding.otp5.text}" +
                    "${binding.otp6.text}"



               if ( otpInPut.equals( groceryViewModel.otpResultData.value?.otp)) {


                   findNavController().navigate(R.id.action_otpVarificationFragment_to_registrationFragment)
               }else{
                   Toast.makeText(context,"wrong enter please enter valid otp",Toast.LENGTH_SHORT).show()
               }

        }

        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



       groceryViewModel.otpResultData.observe(viewLifecycleOwner){
           binding.textView13.text=it.otp

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