package com.vickikbt.devtyme.ui.fragment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.vickikbt.devtyme.R
import com.vickikbt.devtyme.databinding.FragmentLoginBinding
import com.vickikbt.devtyme.utils.StateListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(), StateListener {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModels<LoginViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().setTheme(R.style.Theme_FullScreen)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        viewModel.stateListener = this

        initUI()

        return binding.root
    }

    private fun initUI() {

    }

    override fun onLoading() {

    }

    override fun onSuccess(message: String?) {

    }

    override fun onError(exception: Exception, message: String?) {

    }
}