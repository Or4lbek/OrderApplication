package com.sapar.orderapplication.present.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sapar.orderapplication.R
import com.sapar.orderapplication.databinding.FragmentBottomSheetMenuBinding

class BottomSheetMenuFragment(private val itemsMenu: ArrayList<String>) : BottomSheetDialogFragment() {

    private var _binding: FragmentBottomSheetMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_bottom_sheet_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentBottomSheetMenuBinding.bind(view)

        init()
    }

    private fun init() {
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, itemsMenu)
        binding.menuLV.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}