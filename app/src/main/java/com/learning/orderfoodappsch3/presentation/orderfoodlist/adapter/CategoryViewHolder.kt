package com.learning.orderfoodappsch3.presentation.orderfoodlist.adapter

import androidx.recyclerview.widget.RecyclerView
import com.learning.orderfoodappsch3.core.ViewHolderBinder
import com.learning.orderfoodappsch3.databinding.ItemLinearCategoriesBinding
import com.learning.orderfoodappsch3.model.Category

class CategoryViewHolder(
    private val binding: ItemLinearCategoriesBinding,
    private val onClickListener: (Category) -> Unit
): RecyclerView.ViewHolder(binding.root), ViewHolderBinder<Category> {

    override fun bind(item: Category) {
        binding.root.setOnClickListener{
            onClickListener.invoke(item)
        }
        binding.ivCategories.setImageResource(item.imgCategory)
        binding.tvCategories.text =item.nameCategory
    }
}