package com.song2.publicdata_project.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.song2.publicdata_project.Data.ShopListData
import com.song2.publicdata_project.R

class ShopListRecyclerViewAdapter(val ctx : Context, val dataList : ArrayList<ShopListData>) : RecyclerView.Adapter<ShopListRecyclerViewAdapter.Holder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view : View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_shop_list, viewGroup, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Glide.with(ctx)
            .load(dataList[position].shop_img)
            .into(holder.shop_img)
        holder.shop_name.text = dataList[position].shop_name
        holder.shop_location.text = dataList[position].shop_location

    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var contatiner = itemView.findViewById(R.id.rl_item_container) as RelativeLayout
        var shop_img  = itemView.findViewById(R.id.iv_item_shop_img) as ImageView
        var shop_name = itemView.findViewById(R.id.tv_item_shop_name) as TextView
        var shop_location = itemView.findViewById(R.id.tv_item_shop_location) as TextView
    }
}