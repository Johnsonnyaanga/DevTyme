package com.vickikbt.devtyme.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.vickikbt.devtyme.R
import com.vickikbt.devtyme.databinding.ItemBoardBinding
import com.vickikbt.devtyme.models.Board

class BoardAdapter constructor(private val leaders: List<Board>) :
    RecyclerView.Adapter<BoardAdapter.BoardAdapterViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BoardAdapter.BoardAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemBoardBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_board, parent, false)

        return BoardAdapterViewHolder(binding)

    }

    override fun onBindViewHolder(holder: BoardAdapterViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = leaders.size

    inner class BoardAdapterViewHolder(private val binding: ItemBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(leader: Board) {
            val rank = "${leader.board?.get(0)}."
            val name = leader.currentUser.displayName
            binding.txtLeaderNumber.text = rank
            binding.txtLeaderName.text = name

        }
    }


}