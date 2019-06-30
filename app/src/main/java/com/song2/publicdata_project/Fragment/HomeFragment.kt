package com.song2.publicdata_project.Fragment


import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.*

import com.song2.publicdata_project.R

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val convertView = inflater.inflate(R.layout.fragment_home, container, false)

        with(convertView){

        }

        return convertView
    }
    override fun onResume() {
        super.onResume()

    }

    inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager), Parcelable {
        private val mFragmentList = ArrayList<Fragment>()


        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment) {
            mFragmentList.add(fragment)
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {

        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<ViewPagerAdapter> {
            override fun createFromParcel(parcel: Parcel): ViewPagerAdapter {
                return ViewPagerAdapter(parcel)
            }

            override fun newArray(size: Int): Array<ViewPagerAdapter?> {
                return arrayOfNulls(size)
            }
        }

    }

}
