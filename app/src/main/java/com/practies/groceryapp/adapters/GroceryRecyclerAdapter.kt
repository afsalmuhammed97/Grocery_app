package com.practies.groceryapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.practies.groceryapp.databinding.ProductItemBinding
import com.practies.groceryapp.databinding.RecyclerItemBinding
import com.practies.groceryapp.interfacess.OnItemClickListeners
import com.practies.groceryapp.model.Product
//val list:List<String>
class GroceryRecyclerAdapter(private val listener:OnItemClickListeners):RecyclerView.Adapter<GroceryRecyclerAdapter.ItemHolder>() {


     private val diffCallBack=object :DiffUtil.ItemCallback<Product>(){
         override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
             return  oldItem==newItem
         }

         override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return  oldItem.product_id==newItem.product_id
         }

     }

    val differ=AsyncListDiffer(this,diffCallBack)



  inner  class ItemHolder (val binding:ProductItemBinding):RecyclerView.ViewHolder(binding.root),View.OnClickListener{

       init {
           binding.singleItem.setOnClickListener(this   )
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
                val item=differ.currentList[position]

                 holder.binding.productName.text=item.product_name
    }

    override fun getItemCount()=differ.currentList.size
}