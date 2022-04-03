package com.practies.groceryapp.Ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.practies.groceryapp.R
import com.practies.groceryapp.ViewModels.GroceryViewModel
import com.practies.groceryapp.adapters.GroceryRecyclerAdapter
import com.practies.groceryapp.databinding.FragmentHomeBinding
import com.practies.groceryapp.interfacess.OnItemClickListeners
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(),OnItemClickListeners {

private  var _binding: FragmentHomeBinding?=null
    private val binding get() = _binding!!

private lateinit var groceryAdapter:GroceryRecyclerAdapter

private val groceryViewModel:GroceryViewModel by activityViewModels ()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

   _binding= FragmentHomeBinding.inflate(inflater,container,false)

        val  list= listOf("product1","product2","product3","product4","product5","product6","product7","product8")
       groceryAdapter= GroceryRecyclerAdapter(this)

           groceryViewModel.getAllProductsList()
        return  binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
        binding.recyclerView.apply {
            layoutManager= GridLayoutManager(context,2)
            adapter=groceryAdapter
        }

    }


    private fun setUpView(){

        groceryViewModel.productListLiveData.observe(viewLifecycleOwner){
            groceryAdapter.differ.submitList(it)
        }
    }

    override fun onItemClick(Position: Int) {



        groceryViewModel.productId= groceryAdapter.differ.currentList[Position].product_id

        // val action=HomeFragmentDirections.actionHomeFragmentToItemDetialsFragment(itemId)

        findNavController().navigate(R.id.action_homeFragment_to_itemDetialsFragment)
    }


}