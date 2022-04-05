package com.practies.groceryapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
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

             binding.productPriseText.text=groceryViewModel.selectedProductId.toString()

        groceryViewModel.getProductDetails(groceryViewModel.selectedProductId)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

             groceryViewModel.detailsOfProduct.observe(viewLifecycleOwner){

                 binding.productNameText.text=it[0]
                 binding.productPriseText.text=it[1]

             }

//         groceryViewModel.productDetailsLiveData.observe(viewLifecycleOwner){
//             binding.productNameText.text=it.details[0].name
//             binding.productPriseText.text=it.details[0].price
//
//             Glide
//                 .with(requireContext())
//                 .load(it.details[0].image)
//                 .centerCrop()
//                 // .placeholder(R.drawable.loading_spinner)
//                 .into(binding.productImage)
//
//        }




    }


}