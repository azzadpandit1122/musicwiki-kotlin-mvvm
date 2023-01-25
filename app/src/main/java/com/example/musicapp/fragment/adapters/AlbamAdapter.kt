package com.example.musicapp.fragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicapp.databinding.AlbamLayoutBinding
import com.example.musicapp.fragment.Tab1Fragment
import com.example.musicapp.models.albamRsponse.Album
import kotlinx.coroutines.withContext

class AlbamAdapter(private var tagsList: List<Album>, tab1Fragment: Tab1Fragment) : RecyclerView.Adapter<AlbamAdapter.AlbamViewHolder>() {

    var tab = tab1Fragment
    private lateinit var binding: AlbamLayoutBinding

    inner class AlbamViewHolder(private val binding: AlbamLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tabs: Album) {
            binding.tvTitle.text = tabs.artist.name
            Glide.with(binding.root)
                .load(tabs.image[2].text) // image url
                .into(binding.ivImage);  // imageview object
            binding.root.setOnClickListener {
                tab?.setOnCLikListner(tabs)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbamViewHolder {
        binding = AlbamLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlbamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbamViewHolder, position: Int) {
        val tabs = tagsList[position]
        holder.bind(tabs)
    }

    override fun getItemCount(): Int {
        return tagsList.size
    }
    
}