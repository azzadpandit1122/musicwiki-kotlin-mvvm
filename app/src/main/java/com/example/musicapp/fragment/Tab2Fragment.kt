package com.example.musicapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musicapp.MainActivity
import com.example.musicapp.R
import com.example.musicapp.databinding.FragmentTab2Binding
import com.example.musicapp.fragment.adapters.ArtistsAdapter
import com.example.musicapp.viewmodels.MainViewModel

class Tab2Fragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    lateinit var binding: FragmentTab2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTab2Binding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val optionArtis: HashMap<String, String> = HashMap()
        optionArtis["tag"] = DashboardFragment.selectedTabs.toString()
        optionArtis["format"] = "json"
        optionArtis["method"] = "tag.gettopartists"

        viewModel.setArtisitRequest(MainActivity.apiToken, optionArtis)


        initObersver()
    }

    private fun initObersver() {
        viewModel.getArtisitResponse().observe(viewLifecycleOwner) {
            if (it != null) {
                val adapter = ArtistsAdapter(it.topartists.artist)
                binding.rvArtistsList.adapter = adapter
                binding.rvArtistsList.layoutManager = GridLayoutManager(context, 2)
                adapter.notifyDataSetChanged()
            }
        }
    }


}