package com.vickikbt.devtyme.ui.fragment.board

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.vickikbt.devtyme.R
import com.vickikbt.devtyme.databinding.FragmentBoardBinding
import com.vickikbt.devtyme.ui.adapters.BoardAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BoardFragment : Fragment() {

    private lateinit var binding: FragmentBoardBinding
    private val viewModel by viewModels<BoardViewModel>()

    private val adapter by lazy { BoardAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_board, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() {
        binding.recyclerviewLeaders.adapter=adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchLeaderBoard().collectLatest {
                adapter.submitData(it)
            }
        }
    }

}