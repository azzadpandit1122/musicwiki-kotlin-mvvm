package com.example.musicapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.musicapp.MainActivity
import com.example.musicapp.databinding.FragmentDashboardBinding
import com.example.musicapp.fragment.adapters.TabPagerAdapter
import com.example.musicapp.models.TagInfoRequestModel
import com.example.musicapp.viewmodels.MainViewModel

class DashboardFragment : Fragment() {

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
        Toast.makeText(activity,""+selectedTabs,Toast.LENGTH_SHORT).show();


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
        adapter.addFragment(TabFragment(), "Albams")
        adapter.addFragment(TabFragment(), "Romance")
        adapter.addFragment(TabFragment(), "Sci-fi")

        // set adapter to ViewPager
        adapter.also { binding.viewPager.adapter = it }
    }
}