package com.sapar.orderapplication.present.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sapar.orderapplication.R
import com.sapar.orderapplication.data.establishment.EstablishmentsItem
import com.sapar.orderapplication.databinding.FragmentMainEstablishmentsBinding
import com.sapar.orderapplication.present.MainActivity
import com.sapar.orderapplication.present.adapters.EstablishmentsAdapter
import com.sapar.orderapplication.present.viewmodel.MainEstablishmentsViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainEstablishmentsFragment : Fragment(R.layout.fragment_main_establishments) {

    private var _binding: FragmentMainEstablishmentsBinding? = null
    private val binding get() = _binding!!

    private lateinit var establishmentsAdapter: EstablishmentsAdapter
    private lateinit var viewModel: MainEstablishmentsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainEstablishmentsViewModel::class.java]
        _binding = FragmentMainEstablishmentsBinding.bind(view)
        (activity as MainActivity).btnNavView.visibility = View.VISIBLE

        initRecyclerView()
        initProgressBar()
        initViewModel()
    }

    private fun initRecyclerView() {
        establishmentsAdapter = EstablishmentsAdapter {
            onNoteClick(it)
        }
        binding.recyclerViewEstablishments.adapter = establishmentsAdapter

        if (establishmentsAdapter.items.isEmpty()) {
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
                if (establishmentsAdapter.items.isEmpty()) {
                    establishmentsAdapter.items = it
                }
            } else {
                Toast.makeText(requireContext(), "Error in getting list...", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        viewModel.loadEstablishmentsApi()
    }

    private fun onNoteClick(establishment: EstablishmentsItem) {
        val action =
            MainEstablishmentsFragmentDirections.actionMainEstablishmentsFragmentToEstablishmentDetailFragment(
                establishment.name,
                establishment
            )
        findNavController().navigate(action)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}