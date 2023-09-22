package com.learning.orderfoodappsch3.presentation.orderfoodlist.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.learning.orderfoodappsch3.core.ViewHolderBinder
import com.learning.orderfoodappsch3.databinding.ItemGridOrderFoodBinding
import com.learning.orderfoodappsch3.databinding.ItemLinearOrderFoodBinding
import com.learning.orderfoodappsch3.model.OrderFood

class LinearOrderFoodItemViewHolder(
    private val binding: ItemLinearOrderFoodBinding,
    private val onClickListener: (OrderFood) -> Unit
): RecyclerView.ViewHolder(binding.root), ViewHolderBinder<OrderFood> {

    override fun bind(item: OrderFood) {
        binding.ivOrderFood.load(item.imgFood){
            crossfade(true)
        }
        binding.tvOrderFoodName.text = item.foodName
        binding.tvPriceFood.text = item.foodPrice.toString()
        binding.root.setOnClickListener {
            onClickListener.invoke(item)
        }
    }
}

class GridOrderFoodItemViewHolder(
    private val binding: ItemGridOrderFoodBinding,
    private val onClickListener: (OrderFood) -> Unit
): RecyclerView.ViewHolder(binding.root), ViewHolderBinder<OrderFood> {

    override fun bind(item: OrderFood) {
        binding.ivOrderFood.load(item.imgFood){
            crossfade(true)
        }
        binding.tvOrderFoodName.text = item.foodName
        binding.tvPriceFood.text = item.foodPrice.toString()
        binding.root.setOnClickListener {
            onClickListener.invoke(item)
        }
    }
}