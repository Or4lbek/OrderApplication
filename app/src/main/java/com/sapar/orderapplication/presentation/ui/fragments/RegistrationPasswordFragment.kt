package com.sapar.orderapplication.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sapar.orderapplication.R
import com.sapar.orderapplication.databinding.FragmentRegistrationPasswordBinding
import com.sapar.orderapplication.presentation.viewmodel.RegistrationPasswordViewModel

class RegistrationPasswordFragment : Fragment(R.layout.fragment_registration_password) {

    private var _binding: FragmentRegistrationPasswordBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: RegistrationPasswordViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegistrationPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[RegistrationPasswordViewModel::class.java]

        val args: RegistrationPasswordFragmentArgs by navArgs()
        val email: String = args.email
        init(email)
    }

    private fun init(email: String) {
        binding.apply {
            btnRegistration.setOnClickListener {
                onRegistrationClick(email, editTextTextPassword.text.toString())
            }
        }
    }

    private fun onRegistrationClick(email: String, password: String) {
        val action = RegistrationPasswordFragmentDirections.goToOrderList()
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}