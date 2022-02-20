package com.sapar.orderapplication.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.sapar.orderapplication.databinding.FragmentOrderDetailsBinding
import com.sapar.orderapplication.domain.entities.Order
import com.sapar.orderapplication.presentation.viewmodel.MyOrdersDetailViewModel


class OrderFragment : Fragment() {

    private var _binding: FragmentOrderDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MyOrdersDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOrderDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MyOrdersDetailViewModel::class.java]
        val args: OrderFragmentArgs by navArgs()
        val myOrder: Order = args.order
        updateUi(myOrder)
    }

    private fun updateUi(myOrder: Order) {
        with(binding) {
            textViewMyOrderName.text = myOrder.restaurantName
            textViewMyOrderAddress.text = myOrder.restaurantAddress
            textViewMyOrderDate.text = myOrder.orderDate.toString()
            textViewMyOrderNumber.text = myOrder.orderProductList.size.toString()
            textViewMyOrderStatus.text = myOrder.status.string
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}