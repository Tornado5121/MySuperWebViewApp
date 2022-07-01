package com.zhadko.mysuperwebviewapp.ui.noInternetScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zhadko.mysuperwebviewapp.databinding.FragmentNoInternetBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class NoInternetFragment : Fragment() {

    private val noInternetViewModel by viewModel<NoInternetViewModel>()
    private lateinit var binding: FragmentNoInternetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoInternetBinding.inflate(inflater, container, false)
        return binding.root
    }

}