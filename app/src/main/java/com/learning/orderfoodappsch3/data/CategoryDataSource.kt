package com.learning.orderfoodappsch3.data

import com.learning.orderfoodappsch3.R
import com.learning.orderfoodappsch3.model.Category


interface CategoryDataSource {
    fun getCategory(): List<Category>
}

class CategoryDataSourceImpl() : CategoryDataSource {
    override fun getCategory(): List<Category> {
        return mutableListOf(
            Category(R.drawable.ic_nearby, "Nearby"),
            Category(R.drawable.ic_ricenoodle, "Rice & Noodle"),
            Category(R.drawable.ic_fastfood,"Fast Food"),
            Category(R.drawable.ic_drink,"Drink"),
        )
    }
}