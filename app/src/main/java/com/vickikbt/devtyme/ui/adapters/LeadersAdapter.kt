package com.vickikbt.devtyme.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vickikbt.devtyme.models.Leaders

class LeadersAdapter constructor(leaders:List<Leaders>) :
    RecyclerView.Adapter<LeadersAdapter.LeadersAdapterViewHolder>(){
        inner class LeadersAdapterViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeadersAdapterViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: LeadersAdapterViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}