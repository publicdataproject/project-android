package com.song2.publicdata_project.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.song2.publicdata_project.Fragment.HomeFragment
import com.song2.publicdata_project.Fragment.MypageFragment
import com.song2.publicdata_project.Fragment.ProgressFragment
import com.song2.publicdata_project.Fragment.ShopFragment

class MainPagerAdapter(fm: FragmentManager?, private val fragment_num : Int): FragmentStatePagerAdapter(fm) {
    override fun getItem(p0: Int): Fragment? {
        return when (p0){
            0-> HomeFragment()
            1-> ShopFragment()
            2-> ProgressFragment()
            3-> MypageFragment()
            else -> null
        }
    }

    override fun getCount(): Int {
        return fragment_num
    }


}