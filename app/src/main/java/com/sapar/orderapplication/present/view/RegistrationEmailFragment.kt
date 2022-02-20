package com.sapar.orderapplication.present.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sapar.orderapplication.R
import com.sapar.orderapplication.databinding.FragmentRegistrationEmailBinding
import com.sapar.orderapplication.present.MainActivity
import com.sapar.orderapplication.present.viewmodel.RegistrationEmailViewModel
import kotlinx.android.synthetic.main.activity_main.*

class RegistrationEmailFragment : Fragment(R.layout.fragment_registration_email) {

    private var _binding: FragmentRegistrationEmailBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = RegistrationEmailFragment()
    }

    private lateinit var viewModel: RegistrationEmailViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRegistrationEmailBinding.bind(view)
        viewModel = ViewModelProvider(this)[RegistrationEmailViewModel::class.java]
        (activity as MainActivity).btnNavView.visibility = View.GONE

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
            RegistrationEmailFragmentDirections.actionRegistrationEmailFragmentToRegistrationPasswordFragment(
                email
            )
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}