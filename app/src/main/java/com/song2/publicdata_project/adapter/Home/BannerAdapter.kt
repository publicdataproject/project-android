package com.song2.publicdata_project.adapter.Home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.bumptech.glide.Glide
import com.song2.publicdata_project.R
import com.song2.publicdata_project.model.Home.Banner

class BannerAdapter(context: Context, itemList: List<Banner>, isInfinite: Boolean) : ViewPagerAdapter<Int>(context, itemList, isInfinite) {
    override fun inflateView(viewType: Int, listPosition: Int): View {
        return LayoutInflater.from(context).inflate(R.layout.home_fragment_banner, null)
    }

    override fun bindView(view: View?, position: Int, viewType: Int) {
        Glide.with(this.context)
            .load(itemList[position].bannerImage)
//            .apply(RequestOptions().placeholder(R.drawable.loading_big_image))
            .into(view!!.findViewById(R.id.iv_home_banner))
    }
}