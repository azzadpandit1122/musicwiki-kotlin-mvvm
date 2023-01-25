package com.example.musicapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.musicapp.MainActivity
import com.example.musicapp.R
import com.example.musicapp.databinding.FragmentAlbumDetailsBinding
import com.example.musicapp.models.TagInfoRequestModel
import com.example.musicapp.models.albamRsponse.Album
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
                binding.tvTitle.text = it.results.attr.forX
            }
        }
    }


}