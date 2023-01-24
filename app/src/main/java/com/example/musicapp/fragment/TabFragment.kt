package com.example.musicapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musicapp.R
import com.example.musicapp.databinding.FragmentTabBinding

class TabFragment : Fragment() {

    lateinit var binding: FragmentTabBinding
    var title :String?=""

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

    }
    companion object {
        fun newInstance(title: String): Fragment {

            // set argument
            val args = Bundle()
            args.putString("arg_title", title)

            // init fragment
            val fragment = TabFragment()
            fragment.arguments = args

            return fragment
        }
    }
}