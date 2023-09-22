package com.learning.orderfoodappsch3.presentation.orderfoodlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.learning.orderfoodappsch3.data.CategoryDataSource
import com.learning.orderfoodappsch3.databinding.ItemLinearCategoriesBinding
import com.learning.orderfoodappsch3.model.Category

class CategoriesAdapter(private val categoryDataSource: CategoryDataSource,
    private val onClickListener: (Category) -> Unit
) : RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLinearCategoriesBinding.inflate(inflater, parent, false)
        return CategoryViewHolder(binding, onClickListener)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val categories = categoryDataSource.getCategory()[position]
        holder.bind(categories)
    }

    override fun getItemCount(): Int {
        return categoryDataSource.getCategory().size
    }
}