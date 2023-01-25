package com.example.musicapp.fragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicapp.databinding.AlbamLayoutBinding
import com.example.musicapp.models.trackResponse.Track

class TrackAdapter(private var tagsList: List<Track>) : RecyclerView.Adapter<TrackAdapter.TrackViewHolder>() {


    private lateinit var binding: AlbamLayoutBinding

    inner class TrackViewHolder(private val binding: AlbamLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tabs: Track) {
            binding.tvTitle.text = tabs.artist.name
            Glide.with(binding.root)
                .load(tabs.image[2].text) // image url
                .into(binding.ivImage);  // imageview object
            binding.root.setOnClickListener {
//                WF?.setOnCLikListner(tabs)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        binding = AlbamLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrackViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        val tabs = tagsList[position]
        holder.bind(tabs)
    }

    override fun getItemCount(): Int {
        return tagsList.size
    }
    
}