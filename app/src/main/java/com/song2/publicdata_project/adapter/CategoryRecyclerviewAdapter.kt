package com.song2.publicdata_project.adapter

import android.content.Context
import android.content.Intent
import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.github.pavlospt.CircleView
import com.song2.publicdata_project.Data.CategoryData
import com.song2.publicdata_project.ProductListActivity
import com.song2.publicdata_project.R

class CategoryRecyclerviewAdapter(val ctx : Context, val dataList : ArrayList<CategoryData>) : RecyclerView.Adapter<CategoryRecyclerviewAdapter.Holder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view : View = LayoutInflater.from(ctx).inflate(R.layout.item_category, viewGroup, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {

        Glide.with(ctx)
            .load(dataList[position].categoryImg)
            .centerCrop()
            .into(holder.category_img)

        holder.category_name.text = dataList[position].categoryTitle

        var intent = Intent(ctx, ProductListActivity::class.java)
        holder.container.setOnClickListener {
            ctx.startActivity(intent)
        }

    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var container = itemView.findViewById(R.id.rl_top10_item_container) as RelativeLayout
        var category_img  = itemView.findViewById(R.id.iv_top10_item_kinds_img) as ImageView
        var category_name = itemView.findViewById(R.id.tv_top10_item_song_kinds) as TextView
    }
}