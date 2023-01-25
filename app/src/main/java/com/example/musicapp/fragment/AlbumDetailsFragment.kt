package com.example.musicapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.musicapp.MainActivity
import com.example.musicapp.databinding.FragmentAlbumDetailsBinding
import com.example.musicapp.fragment.adapters.AlbamInfoAdapterAdapter
import com.example.musicapp.viewmodels.MainViewModel

class AlbumDetailsFragment : Fragment() {

    lateinit var binding: FragmentAlbumDetailsBinding

    private val viewModel: MainViewModel by viewModels()

    companion object{
        var receviedAlbam :String?=null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            receviedAlbam = it.getString("name")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumDetailsBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


       /* val tag = TagInfoRequestModel()
        tag.api_key = MainActivity.apiToken
        tag.album = "The Bends"
        tag.artist = "radiohead"
        tag.format = "json"
        tag.method = "album.getinfo"*/

        binding.ivakcArro.setOnClickListener {
            findNavController().navigateUp()
        }


        val option : HashMap<String,String> = HashMap()
        option["method"] = "album.search"
        option["album"] = receviedAlbam.toString()
        option["format"] = "json"

        viewModel.setAlbamInfoRequest(MainActivity.apiToken,option)

        initObeser()
    }

    private fun initObeser() {
        viewModel.getAlbamInfoResponse().observe(viewLifecycleOwner){
            if (it!=null){
                Glide.with(binding.root)
                    .load(it.results.albummatches.album[0].image.get(2).text) // image url
                    .into(binding.imBackground);
                binding.tvTitle.text = it.results.attr.forX
                val adapter = AlbamInfoAdapterAdapter(it.results.albummatches.album)
                binding.rvSabList.adapter = adapter
                binding.rvSabList.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                adapter.notifyDataSetChanged()
            }
        }
    }


}