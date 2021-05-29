package com.vickikbt.devtyme.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.vickikbt.devtyme.R
import com.vickikbt.devtyme.databinding.ItemLanguageBinding
import com.vickikbt.devtyme.models.Language

class LanguagesAdapter constructor(private val languages: List<Language>) :
    RecyclerView.Adapter<LanguagesAdapter.LanguagesAdapterViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LanguagesAdapter.LanguagesAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemLanguageBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_language, parent, false)

        return LanguagesAdapterViewHolder(binding)

    }

    override fun getItemCount() = languages.size

    override fun onBindViewHolder(
        holder: LanguagesAdapter.LanguagesAdapterViewHolder,
        position: Int
    ) {
        val language = languages[position]

        holder.bind(language)
    }

    inner class LanguagesAdapterViewHolder(private val binding: ItemLanguageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(language: Language) {
            val totalTime = "${language.hours}hrs ${language.minutes}mins"

            binding.textViewLanguageName.text = language.name
            binding.textViewLanguageTime.text = totalTime
        }
    }
}