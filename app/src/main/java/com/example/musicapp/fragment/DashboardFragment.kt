package com.example.musicapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener
import androidx.viewpager.widget.ViewPager.VISIBLE
import com.example.musicapp.MainActivity
import com.example.musicapp.databinding.FragmentDashboardBinding
import com.example.musicapp.fragment.adapters.TabPagerAdapter
import com.example.musicapp.models.TagInfoRequestModel
import com.example.musicapp.viewmodels.MainViewModel
import com.google.android.material.tabs.TabLayout

class DashboardFragment : Fragment(){

    companion object{
        var selectedTabs:String?=""
    }
    lateinit var binding:FragmentDashboardBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            selectedTabs = it.getString("tabs")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(layoutInflater)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // init ViewPager
        initViewPager()
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        val tag = TagInfoRequestModel()
        tag.api_key = MainActivity.apiToken
        tag.album = "The Bends"
        tag.artist = "radiohead"
        tag.format = "json"
        tag.method = "album.getinfo"

        val option : HashMap<String,String> = HashMap()
            option["method"] = tag.method.toString()
            option["artist"] = tag.artist.toString()
            option["album"] = tag.album.toString()
            option["format"] = tag.format.toString()

        viewModel.setTagInfoRequest(tag,option)

        initOberser()
    }

    private fun initOberser() {
        viewModel.getTagInfoResponse().observe(viewLifecycleOwner){
            if (it!=null){
                binding.tvTitle.text = selectedTabs
                binding.tvDetails.text = it.album.wiki.content
            }
        }
    }

    private fun initViewPager() {
        // init the adapter
        val adapter = TabPagerAdapter(childFragmentManager)
        // init the fragments
        adapter.addFragment(Tab1Fragment(), "Albams")
        adapter.addFragment(Tab2Fragment(), "Artist")
        adapter.addFragment(Tab3Fragment(), "Track")
        // set adapter to ViewPager
        adapter.also { binding.viewPager.adapter = it }
    }


    fun HideTextDeails(){
        binding.tvTitle.visibility = View.GONE
        binding.tvDetails.visibility = View.GONE
    }
    fun ShowTextDeails(){
        binding.tvTitle.visibility = View.GONE
        binding.tvDetails.visibility = View.GONE
    }


}