package com.vickikbt.devtyme.ui.fragment.login

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.vickikbt.devtyme.R
import com.vickikbt.devtyme.databinding.FragmentLoginBinding
import com.vickikbt.devtyme.utils.Constants
import com.vickikbt.devtyme.utils.StateListener
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class LoginFragment : Fragment(), StateListener {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        viewModel.stateListener = this

        //setFullScreen()

        initUI()

        return binding.root
    }

    private fun initUI() {
        binding.buttonSignIn.setOnClickListener {
            openBrowserWindow()
        }
    }

    private fun openBrowserWindow() {
        val intent = Intent.ACTION_VIEW
        val url = Uri.parse(Constants.WEB_URL)
        val openBrowserIntent = Intent(intent, url)
        requireActivity().startActivity(openBrowserIntent)
    }

    override fun onResume() {
        super.onResume()

        val callbackUri = requireActivity().intent.data

        if (callbackUri != null && callbackUri.toString().startsWith(Constants.REDIRECT_URL)) {
            val code = callbackUri.getQueryParameter("code")
            if (code != null) {
                Timber.e("Code fetched: $code")
                viewModel.fetchNewAccessToken(code)
            } else callbackUri.getQueryParameter("error")?.let {
                Timber.e(RuntimeException(it))
            }
        } else {
            Timber.e("Nothing was returned!")
        }
    }

    override fun onStart() {
        super.onStart()

        viewModel.isUserLoggedIn().observe(viewLifecycleOwner) { isUserLoggedIn ->
            if (isUserLoggedIn) findNavController().navigate(R.id.login_to_home)
        }
    }


    override fun onLoading() {
        Timber.e("Loading...")
    }

    override fun onSuccess(message: String?) {
        findNavController().navigate(R.id.login_to_home)
    }

    override fun onError(exception: Exception, message: String?) {
        Timber.e(message)
    }
}