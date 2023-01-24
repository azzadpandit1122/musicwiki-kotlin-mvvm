package com.example.musicapp.fragment.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabPagerAdapter : FragmentPagerAdapter {

    private val tabFragmentList = ArrayList<Fragment>()
    private val tabTitleList = ArrayList<String>()

    constructor(fragmentManager: FragmentManager) : super(fragmentManager)

    override fun getItem(position: Int): Fragment {

        // set argument
        val args = Bundle()
        args.putString("arg_title", tabTitleList.get(position))

        // init fragment
        val fragment = tabFragmentList.get(position)
        fragment.arguments = args

        return fragment
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