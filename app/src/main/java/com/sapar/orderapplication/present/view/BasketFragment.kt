package com.sapar.orderapplication.present.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sapar.orderapplication.R
import com.sapar.orderapplication.common.const.PIZZA_URL
import com.sapar.orderapplication.data.menu.Meal
import com.sapar.orderapplication.databinding.FragmentBasketBinding
import com.sapar.orderapplication.present.adapters.ChildMenuAdapter
import com.sapar.orderapplication.present.viewmodel.BasketViewModel

class BasketFragment : Fragment(R.layout.fragment_basket),
    ChildMenuAdapter.ChildMenuAdapterListener {

    private var _binding: FragmentBasketBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: BasketViewModel
    private lateinit var basketsMenuAdapter: ChildMenuAdapter
    private var testItems: ArrayList<Meal> = ArrayList()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentBasketBinding.bind(view)

        init()

        viewModel = ViewModelProvider(this)[BasketViewModel::class.java]
    }

    private fun init() {
        basketsMenuAdapter = ChildMenuAdapter(this)
        binding.apply {
            myBasketOrderRV.adapter = basketsMenuAdapter
        }
        testItems.add(
            Meal(
                id = "1",
                name = "Маргаритта",
                imageUrl = PIZZA_URL,
                price = 1700,
                description = "23456"
            )
        )
        testItems.add(
            Meal(
                id = "2",
                name = "Пицца",
                imageUrl = PIZZA_URL,
                price = 1800,
                description = "45623"
            )
        )

        basketsMenuAdapter.items = testItems

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onChangeCount(meal: Meal) {
        viewModel.totalPrice += meal.price * meal.counter
        binding.basketOrderPrice.text = viewModel.totalPrice.toString()
    }
}