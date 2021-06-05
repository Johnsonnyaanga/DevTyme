package com.vickikbt.devtyme.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vickikbt.devtyme.R
import com.vickikbt.devtyme.databinding.ItemBoardBinding
import com.vickikbt.devtyme.models.Leader
import com.vickikbt.devtyme.utils.gone
import com.vickikbt.devtyme.utils.visible

class BoardAdapter : PagingDataAdapter<Leader, BoardViewHolder>(BoardComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemBoardBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_board, parent, false)

        return BoardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        val leader = getItem(position)
        val context = holder.itemView.context

        holder.bind(context, leader!!)
    }

}

@SuppressLint("SetTextI18n")
class BoardViewHolder(private val binding: ItemBoardBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(context: Context, leader: Leader) {
        binding.textViewRank.text = "${leader.rank}."
        Glide.with(context).load(leader.user.photo).circleCrop().into(binding.imageViewLeader)
        binding.textViewUsername.text = leader.user.username
        binding.textViewLeaderWorkTime.text = leader.runningTotal.humanReadableTotal

        /*if (leader.user.isHireable!!) binding.imageViewHireable.visible()
        else binding.imageViewHireable.gone()*/
    }
}

object BoardComparator : DiffUtil.ItemCallback<Leader>() {
    override fun areItemsTheSame(oldItem: Leader, newItem: Leader): Boolean {
        return oldItem.user.id == newItem.user.id
    }

    override fun areContentsTheSame(oldItem: Leader, newItem: Leader): Boolean {
        return oldItem == newItem
    }

}