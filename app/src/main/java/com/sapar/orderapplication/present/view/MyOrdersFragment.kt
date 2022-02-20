package com.sapar.orderapplication.present.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sapar.orderapplication.R
import com.sapar.orderapplication.data.my_orders.MyOrdersItem
import com.sapar.orderapplication.databinding.FragmentMyOrdersBinding
import com.sapar.orderapplication.present.MainActivity
import com.sapar.orderapplication.present.adapters.MyOrdersAdapter
import com.sapar.orderapplication.present.viewmodel.MyOrdersViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MyOrdersFragment : Fragment(R.layout.fragment_my_orders) {

    private var _binding: FragmentMyOrdersBinding? = null
    private val binding get() = _binding!!
    private lateinit var myOrdersAdapter: MyOrdersAdapter
    private lateinit var viewModel: MyOrdersViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMyOrdersBinding.bind(view)
        viewModel = ViewModelProvider(this)[MyOrdersViewModel::class.java]
        (activity as MainActivity).btnNavView.visibility = View.VISIBLE

//        initRecyclerView()
//        initViewModel()
        binding.btnSignIn.setOnClickListener { onSignInClick() }
    }

    private fun initRecyclerView() {

        myOrdersAdapter = MyOrdersAdapter { onNoteClick(it) }
        binding.recyclerViewMyOrders.adapter = myOrdersAdapter

        if (myOrdersAdapter.items.isEmpty()) {
            binding.progressBarMyOrders.visibility = View.VISIBLE
        }
    }

    private fun initViewModel() {
        viewModel.liveDataMyOrders.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.progressBarMyOrders.visibility = View.GONE
                if (myOrdersAdapter.items.isEmpty()) {
                    myOrdersAdapter.items = it
                }
            } else {
                Toast.makeText(requireContext(), "Error in getting list...", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        viewModel.loadMyOrdersApi()
    }

    private fun onNoteClick(it: MyOrdersItem) {
        val action = MyOrdersFragmentDirections.actionMyOrdersFragmentToMyOrdersDetailFragment(
            it
        )
        findNavController().navigate(action)
    }

    private fun onSignInClick() {
        val action = MyOrdersFragmentDirections.actionMyOrdersFragmentToRegistrationEmailFragment()
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}