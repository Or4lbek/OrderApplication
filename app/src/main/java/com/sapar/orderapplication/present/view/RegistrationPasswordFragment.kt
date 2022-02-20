package com.sapar.orderapplication.present.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sapar.orderapplication.R
import com.sapar.orderapplication.databinding.FragmentRegistrationPasswordBinding
import com.sapar.orderapplication.present.viewmodel.RegistrationPasswordViewModel

class RegistrationPasswordFragment : Fragment(R.layout.fragment_registration_password) {

    private var _binding: FragmentRegistrationPasswordBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: RegistrationPasswordViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRegistrationPasswordBinding.bind(view)
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
        val action =
            RegistrationPasswordFragmentDirections.actionRegistrationPasswordFragmentToMyOrdersFragment()
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}