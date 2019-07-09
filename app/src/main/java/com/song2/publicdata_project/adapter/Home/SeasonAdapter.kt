package com.song2.publicdata_project.adapter.Home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.song2.publicdata_project.R
import com.song2.publicdata_project.model.Home.SeasonFruits
import de.hdodenhof.circleimageview.CircleImageView


class SeasonAdapter(val _context: Context, val dataList : ArrayList<SeasonFruits>) : RecyclerView.Adapter<SeasonAdapter.SeasonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonViewHolder {
        val convertView = LayoutInflater.from(_context).inflate(R.layout.row_home_season, parent, false)
        return SeasonViewHolder(convertView)
    }

    override fun onBindViewHolder(holder: SeasonViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(dataList[position].fruitsImage)
            .into(holder.seasonImage)

        holder.seasonName.text = dataList[position].fruitsName


    }

    override fun getItemCount(): Int = dataList.size


    inner class SeasonViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        var seasonImage: CircleImageView = view?.findViewById(R.id.iv_home_season) as CircleImageView
        var seasonName: TextView = view?.findViewById(R.id.tv_home_season) as TextView

    }
}