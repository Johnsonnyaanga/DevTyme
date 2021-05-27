package com.vickikbt.devtyme.ui.fragment.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.vickikbt.devtyme.R
import com.vickikbt.devtyme.databinding.FragmentHomeBinding
import com.vickikbt.devtyme.utils.Helpers.getTimeOfDay
import com.vickikbt.devtyme.utils.StateListener
import com.vickikbt.devtyme.utils.getDisplayName
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : Fragment(), StateListener {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewModel.stateListener = this

        setFullScreen(false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    @SuppressLint("SetTextI18n")
    private fun initUI() {
        binding.imageViewProfilePic.setOnClickListener { viewModel.revokeToken() }

        val greetingMessage = getTimeOfDay()
        viewModel.currentUser.observe(viewLifecycleOwner) { user ->
            binding.textViewGreeting.text =
                "$greetingMessage ${user.displayName?.getDisplayName()}."
            Glide.with(this).load(user.photo).circleCrop().into(binding.imageViewProfilePic)
        }
    }

    private fun setFullScreen(setFullScreen: Boolean = true) {
        if (setFullScreen) requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        else requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    override fun onLoading() {
        Timber.e("Loading...")
    }

    override fun onSuccess(message: String?) {
        //Timber.e(message)
    }

    override fun onError(exception: Exception, message: String?) {
        Timber.e("Error: $exception")
    }

}