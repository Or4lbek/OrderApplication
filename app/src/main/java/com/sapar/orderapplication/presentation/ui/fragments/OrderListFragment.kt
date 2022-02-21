package com.sapar.orderapplication.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sapar.orderapplication.databinding.FragmentOrderListBinding
import com.sapar.orderapplication.domain.entities.Order
import com.sapar.orderapplication.presentation.adapters.OrderListAdapter
import com.sapar.orderapplication.presentation.ui.activity.MainActivity
import com.sapar.orderapplication.presentation.viewmodel.MyOrdersViewModel
import kotlinx.android.synthetic.main.activity_main.*


class OrderListFragment : Fragment() {

    private var _binding: FragmentOrderListBinding? = null
    private val binding get() = _binding!!
    private lateinit var orderListAdapter: OrderListAdapter
    private lateinit var viewModel: MyOrdersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOrderListBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MyOrdersViewModel::class.java]
        (activity as MainActivity).btnNavView.visibility = View.VISIBLE

//        initRecyclerView()
//        initViewModel()
        binding.btnSignIn.setOnClickListener { onSignInClick() }
    }

    private fun initRecyclerView() {

        orderListAdapter = OrderListAdapter()
        orderListAdapter.clickListener = {
            onNoteClick(it)
        }
        binding.recyclerViewMyOrders.adapter = orderListAdapter
    }

    private fun initViewModel() {
        viewModel.liveDataMyOrders.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.progressBarMyOrders.visibility = View.GONE
                orderListAdapter.submitList(it)
            } else {
                Toast.makeText(requireContext(), "Error in getting list...", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        viewModel.loadMyOrdersApi()
    }

    private fun onNoteClick(it: Order) {
        val action = OrderListFragmentDirections.goToOrderDetails(
            it
        )
        findNavController().navigate(action)
    }

    private fun onSignInClick() {
        val action =
            OrderListFragmentDirections.goToSignUp()
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}