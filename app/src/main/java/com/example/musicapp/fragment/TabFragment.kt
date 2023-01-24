package com.example.musicapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicapp.MainActivity
import com.example.musicapp.databinding.FragmentTabBinding
import com.example.musicapp.fragment.adapters.AlbamAdapter
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

        val option: HashMap<String, String> = HashMap()
        option["method"] = "tag.gettopalbums"
        option["tag"] = DashboardFragment.selectedTabs.toString()
        option["format"] = "json"

        if (title.equals("Albams")) {
            viewModel.setAlbamsRequest(MainActivity.apiToken, option)
        }
        initObeser()
    }

    private fun initObeser() {
        viewModel.getAlbamResponse().observe(viewLifecycleOwner) {
            if (it != null) {
                val adapter = AlbamAdapter(it.albums.album)
                binding.rvList.adapter = adapter
                binding.rvList.layoutManager = GridLayoutManager(context,2)
                adapter.notifyDataSetChanged()
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

data class requestModel(
    var method: String? = null,
    var tag: String? = null,
    var api_key: String? = null,
    var format: String? = null
)