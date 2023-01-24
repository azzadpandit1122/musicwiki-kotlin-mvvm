package com.example.musicapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musicapp.MainActivity
import com.example.musicapp.databinding.FragmentTabBinding
import com.example.musicapp.fragment.adapters.AlbamAdapter
import com.example.musicapp.fragment.adapters.ArtistsAdapter
import com.example.musicapp.viewmodels.MainViewModel

class TabFragment : Fragment() {

    lateinit var binding: FragmentTabBinding
    var title: String? = ""

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString("arg_title")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTabBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.tvTitle.text = title
        val optionAlbm: HashMap<String, String> = HashMap()
        optionAlbm["tag"] = DashboardFragment.selectedTabs.toString()
        optionAlbm["format"] = "json"
        optionAlbm["method"] = "tag.gettopalbums"

        val optionArtis: HashMap<String, String> = HashMap()
        optionArtis["tag"] = DashboardFragment.selectedTabs.toString()
        optionArtis["format"] = "json"
        optionArtis["method"] = "tag.gettopartists"

        if (title.equals("Albams")) {
            viewModel.setAlbamsRequest(MainActivity.apiToken, optionAlbm)
        }else if (title.equals("Artist")){
            viewModel.setArtisitRequest(MainActivity.apiToken, optionArtis)
        }
        initObeser()
    }

    private fun initObeser() {
        viewModel.getAlbamResponse().observe(viewLifecycleOwner) {
            if (it != null) {
                if (title.equals("Albams")){
                    binding.rvAlbamList.visibility = View.VISIBLE
                    binding.rvTrackList.visibility = View.GONE
                    binding.rvArtistsList.visibility = View.GONE
                }
                val adapter = AlbamAdapter(it.albums.album)
                binding.rvAlbamList.adapter = adapter
                binding.rvAlbamList.layoutManager = GridLayoutManager(context,2)
                adapter.notifyDataSetChanged()
            }
        }

        viewModel.getArtisitResponse().observe(viewLifecycleOwner){
            if (it!=null){
                if (title.equals("Artist")){
                    binding.rvAlbamList.visibility = View.GONE
                    binding.rvTrackList.visibility = View.GONE
                    binding.rvArtistsList.visibility = View.VISIBLE
                    val adapter = ArtistsAdapter(it.topartists.artist)
                    binding.rvArtistsList.adapter = adapter
                    binding.rvArtistsList.layoutManager = GridLayoutManager(context,2)
                    adapter.notifyDataSetChanged()
                }

            }
        }
    }
    /*companion object {
        fun newInstance(title: String): Fragment {

            // set argument
            val args = Bundle()
            args.putString("arg_title", title)

            // init fragment
            val fragment = TabFragment()
            fragment.arguments = args

            return fragment
        }
    }*/

}
