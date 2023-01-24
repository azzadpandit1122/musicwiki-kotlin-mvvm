package com.example.musicapp.fragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicapp.databinding.AlbamLayoutBinding
import com.example.musicapp.models.tagInfoRespons.Tag

class AlbamAdapter( private var tagsList: ArrayList<Tag>) : RecyclerView.Adapter<AlbamAdapter.AlbamViewHolder>() {


    private lateinit var binding: AlbamLayoutBinding

    inner class AlbamViewHolder(private val binding: AlbamLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tabs: String) {
//            binding.tvTitle.text =
            binding.root.setOnClickListener {
//                WF?.setOnCLikListner(tabs)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbamViewHolder {
        binding = AlbamLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlbamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbamViewHolder, position: Int) {
        val tabs = tagsList[position]
        tabs.name?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return tagsList.size
    }
    
}