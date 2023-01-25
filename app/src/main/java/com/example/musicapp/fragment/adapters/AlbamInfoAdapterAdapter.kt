package com.example.musicapp.fragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicapp.databinding.TagLayoutBinding
import com.example.musicapp.models.albaminfoResponse.Album

class AlbamInfoAdapterAdapter(var tagsList: List<Album>) : RecyclerView.Adapter<AlbamInfoAdapterAdapter.AlbamInfoViewHolder>() {

//    var tab = tab1Fragment
    private lateinit var binding: TagLayoutBinding

    inner class AlbamInfoViewHolder(private val binding: TagLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tabs: Album) {
            binding.tabId.text = tabs.name

           /* Glide.with(binding.root)
                .load(tabs.image[2].text) // image url
                .into(binding.ivImage);  // imageview object*/
            /*binding.root.setOnClickListener {
                tab?.setOnCLikListner(tabs)
            }*/
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbamInfoViewHolder {
        binding = TagLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlbamInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbamInfoViewHolder, position: Int) {
        val tabs = tagsList[position]
        holder.bind(tabs)
    }

    override fun getItemCount(): Int {
        return tagsList.size
    }
    
}