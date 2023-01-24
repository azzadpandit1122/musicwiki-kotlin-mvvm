package com.example.musicapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.musicapp.MainActivity
import com.example.musicapp.R
import com.example.musicapp.databinding.FragmentWelcomeBinding
import com.example.musicapp.fragment.adapters.TagsAdapter
import com.example.musicapp.models.TagRequestModel
import com.example.musicapp.viewmodels.MainViewModel
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent

class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tag = TagRequestModel()
        tag.method = "album.gettoptags"
        tag.artist = "radiohead"
        tag.album = "the%20bends"
        tag.api_key = MainActivity.apiToken
        tag.format = "json"

        viewModel.setTagsRequest(tag)
        initOberser()

    }

    private fun initOberser() {
        viewModel.getTagsListResponse().observe(viewLifecycleOwner) {
            if (it!=null){
                val adapter = it.toptags?.let { it1 -> TagsAdapter(this,it1.tag) }
                binding.rvTagsList.adapter = adapter
//                binding.rvTagsList.layoutManager = GridLayoutManager(context,3)
                val layoutManager = FlexboxLayoutManager(context)
                layoutManager.flexDirection = FlexDirection.ROW_REVERSE
                layoutManager.justifyContent = JustifyContent.CENTER
                binding.rvTagsList.layoutManager = layoutManager
                if (adapter != null) {
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

    fun setOnCLikListner(tabs: String) {
        if (tabs!=null){
            val args = Bundle()
            args.putString("tabs", tabs)
            findNavController().navigate(R.id.dashboardFragment,args)
        }
    }


}