package com.sapar.orderapplication.presentation.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sapar.orderapplication.R
import com.sapar.orderapplication.common.Constants
import com.sapar.orderapplication.databinding.FragmentRaqmetBinding
import com.sapar.orderapplication.presentation.ui.activity.MainActivity
import com.sapar.orderapplication.presentation.viewmodel.RaqmetViewModel
import kotlinx.android.synthetic.main.activity_main.*


class RaqmetFragment : Fragment() {

    private var _binding: FragmentRaqmetBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: RaqmetViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRaqmetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[RaqmetViewModel::class.java]
        (activity as MainActivity).btnNavView.visibility = View.VISIBLE
        loadWebView()
    }


    @SuppressLint("SetJavaScriptEnabled")
    fun loadWebView() {
        binding.webView.apply {
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView,
                    url: String
                ): Boolean {
                    view.loadUrl(url)
                    return true
                }
            }
            loadUrl(Constants.RAQMET_URL)
            settings.javaScriptEnabled = true
            settings.allowContentAccess = true
            settings.domStorageEnabled = true
            settings.useWideViewPort = true
        }
    }

    // to avoid memory leak
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}