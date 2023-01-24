package com.example.musicapp.fragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicapp.databinding.TagLayoutBinding
import com.example.musicapp.fragment.WelcomeFragment
import com.example.musicapp.models.Tag1

class TagsAdapter(var WF: WelcomeFragment?, private var tagsList: ArrayList<Tag1>) : RecyclerView.Adapter<TagsAdapter.TagsAdapterViewHolder>() {


    private lateinit var binding: TagLayoutBinding

    inner class TagsAdapterViewHolder(private val binding: TagLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tabs: String) {
            binding.tabId.text = tabs
            binding.root.setOnClickListener {
                WF?.setOnCLikListner(tabs)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagsAdapterViewHolder {
        binding = TagLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TagsAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TagsAdapterViewHolder, position: Int) {
        val tabs = tagsList[position]
        tabs.name?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return tagsList.size
    }
    
}