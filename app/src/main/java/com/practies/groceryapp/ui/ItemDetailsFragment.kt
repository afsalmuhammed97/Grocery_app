package com.practies.groceryapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.practies.groceryapp.viewModels.GroceryViewModel
import com.practies.groceryapp.databinding.FragmentItemDetialsBinding

class ItemDetailsFragment : Fragment() {
   // private val args:ItemDetailsFragmentArgs by navArgs()
    private  var _binding: FragmentItemDetialsBinding?=null
    private val binding get() = _binding!!
    private val groceryViewModel: GroceryViewModel by activityViewModels ()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


      _binding= FragmentItemDetialsBinding.inflate(inflater,container,false)

      //  val itemId=args.productId

        groceryViewModel.getProductDetails()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



         groceryViewModel.productDetailsLiveData.observe(viewLifecycleOwner){
             binding.productNameText.text=it.name
             binding.productPriseText.text=it.price

        }




    }


}