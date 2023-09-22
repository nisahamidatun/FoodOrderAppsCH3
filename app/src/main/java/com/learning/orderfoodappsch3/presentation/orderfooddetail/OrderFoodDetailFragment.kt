package com.learning.orderfoodappsch3.presentation.orderfooddetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import coil.load
import com.learning.orderfoodappsch3.databinding.FragmentOrderFoodDetailBinding
import com.learning.orderfoodappsch3.model.OrderFood

class OrderFoodDetailFragment : Fragment() {

    private lateinit var binding: FragmentOrderFoodDetailBinding
    private val orderFood: OrderFood? by lazy {
        OrderFoodDetailFragmentArgs.fromBundle(arguments as Bundle).orderFood
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOrderFoodDetailBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
        showOrderFoodData()
        countTotalItemFood()
    }

    /*Menampilkan data orderfood yang dipilih dan sudah diterima*/
    private fun showOrderFoodData() {
        orderFood?.let { p ->
            binding.apply {
                ivOrderFood.load(p.imgFood) {
                    crossfade(true)
                }
                tvOrderFoodName.text = p.foodName
                tvDescMenu.text = p.desc
                tvPriceFood.text = p.foodPrice.toString()
            }
        }
    }

    private fun countTotalItemFood(){
        var item = 0

        binding.btnAdd.setOnClickListener {
            item++
            binding.tvTotalOrder.text = item.toString()
            binding.tvTotalPrice.text = (item * orderFood!!.foodPrice).toString()
        }

        binding.btnMinus.setOnClickListener {
            if (item > 0) {
                item--
                binding.tvTotalOrder.text = item.toString()
                binding.tvTotalPrice.text = (item * orderFood!!.foodPrice).toString()

            }
        }
    }

    private fun setClickListener() {
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.tvMaps.setOnClickListener {
            navigateToGoogleMaps()
        }
    }

    private fun navigateToGoogleMaps() {
        orderFood?.let {
            val mapUrl = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(mapUrl))
            startActivity(intent)
        }
    }
}