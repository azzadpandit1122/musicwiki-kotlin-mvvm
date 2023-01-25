package com.example.musicapp.fragment.adapters

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.musicapp.fragment.*

class TabPagerAdapter : FragmentPagerAdapter {

    private val tabFragmentList = ArrayList<Fragment>()
    private val tabTitleList = ArrayList<String>()

    constructor(fragmentManager: FragmentManager) : super(fragmentManager)

    override fun getItem(position: Int): Fragment {


        /*Log.e("TAG", "getItem: current frgment "+position )
        // set argument
        val args = Bundle()
        args.putString("arg_title", tabTitleList.get(position))
        // init fragment
        val fragment = tabFragmentList.get(position)
        fragment.arguments = args
        return fragment
        */
        when (position) {
            0 -> return Tab1Fragment()
            1 -> return Tab2Fragment()
            2 -> return Tab3Fragment()
        }
        return Tab1Fragment()

    }

    override fun getCount(): Int {
        return tabFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitleList.get(position)
    }

    fun addFragment(fragment: Fragment, title: String) {
        tabFragmentList.add(fragment)
        tabTitleList.add(title)
    }
}