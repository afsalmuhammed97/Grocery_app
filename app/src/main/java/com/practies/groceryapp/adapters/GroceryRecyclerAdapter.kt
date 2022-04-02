package com.practies.groceryapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practies.groceryapp.databinding.ProductItemBinding
import com.practies.groceryapp.databinding.RecyclerItemBinding
import com.practies.groceryapp.interfacess.OnItemClickListeners

class GroceryRecyclerAdapter(val list:List<String>,private val listener:OnItemClickListeners):RecyclerView.Adapter<GroceryRecyclerAdapter.ItemHolder>() {


  inner  class ItemHolder (val binding:ProductItemBinding):RecyclerView.ViewHolder(binding.root),View.OnClickListener{

       init {
           binding.singleItem.setOnClickListener(this)
       }
        override fun onClick(v: View?) {
            val position=absoluteAdapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): GroceryRecyclerAdapter.ItemHolder {
    return  ItemHolder(ProductItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: GroceryRecyclerAdapter.ItemHolder, position: Int) {
                 holder.binding.productName.text=list[position]
    }

    override fun getItemCount()=list.size
}