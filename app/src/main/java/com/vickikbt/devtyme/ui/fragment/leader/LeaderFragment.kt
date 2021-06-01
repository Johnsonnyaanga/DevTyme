package com.vickikbt.devtyme.ui.fragment.leader

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.vickikbt.devtyme.R
import com.vickikbt.devtyme.ui.fragment.home.HomeViewModel
import com.vickikbt.devtyme.utils.StateListener
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class LeaderFragment : Fragment(),StateListener {

    private val viewModel by viewModels<LeaderViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val root= inflater.inflate(R.layout.fragment_leader, container, false)
        viewModel.stateListener=this
        initUI()
        return root
    }

    private  fun initUI(){
        viewModel.board.observe(viewLifecycleOwner){
            Timber.e("$it")
        }
    }

    override fun onLoading() {

    }

    override fun onSuccess(message: String?) {

    }

    override fun onError(exception: Exception, message: String?) {

    }

}