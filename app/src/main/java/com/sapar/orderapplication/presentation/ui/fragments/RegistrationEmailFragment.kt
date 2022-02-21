package com.sapar.orderapplication.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sapar.orderapplication.databinding.FragmentRegistrationEmailBinding
import com.sapar.orderapplication.presentation.ui.activity.MainActivity
import com.sapar.orderapplication.presentation.viewmodel.RegistrationEmailViewModel
import kotlinx.android.synthetic.main.activity_main.*

class RegistrationEmailFragment : Fragment() {

    private var _binding: FragmentRegistrationEmailBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = RegistrationEmailFragment()
    }

    private lateinit var viewModel: RegistrationEmailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegistrationEmailBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[RegistrationEmailViewModel::class.java]
        (activity as MainActivity).btnNavView.isGone = false

        init()
    }

    private fun init() {
        binding.apply {
            btnContinue.setOnClickListener {
                onContinueClick(editTextTextEmailAddress.text.toString())
            }
        }
    }

    private fun onContinueClick(email: String) {
        val action =
            RegistrationEmailFragmentDirections.goToEnterPassword(
                email
            )
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}