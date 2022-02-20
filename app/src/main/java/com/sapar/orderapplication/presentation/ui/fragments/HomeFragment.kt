package com.sapar.orderapplication.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sapar.orderapplication.databinding.FragmentHomeBinding
import com.sapar.orderapplication.domain.entities.RestaurantDetails
import com.sapar.orderapplication.presentation.adapters.RestaurantListAdapter
import com.sapar.orderapplication.presentation.ui.activity.MainActivity
import com.sapar.orderapplication.presentation.viewmodel.MainEstablishmentsViewModel
import kotlinx.android.synthetic.main.activity_main.*


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var restaurantListAdapter: RestaurantListAdapter
    private lateinit var viewModel: MainEstablishmentsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainEstablishmentsViewModel::class.java]
        (activity as MainActivity).btnNavView.visibility = View.VISIBLE

        initRecyclerView()
        initProgressBar()
        initViewModel()
    }

    private fun initRecyclerView() {
        restaurantListAdapter = RestaurantListAdapter {
            onNoteClick(it)
        }
        binding.recyclerViewEstablishments.adapter = restaurantListAdapter

        if (restaurantListAdapter.items.isEmpty()) {
            binding.progressBar.visibility = View.VISIBLE
        }
    }

    private fun initProgressBar() {
//        val doubleBounce: Sprite = ThreeBounce()
//        binding.progressBar.setIndeterminateDrawable(doubleBounce)
    }

    private fun initViewModel() {
        val viewModel: MainEstablishmentsViewModel =
            ViewModelProvider(this)[MainEstablishmentsViewModel::class.java]
        viewModel.liveDataEstablishments.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.progressBar.visibility = View.GONE
                if (restaurantListAdapter.items.isEmpty()) {
                    restaurantListAdapter.items = it
                }
            } else {
                Toast.makeText(requireContext(), "Error in getting list...", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        viewModel.loadEstablishmentsApi()
    }

    private fun onNoteClick(restaurant: RestaurantDetails) {
        val action =
            HomeFragmentDirections.goToRestaurantDetails(
                restaurant
            )
        findNavController().navigate(action)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}