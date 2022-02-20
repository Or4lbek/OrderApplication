package com.sapar.orderapplication.present.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sapar.orderapplication.R
import com.sapar.orderapplication.common.const.RAQMET_URL
import com.sapar.orderapplication.databinding.FragmentRaqmetBinding
import com.sapar.orderapplication.present.MainActivity
import com.sapar.orderapplication.present.viewmodel.RaqmetViewModel
import kotlinx.android.synthetic.main.activity_main.*


class RaqmetFragment : Fragment(R.layout.fragment_raqmet) {

    private var _binding: FragmentRaqmetBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: RaqmetViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[RaqmetViewModel::class.java]
        _binding = FragmentRaqmetBinding.bind(view)
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
            loadUrl(RAQMET_URL)
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