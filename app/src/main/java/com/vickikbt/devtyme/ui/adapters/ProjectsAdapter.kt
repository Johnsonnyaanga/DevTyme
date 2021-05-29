package com.vickikbt.devtyme.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.vickikbt.devtyme.R
import com.vickikbt.devtyme.databinding.ItemProjectBinding
import com.vickikbt.devtyme.models.Project

class ProjectsAdapter constructor(private val projects: List<Project>) :
    RecyclerView.Adapter<ProjectsAdapter.ProjectsAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectsAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemProjectBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_project, parent, false)

        return ProjectsAdapterViewHolder(binding)

    }

    override fun getItemCount() = projects.size

    override fun onBindViewHolder(holder: ProjectsAdapterViewHolder, position: Int) {
        val project = projects[position]

        holder.bind(project)
    }

    inner class ProjectsAdapterViewHolder(private val binding: ItemProjectBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(project: Project) {
            val totalTime = "${project.hours}hrs ${project.minutes}mins"

            binding.textViewProjectName.text = project.name
            binding.textViewProjectTime.text = totalTime
        }
    }
}