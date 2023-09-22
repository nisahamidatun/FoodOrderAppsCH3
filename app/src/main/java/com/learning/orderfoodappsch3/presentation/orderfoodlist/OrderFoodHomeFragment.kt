package com.learning.orderfoodappsch3.presentation.orderfoodlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.learning.orderfoodappsch3.R
import com.learning.orderfoodappsch3.data.CategoryDataSource
import com.learning.orderfoodappsch3.data.CategoryDataSourceImpl
import com.learning.orderfoodappsch3.data.OrderFoodDataSource
import com.learning.orderfoodappsch3.data.OrderFoodDataSourceImpl
import com.learning.orderfoodappsch3.databinding.FragmentOrderFoodHomeBinding
import com.learning.orderfoodappsch3.model.OrderFood
import com.learning.orderfoodappsch3.presentation.orderfoodlist.adapter.AdapterLayoutMode
import com.learning.orderfoodappsch3.presentation.orderfoodlist.adapter.CategoriesAdapter
import com.learning.orderfoodappsch3.presentation.orderfoodlist.adapter.OrderFoodListAdapter

class OrderFoodHomeFragment : Fragment() {

    private lateinit var binding: FragmentOrderFoodHomeBinding

    private val datasource: OrderFoodDataSource by lazy {
        OrderFoodDataSourceImpl()
    }

    private val adapter: OrderFoodListAdapter by lazy {
        OrderFoodListAdapter(AdapterLayoutMode.LINEAR) { orderFood: OrderFood ->
            navigateToDetail(orderFood)
        }
    }

    private val categorydatasource: CategoryDataSource by lazy {
        CategoryDataSourceImpl()
    }

    private val categoriesAdapter: CategoriesAdapter by lazy {
        CategoriesAdapter(categorydatasource){it}
    }

    private fun navigateToDetail(orderFood: OrderFood) {
        findNavController().navigate(
            OrderFoodHomeFragmentDirections.actionOrderFoodHomeFragmentToOrderFoodDetailFragment(orderFood)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOrderFoodHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupCategories()
        setupList()
        setupSwicth()
    }

    private fun setupCategories() {
        binding.rvCategories.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategories.adapter = categoriesAdapter
    }

    private fun setupSwicth() {
        binding.btnSwitch.setOnClickListener() {
            switchMode()
        }
    }

    private fun switchMode() {
        when (adapter.adapterLayoutMode) {
            AdapterLayoutMode.LINEAR -> {
                binding.btnSwitch.setImageResource(R.drawable.ic_grid)
                (binding.rvFoodMenu.layoutManager as GridLayoutManager).spanCount = 2
                adapter.adapterLayoutMode = AdapterLayoutMode.GRID
            }
            AdapterLayoutMode.GRID -> {
                binding.btnSwitch.setImageResource(R.drawable.ic_list)
                (binding.rvFoodMenu.layoutManager as GridLayoutManager).spanCount = 1
                adapter.adapterLayoutMode = AdapterLayoutMode.LINEAR
            }
        }
        adapter.refreshList()
    }

    private fun setupList() {
        val span = if(adapter.adapterLayoutMode == AdapterLayoutMode.LINEAR) 1 else 2
        binding.rvFoodMenu.apply {
            layoutManager = GridLayoutManager(requireContext(),span)
            adapter = this@OrderFoodHomeFragment.adapter
        }
        adapter.submitData(datasource.getOrderFoods())
    }

}