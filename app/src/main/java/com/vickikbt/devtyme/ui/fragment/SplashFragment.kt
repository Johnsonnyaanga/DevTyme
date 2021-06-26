package com.vickikbt.devtyme.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.vickikbt.devtyme.R
import com.vickikbt.devtyme.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSplashBinding.bind(view)

        initUI()
    }

    private fun initUI(){
        binding.textViewSplash.setOnClickListener { findNavController().navigate(R.id.splash_to_auth_module) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}