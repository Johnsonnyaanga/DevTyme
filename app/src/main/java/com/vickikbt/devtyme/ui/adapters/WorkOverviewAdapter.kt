package com.vickikbt.devtyme.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.vickikbt.devtyme.R
import com.vickikbt.devtyme.databinding.ItemWorkOverviewBinding
import com.vickikbt.devtyme.models.Category

class WorkOverviewAdapter constructor(private val categories: List<Category>) :
    RecyclerView.Adapter<WorkOverviewAdapter.WorkOverviewAdapterViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WorkOverviewAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemWorkOverviewBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_work_overview, parent, false)

        return WorkOverviewAdapterViewHolder(binding)

    }

    override fun getItemCount() = categories.size

    override fun onBindViewHolder(
        holder: WorkOverviewAdapterViewHolder,
        position: Int
    ) {
        val category = categories[position]

        holder.bind(category)
    }

    inner class WorkOverviewAdapterViewHolder(private val binding: ItemWorkOverviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(category: Category) {
            val totalTime = "${category.hours}hrs ${category.minutes}mins"

            binding.textViewWorkName.text = category.name
            binding.textViewWorkTime.text = totalTime
        }
    }
}