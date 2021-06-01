package com.vickikbt.devtyme.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.vickikbt.devtyme.R
import com.vickikbt.devtyme.databinding.LeadersCardBinding
import com.vickikbt.devtyme.models.Leaders

class LeadersAdapter constructor(private val leaders: List<Leaders>) :
    RecyclerView.Adapter<LeadersAdapter.LeadersAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeadersAdapter.LeadersAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: LeadersCardBinding=
            DataBindingUtil.inflate(layoutInflater, R.layout.leaders_card, parent, false)

        return LeadersAdapterViewHolder(binding)

    }

    override fun onBindViewHolder(holder: LeadersAdapterViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = leaders.size

    inner class LeadersAdapterViewHolder(private val binding: LeadersCardBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(leader:Leaders){
            val rank = "${leader.board?.get(0)}."
            val name=leader.currentUser.displayName
            binding.txtLeaderNumber.text=rank
            binding.txtLeaderName.text=name

        }
    }


}