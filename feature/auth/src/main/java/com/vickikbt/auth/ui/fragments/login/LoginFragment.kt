package com.vickikbt.auth.ui.fragments.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.vickikbt.auth.R
import com.vickikbt.auth.databinding.FragmentLoginBinding

//@Android
class LoginFragment : Fragment(R.layout.fragment_login) {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLoginBinding.bind(view)

        iniUI()

    }

    private fun iniUI() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}