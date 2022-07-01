package com.zhadko.mysuperwebviewapp.ui.webViewScreen

import android.os.Bundle
import android.view.*
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.zhadko.mysuperwebviewapp.databinding.FragmentWebViewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class WebViewFragment : Fragment() {

    private val webViewViewModel by viewModel<WebViewViewModel>()
    private lateinit var binding: FragmentWebViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWebViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myLastViewedPage = webViewViewModel.getLastViewedPage()

        with(binding) {
            if (myLastViewedPage.isNotEmpty()) {
                myWebView.loadUrl(myLastViewedPage)
            } else {
                myWebView.loadUrl("https://www.google.com/")
            }

            myWebView.settings.javaScriptEnabled = true
            myWebView.settings.setSupportZoom(false)
            myWebView.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
            myWebView.settings.builtInZoomControls = false
            myWebView.webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    if (url != null) {
                        webViewViewModel.saveLastViewedPage(url)
                    }
                }
            }

            myWebView.setOnKeyListener { _, keyCode, event ->
                if (keyCode == KeyEvent.KEYCODE_BACK &&
                    event.action == MotionEvent.ACTION_UP &&
                    myWebView.canGoBack()
                ) {
                    myWebView.goBack()
                    return@setOnKeyListener true
                } else {
                    return@setOnKeyListener false
                }
            }
        }
    }

}