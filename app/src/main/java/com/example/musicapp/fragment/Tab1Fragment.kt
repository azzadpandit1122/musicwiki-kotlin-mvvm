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
import com.example.musicapp.databinding.FragmentTab1Binding
import com.example.musicapp.fragment.adapters.AlbamAdapter
import com.example.musicapp.viewmodels.MainViewModel

class Tab1Fragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    lateinit var binding: FragmentTab1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTab1Binding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val optionAlbm: HashMap<String, String> = HashMap()
        optionAlbm["tag"] = DashboardFragment.selectedTabs.toString()
        optionAlbm["format"] = "json"
        optionAlbm["method"] = "tag.gettopalbums"

        viewModel.setAlbamsRequest(MainActivity.apiToken, optionAlbm)

        initOberver()
    }

    private fun initOberver() {
        viewModel.getAlbamResponse().observe(viewLifecycleOwner) {
            if (it != null) {
                val adapter = AlbamAdapter(it.albums.album)
                binding.rvAlbamList.adapter = adapter
                binding.rvAlbamList.layoutManager = GridLayoutManager(context, 2)
                adapter.notifyDataSetChanged()
            }
        }
    }


}