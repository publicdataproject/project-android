package com.song2.publicdata_project.adapter.Home

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.song2.publicdata_project.R
import com.song2.publicdata_project.model.Home.Banner

class BannerAdapter(val context : Context, var bannerList : ArrayList<Banner>):PagerAdapter() {
    private val inflater : LayoutInflater

    init {
       inflater = LayoutInflater.from(context)
   }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layout = inflater.inflate(R.layout.home_fragment_banner,container,false)!!

        val img : ImageView = layout.findViewById(R.id.iv_home_banner)

        Glide.with(context).load(bannerList[position].bannerImage).into(img)

        container.addView(layout,0)

        return layout
    }

    override fun isViewFromObject(view: View, p1 : Any): Boolean {
        return view == p1
    }

    override fun getCount(): Int {
        return bannerList.size
    }





}