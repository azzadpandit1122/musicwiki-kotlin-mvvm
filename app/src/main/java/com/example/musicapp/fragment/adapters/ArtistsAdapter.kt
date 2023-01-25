package com.example.musicapp.fragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicapp.databinding.AlbamLayoutBinding
import com.example.musicapp.fragment.Tab2Fragment
import com.example.musicapp.models.albamRsponse.Album
import com.example.musicapp.models.artistsResponse.Artist
import kotlinx.coroutines.withContext

class ArtistsAdapter(private var tagsList: List<Artist>,var tab2Fragment: Tab2Fragment) : RecyclerView.Adapter<ArtistsAdapter.ArtistsViewHolder>() {

    var WF: Tab2Fragment = tab2Fragment
    private lateinit var binding: AlbamLayoutBinding

    inner class ArtistsViewHolder(private val binding: AlbamLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tabs: Artist) {
            binding.tvTitle.text = tabs.name
            Glide.with(binding.root)
                .load(tabs.image[2].text) // image url
                .into(binding.ivImage);  // imageview object
            binding.root.setOnClickListener {
                WF.setOnClickListner(tabs.name)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistsViewHolder {
        binding = AlbamLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArtistsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistsViewHolder, position: Int) {
        val tabs = tagsList[position]
        holder.bind(tabs)
    }

    override fun getItemCount(): Int {
        return tagsList.size
    }
    
}