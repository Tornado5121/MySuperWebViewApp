package com.zhadko.mysuperwebviewapp.ui.startScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zhadko.mysuperwebviewapp.R
import com.zhadko.mysuperwebviewapp.databinding.FragmentStartBinding
import com.zhadko.mysuperwebviewapp.ui.noInternetScreen.NoInternetFragment
import com.zhadko.mysuperwebviewapp.ui.webViewScreen.WebViewFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class StartFragment : Fragment() {

    private val startViewModel by viewModel<StartViewModel>()
    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.acceptButton.setOnClickListener {
            startViewModel.setFirstLaunchFlagToFalse()
            if (startViewModel.isNetworkConnected()) {
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.my_fragment_container, WebViewFragment())
                    .commit()
            } else {
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.my_fragment_container, NoInternetFragment())
                    .commit()
            }
        }

        binding.denyButton.setOnClickListener {
            requireActivity().finish()
        }
    }

}